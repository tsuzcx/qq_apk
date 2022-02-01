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
    Intent localIntent = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(paramListenerRecord.componentName);
    paramListenerRecord.bound = this.mContext.bindService(localIntent, this, 33);
    if (paramListenerRecord.bound) {
      paramListenerRecord.retryCount = 0;
    }
    for (;;)
    {
      return paramListenerRecord.bound;
      Log.w("NotifManCompat", "Unable to bind to listener " + paramListenerRecord.componentName);
      this.mContext.unbindService(this);
    }
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
    if (Log.isLoggable("NotifManCompat", 3)) {
      Log.d("NotifManCompat", "Processing component " + paramListenerRecord.componentName + ", " + paramListenerRecord.taskQueue.size() + " queued tasks");
    }
    if (paramListenerRecord.taskQueue.isEmpty()) {}
    do
    {
      return;
      if ((!ensureServiceBound(paramListenerRecord)) || (paramListenerRecord.service == null))
      {
        scheduleListenerRetry(paramListenerRecord);
        return;
      }
      try
      {
        Object localObject;
        do
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Sending task " + localObject);
          }
          ((NotificationManagerCompat.Task)localObject).send(paramListenerRecord.service);
          paramListenerRecord.taskQueue.remove();
          localObject = (NotificationManagerCompat.Task)paramListenerRecord.taskQueue.peek();
        } while (localObject != null);
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;)
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Remote service has died: " + paramListenerRecord.componentName);
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.w("NotifManCompat", "RemoteException communicating with " + paramListenerRecord.componentName, localRemoteException);
        }
      }
    } while (paramListenerRecord.taskQueue.isEmpty());
    scheduleListenerRetry(paramListenerRecord);
  }
  
  private void scheduleListenerRetry(NotificationManagerCompat.SideChannelManager.ListenerRecord paramListenerRecord)
  {
    if (this.mHandler.hasMessages(3, paramListenerRecord.componentName)) {
      return;
    }
    paramListenerRecord.retryCount += 1;
    if (paramListenerRecord.retryCount > 6)
    {
      Log.w("NotifManCompat", "Giving up on delivering " + paramListenerRecord.taskQueue.size() + " tasks to " + paramListenerRecord.componentName + " after " + paramListenerRecord.retryCount + " retries");
      paramListenerRecord.taskQueue.clear();
      return;
    }
    int i = (1 << paramListenerRecord.retryCount - 1) * 1000;
    if (Log.isLoggable("NotifManCompat", 3)) {
      Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
    }
    paramListenerRecord = this.mHandler.obtainMessage(3, paramListenerRecord.componentName);
    this.mHandler.sendMessageDelayed(paramListenerRecord, i);
  }
  
  private void updateListenerMap()
  {
    Object localObject1 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
    if (((Set)localObject1).equals(this.mCachedEnabledPackages)) {}
    for (;;)
    {
      return;
      this.mCachedEnabledPackages = ((Set)localObject1);
      Object localObject2 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
      HashSet localHashSet = new HashSet();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject2).next();
        if (((Set)localObject1).contains(localResolveInfo.serviceInfo.packageName))
        {
          ComponentName localComponentName = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
          if (localResolveInfo.serviceInfo.permission != null) {
            Log.w("NotifManCompat", "Permission present on component " + localComponentName + ", not adding listener record.");
          } else {
            localHashSet.add(localComponentName);
          }
        }
      }
      localObject1 = localHashSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComponentName)((Iterator)localObject1).next();
        if (!this.mRecordMap.containsKey(localObject2))
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Adding listener record for " + localObject2);
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
          if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Removing listener record for " + ((Map.Entry)localObject2).getKey());
          }
          ensureServiceUnbound((NotificationManagerCompat.SideChannelManager.ListenerRecord)((Map.Entry)localObject2).getValue());
          ((Iterator)localObject1).remove();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      handleQueueTask((NotificationManagerCompat.Task)paramMessage.obj);
      return true;
    case 1: 
      paramMessage = (NotificationManagerCompat.ServiceConnectedEvent)paramMessage.obj;
      handleServiceConnected(paramMessage.componentName, paramMessage.iBinder);
      return true;
    case 2: 
      handleServiceDisconnected((ComponentName)paramMessage.obj);
      return true;
    }
    handleRetryListenerQueue((ComponentName)paramMessage.obj);
    return true;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      Log.d("NotifManCompat", "Connected to service " + paramComponentName);
    }
    this.mHandler.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(paramComponentName, paramIBinder)).sendToTarget();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      Log.d("NotifManCompat", "Disconnected from service " + paramComponentName);
    }
    this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
  }
  
  public void queueTask(NotificationManagerCompat.Task paramTask)
  {
    this.mHandler.obtainMessage(0, paramTask).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.NotificationManagerCompat.SideChannelManager
 * JD-Core Version:    0.7.0.1
 */