package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class NotificationManagerCompat$SideChannelManager
  implements ServiceConnection, Handler.Callback
{
  private static final int MSG_QUEUE_TASK = 0;
  private static final int MSG_RETRY_LISTENER_QUEUE = 3;
  private static final int MSG_SERVICE_CONNECTED = 1;
  private static final int MSG_SERVICE_DISCONNECTED = 2;
  private Set<String> mCachedEnabledPackages = new HashSet();
  private final Context mContext;
  private final Handler mHandler;
  private final HandlerThread mHandlerThread;
  private final Map<ComponentName, NotificationManagerCompat.SideChannelManager.ListenerRecord> mRecordMap = new HashMap();
  
  NotificationManagerCompat$SideChannelManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
  }
  
  private boolean ensureServiceBound(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (paramListenerRecord.bound) {
      return true;
    }
    Object localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(paramListenerRecord.componentName);
    paramListenerRecord.bound = this.mContext.bindService((Intent)localObject, this, 33);
    if (paramListenerRecord.bound)
    {
      paramListenerRecord.retryCount = 0;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unable to bind to listener ");
      ((StringBuilder)localObject).append(paramListenerRecord.componentName);
      Log.w("NotifManCompat", ((StringBuilder)localObject).toString());
      this.mContext.unbindService(this);
    }
    return paramListenerRecord.bound;
  }
  
  private void ensureServiceUnbound(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (paramListenerRecord.bound)
    {
      this.mContext.unbindService(this);
      paramListenerRecord.bound = false;
    }
    paramListenerRecord.service = null;
  }
  
  private void handleQueueTask(NotificationManagerCompat.Task paramTask)
  {
    updateListenerMap();
    Iterator localIterator = this.mRecordMap.values().iterator();
    while (localIterator.hasNext())
    {
      NotificationManagerCompat.SideChannelManager.ListenerRecord localListenerRecord = (NotificationManagerCompat.SideChannelManager.ListenerRecord)localIterator.next();
      localListenerRecord.taskQueue.add(paramTask);
      processListenerQueue(localListenerRecord);
    }
  }
  
  private void handleRetryListenerQueue(ComponentName paramComponentName)
  {
    paramComponentName = (NotificationManagerCompat.SideChannelManager.ListenerRecord)this.mRecordMap.get(paramComponentName);
    if (paramComponentName != null) {
      processListenerQueue(paramComponentName);
    }
  }
  
  private void handleServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    paramComponentName = (NotificationManagerCompat.SideChannelManager.ListenerRecord)this.mRecordMap.get(paramComponentName);
    if (paramComponentName != null)
    {
      paramComponentName.service = INotificationSideChannel.Stub.asInterface(paramIBinder);
      paramComponentName.retryCount = 0;
      processListenerQueue(paramComponentName);
    }
  }
  
  private void handleServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = (NotificationManagerCompat.SideChannelManager.ListenerRecord)this.mRecordMap.get(paramComponentName);
    if (paramComponentName != null) {
      ensureServiceUnbound(paramComponentName);
    }
  }
  
  private void processListenerQueue(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    Object localObject;
    if (Log.isLoggable("NotifManCompat", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Processing component ");
      ((StringBuilder)localObject).append(paramListenerRecord.componentName);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramListenerRecord.taskQueue.size());
      ((StringBuilder)localObject).append(" queued tasks");
      Log.d("NotifManCompat", ((StringBuilder)localObject).toString());
    }
    if (paramListenerRecord.taskQueue.isEmpty()) {
      return;
    }
    if ((ensureServiceBound(paramListenerRecord)) && (paramListenerRecord.service != null)) {}
    for (;;)
    {
      localObject = (NotificationManagerCompat.Task)paramListenerRecord.taskQueue.peek();
      if (localObject != null) {}
      try
      {
        if (Log.isLoggable("NotifManCompat", 3))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("Sending task ");
          localStringBuilder2.append(localObject);
          Log.d("NotifManCompat", localStringBuilder2.toString());
        }
        ((NotificationManagerCompat.Task)localObject).send(paramListenerRecord.service);
        paramListenerRecord.taskQueue.remove();
      }
      catch (RemoteException localRemoteException)
      {
        break label184;
        break label222;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("RemoteException communicating with ");
        localStringBuilder2.append(paramListenerRecord.componentName);
        Log.w("NotifManCompat", localStringBuilder2.toString(), localRemoteException);
        break label265;
        if (Log.isLoggable("NotifManCompat", 3))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Remote service has died: ");
          localStringBuilder1.append(paramListenerRecord.componentName);
          Log.d("NotifManCompat", localStringBuilder1.toString());
        }
        label265:
        if (!paramListenerRecord.taskQueue.isEmpty()) {
          scheduleListenerRetry(paramListenerRecord);
        }
        return;
        scheduleListenerRetry(paramListenerRecord);
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        label181:
        label184:
        label222:
        break label181;
      }
    }
  }
  
  private void scheduleListenerRetry(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (this.mHandler.hasMessages(3, paramListenerRecord.componentName)) {
      return;
    }
    paramListenerRecord.retryCount += 1;
    StringBuilder localStringBuilder;
    if (paramListenerRecord.retryCount > 6)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Giving up on delivering ");
      localStringBuilder.append(paramListenerRecord.taskQueue.size());
      localStringBuilder.append(" tasks to ");
      localStringBuilder.append(paramListenerRecord.componentName);
      localStringBuilder.append(" after ");
      localStringBuilder.append(paramListenerRecord.retryCount);
      localStringBuilder.append(" retries");
      Log.w("NotifManCompat", localStringBuilder.toString());
      paramListenerRecord.taskQueue.clear();
      return;
    }
    int i = (1 << paramListenerRecord.retryCount - 1) * 1000;
    if (Log.isLoggable("NotifManCompat", 3))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Scheduling retry for ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ms");
      Log.d("NotifManCompat", localStringBuilder.toString());
    }
    paramListenerRecord = this.mHandler.obtainMessage(3, paramListenerRecord.componentName);
    this.mHandler.sendMessageDelayed(paramListenerRecord, i);
  }
  
  private void updateListenerMap()
  {
    Object localObject1 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
    if (((Set)localObject1).equals(this.mCachedEnabledPackages)) {
      return;
    }
    this.mCachedEnabledPackages = ((Set)localObject1);
    Object localObject2 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
    HashSet localHashSet = new HashSet();
    localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (ResolveInfo)((Iterator)localObject2).next();
      if (((Set)localObject1).contains(((ResolveInfo)localObject4).serviceInfo.packageName))
      {
        localObject3 = new ComponentName(((ResolveInfo)localObject4).serviceInfo.packageName, ((ResolveInfo)localObject4).serviceInfo.name);
        if (((ResolveInfo)localObject4).serviceInfo.permission != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("Permission present on component ");
          ((StringBuilder)localObject4).append(localObject3);
          ((StringBuilder)localObject4).append(", not adding listener record.");
          Log.w("NotifManCompat", ((StringBuilder)localObject4).toString());
        }
        else
        {
          localHashSet.add(localObject3);
        }
      }
    }
    localObject1 = localHashSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ComponentName)((Iterator)localObject1).next();
      if (!this.mRecordMap.containsKey(localObject2))
      {
        if (Log.isLoggable("NotifManCompat", 3))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Adding listener record for ");
          ((StringBuilder)localObject3).append(localObject2);
          Log.d("NotifManCompat", ((StringBuilder)localObject3).toString());
        }
        this.mRecordMap.put(localObject2, new NotificationManagerCompat.SideChannelManager.ListenerRecord((ComponentName)localObject2));
      }
    }
    localObject1 = this.mRecordMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!localHashSet.contains(((Map.Entry)localObject2).getKey()))
      {
        if (Log.isLoggable("NotifManCompat", 3))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Removing listener record for ");
          ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getKey());
          Log.d("NotifManCompat", ((StringBuilder)localObject3).toString());
        }
        ensureServiceUnbound((NotificationManagerCompat.SideChannelManager.ListenerRecord)((Map.Entry)localObject2).getValue());
        ((Iterator)localObject1).remove();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          handleRetryListenerQueue((ComponentName)paramMessage.obj);
          return true;
        }
        handleServiceDisconnected((ComponentName)paramMessage.obj);
        return true;
      }
      paramMessage = (NotificationManagerCompat.ServiceConnectedEvent)paramMessage.obj;
      handleServiceConnected(paramMessage.componentName, paramMessage.iBinder);
      return true;
    }
    handleQueueTask((NotificationManagerCompat.Task)paramMessage.obj);
    return true;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("NotifManCompat", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Connected to service ");
      localStringBuilder.append(paramComponentName);
      Log.d("NotifManCompat", localStringBuilder.toString());
    }
    this.mHandler.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(paramComponentName, paramIBinder)).sendToTarget();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("NotifManCompat", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Disconnected from service ");
      localStringBuilder.append(paramComponentName);
      Log.d("NotifManCompat", localStringBuilder.toString());
    }
    this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
  }
  
  public void queueTask(NotificationManagerCompat.Task paramTask)
  {
    this.mHandler.obtainMessage(0, paramTask).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationManagerCompat.SideChannelManager
 * JD-Core Version:    0.7.0.1
 */