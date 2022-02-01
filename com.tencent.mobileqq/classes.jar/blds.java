import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyService;
import cooperation.wadl.ipc.WadlProxyServiceMonitor;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class blds
  extends bldo
  implements ServiceConnection, Handler.Callback, IBinder.DeathRecipient
{
  public static final String a;
  private final int jdField_a_of_type_Int = 100;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientMessage.Thread", 10);
  private bldj jdField_a_of_type_Bldj;
  private bldk jdField_a_of_type_Bldk;
  private List<Bundle> jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList<bldr> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int = 5000;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bldt.b + "WadlProxyServiceManager";
  }
  
  public blds()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bldj = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      bifn.a(jdField_a_of_type_JavaLangString, "storeCmdToCache there must be an error too many unproceed message!");
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBundle);
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
    }
  }
  
  private void d(Bundle paramBundle)
  {
    paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
    bifn.c(jdField_a_of_type_JavaLangString, "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (paramBundle != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bldr)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
      }
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getParcelableArrayList("query_result");
    bifn.c(jdField_a_of_type_JavaLangString, "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (localObject == null) {}
    for (paramBundle = new ArrayList();; paramBundle = (Bundle)localObject)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bldr)((Iterator)localObject).next()).onQueryCallback(paramBundle);
      }
      return;
    }
  }
  
  private void f(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    bifn.c(jdField_a_of_type_JavaLangString, "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((bldr)paramBundle.next()).onQueryCallbackVia(localArrayList);
    }
  }
  
  private void g(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    bifn.c(jdField_a_of_type_JavaLangString, "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((bldr)paramBundle.next()).onQueryCallback(localArrayList);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      bifn.c(jdField_a_of_type_JavaLangString, "resetDiedCount");
    }
    this.c = 0;
    this.jdField_a_of_type_Bldj.a(1.0F, false);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.what = paramInt;
      localMessage.sendToTarget();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    bifn.a(jdField_a_of_type_JavaLangString, 4, "send action msg cmd=" + str);
    if (!a())
    {
      bifn.a(jdField_a_of_type_JavaLangString, "postRemoteNotify start but service is not launched and start service");
      b(0);
    }
    c(paramBundle);
    d();
  }
  
  public void a(bldr parambldr)
  {
    if ((parambldr != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambldr))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambldr);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      bifn.c(jdField_a_of_type_JavaLangString, "transferAsync from Service cmd=" + paramString);
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    if (paramString != null)
    {
      if (!paramString.equals("WADL.REVERSE_HEART_CMD")) {
        break label84;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 4;
      paramString.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
    label84:
    do
    {
      return;
      if (paramString.equals("WADL.REVERSE_ACTION_CMD"))
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 3;
        paramString.setData(paramBundle);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
      if (paramString.equals("WADL.REVERSE_STOP_MONITOR_CMD"))
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 5;
        paramString.setData(paramBundle);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
    } while ((!paramString.equals("WADL.REVERSE_START_MONITOR_CMD")) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)));
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bldk != null) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      bifn.c(jdField_a_of_type_JavaLangString, "sendAsynRemoteCommandMessage mWadlService=" + this.jdField_a_of_type_Bldk + ",mServiceConnecting=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",mCacheMsg size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if ((a()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle != null)
        {
          String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          if (QLog.isColorLevel()) {
            bifn.c(jdField_a_of_type_JavaLangString, "##@sendAsynRemoteCommandMessage strNotifyCmd=" + str);
          }
          try
          {
            localBundle.setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_Bldk == null) {
              continue;
            }
            bifn.a(jdField_a_of_type_JavaLangString, 5, "send action to service cmd=" + str);
            this.jdField_a_of_type_Bldk.a("WADL.REMOTE_ACTION_CMD", localBundle);
          }
          catch (Exception localException) {}
          if ((localException instanceof DeadObjectException))
          {
            c(localBundle);
            bifn.b(jdField_a_of_type_JavaLangString, "remote service is dead", localException);
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    bifn.c(jdField_a_of_type_JavaLangString, "innerStartService start");
    if (this.jdField_a_of_type_Bldk != null) {
      if (QLog.isColorLevel()) {
        bifn.b(jdField_a_of_type_JavaLangString, "innerStartService mWadlService is working");
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
        break label134;
      }
      try
      {
        WadlProxyService.a(this);
        if (paramInt == 1)
        {
          bigb localbigb = bigb.a();
          localbigb.c = "service dlied";
          blec.a().a("204685", "999", localbigb, "dc00087");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bifn.b(jdField_a_of_type_JavaLangString, "innerStartService fail", localThrowable);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
    return;
    label134:
    bifn.c(jdField_a_of_type_JavaLangString, "innerStartService is connecting mWadlService:" + this.jdField_a_of_type_Bldk);
  }
  
  public void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      bifn.c(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke begin cmd=" + str);
    }
    if (str == null) {
      return;
    }
    try
    {
      if (str.equals("Wadl_Reverse_StartWadlService"))
      {
        a(0);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      bifn.a(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke exception", paramBundle);
      return;
    }
    if (str.equals("Wadl_Reverse_onWadlTaskStatusChanged"))
    {
      d(paramBundle);
      return;
    }
    if (str.equals("Wadl_Reverse_QnQureyResult"))
    {
      e(paramBundle);
      return;
    }
    if (str.equals("Wadl_Reverse_QnQureyResultVia"))
    {
      f(paramBundle);
      return;
    }
    if (str.equals("Wadl_Reverse_QnQureyAllTask"))
    {
      g(paramBundle);
      return;
    }
    bifn.a(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke unknow invokeCmd");
  }
  
  public void b(bldr parambldr)
  {
    if (parambldr != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambldr);
    }
  }
  
  public void binderDied()
  {
    for (;;)
    {
      try
      {
        this.c += 1;
        bifn.a(jdField_a_of_type_JavaLangString, "binderDied, diedCount=" + this.c);
        if (this.c > 9)
        {
          this.jdField_a_of_type_Bldj.a(10.0F, true);
          if (!this.jdField_a_of_type_Bldj.a()) {
            break;
          }
          bigb localbigb = bigb.a();
          localbigb.c = "service dlied";
          blec.a().a("204685", "444", localbigb, "dc00087");
          if (this.jdField_a_of_type_Bldk == null) {
            break;
          }
          this.jdField_a_of_type_Bldk.asBinder().unlinkToDeath(this, 0);
          this.jdField_a_of_type_Bldk = null;
          return;
        }
        if (this.c > 6)
        {
          this.jdField_a_of_type_Bldj.a(2.0F, true);
          continue;
        }
        if (this.c <= 3) {
          break label189;
        }
      }
      catch (Exception localException)
      {
        bifn.a(jdField_a_of_type_JavaLangString, "binderDied exception", localException);
        return;
      }
      this.jdField_a_of_type_Bldj.a(1.5F, true);
      continue;
      label189:
      this.jdField_a_of_type_Bldj.a(1.0F, true);
    }
  }
  
  void c()
  {
    bifn.c(jdField_a_of_type_JavaLangString, "destroy: " + this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Bldj.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    catch (Exception localRemoteException)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        localbldk = this.jdField_a_of_type_Bldk;
        if (localbldk == null) {}
      }
      catch (Exception localRemoteException)
      {
        try
        {
          localbldk.b(this);
          bifn.c(jdField_a_of_type_JavaLangString, "destroy unregisterCallback success");
        }
        catch (RemoteException localRemoteException)
        {
          try
          {
            for (;;)
            {
              bldk localbldk;
              localbldk.asBinder().unlinkToDeath(this, 0);
              bifn.c(jdField_a_of_type_JavaLangString, "destroy unlinkToDeath success");
              if (BaseApplicationImpl.sProcessId == 1) {}
              try
              {
                BaseApplicationImpl.getApplication().unbindService(this);
                bifn.c(jdField_a_of_type_JavaLangString, "destroy unbindService success");
                return;
              }
              catch (Exception localException4)
              {
                bifn.a(jdField_a_of_type_JavaLangString, "destroy unbindService exception", localException4);
              }
              localException1 = localException1;
              bifn.a(jdField_a_of_type_JavaLangString, "destroy clear callBackList exception", localException1);
              continue;
              localException2 = localException2;
              bifn.a(jdField_a_of_type_JavaLangString, "destroy mMessageThread.quit exception", localException2);
              continue;
              localRemoteException = localRemoteException;
              bifn.a(jdField_a_of_type_JavaLangString, "destroy unregisterCallback exception", localRemoteException);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              bifn.a(jdField_a_of_type_JavaLangString, "destroy unlinkToDeath exception", localException3);
            }
          }
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
    case 1: 
      b(paramMessage.what);
      return false;
    case 2: 
      b();
      return false;
    case 3: 
      b(paramMessage.getData());
      return false;
    case 4: 
      this.jdField_a_of_type_Bldj.a(paramMessage.getData());
      return false;
    case 5: 
      this.jdField_a_of_type_Bldj.a();
      return false;
    case 6: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_Bldj.a();
        return false;
      }
      this.jdField_a_of_type_Bldj.b();
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    bifn.c(jdField_a_of_type_JavaLangString, "reset mServiceConnecting");
    return false;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bifn.c(jdField_a_of_type_JavaLangString, "onServiceConnected success, componentName=" + paramComponentName + ",service=" + paramIBinder);
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        bifn.b(jdField_a_of_type_JavaLangString, "onServiceConnected,but this is destroy");
        return;
      }
      this.jdField_a_of_type_Bldk = bldl.a(paramIBinder);
      if (this.jdField_a_of_type_Bldk == null)
      {
        bifn.b(jdField_a_of_type_JavaLangString, "onServiceConnected,but asInterface fail");
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    this.jdField_a_of_type_Bldk.a(this);
    this.jdField_a_of_type_Bldk.asBinder().linkToDeath(this, 0);
    d();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bifn.c(jdField_a_of_type_JavaLangString, "onServiceDisconnected");
    try
    {
      if (this.jdField_a_of_type_Bldk != null) {
        this.jdField_a_of_type_Bldk.b(this);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_a_of_type_Bldk = null;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blds
 * JD-Core Version:    0.7.0.1
 */