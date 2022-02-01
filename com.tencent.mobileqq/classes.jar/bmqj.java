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

public class bmqj
  extends bmqf
  implements ServiceConnection, Handler.Callback, IBinder.DeathRecipient
{
  public static final String a;
  private final int jdField_a_of_type_Int = 100;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientMessage.Thread", 10);
  private bmqa jdField_a_of_type_Bmqa;
  private bmqb jdField_a_of_type_Bmqb;
  private List<Bundle> jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList<bmqi> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int = 5000;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmqk.b + "WadlProxyServiceManager";
  }
  
  public bmqj()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bmqa = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      bjqp.a(jdField_a_of_type_JavaLangString, "storeCmdToCache there must be an error too many unproceed message!");
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
    bjqp.c(jdField_a_of_type_JavaLangString, "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (paramBundle != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bmqi)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
      }
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getParcelableArrayList("query_result");
    bjqp.c(jdField_a_of_type_JavaLangString, "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (localObject == null) {}
    for (paramBundle = new ArrayList();; paramBundle = (Bundle)localObject)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bmqi)((Iterator)localObject).next()).onQueryCallback(paramBundle);
      }
      return;
    }
  }
  
  private void f(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    bjqp.c(jdField_a_of_type_JavaLangString, "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((bmqi)paramBundle.next()).onQueryCallbackVia(localArrayList);
    }
  }
  
  private void g(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    bjqp.c(jdField_a_of_type_JavaLangString, "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((bmqi)paramBundle.next()).onQueryCallback(localArrayList);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      bjqp.c(jdField_a_of_type_JavaLangString, "resetDiedCount");
    }
    this.c = 0;
    this.jdField_a_of_type_Bmqa.a(1.0F, false);
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
    bjqp.a(jdField_a_of_type_JavaLangString, 4, "send action msg cmd=" + str);
    if (!a())
    {
      bjqp.a(jdField_a_of_type_JavaLangString, "postRemoteNotify start but service is not launched and start service");
      b(0);
    }
    c(paramBundle);
    d();
  }
  
  public void a(bmqi parambmqi)
  {
    if ((parambmqi != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambmqi))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambmqi);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      bjqp.c(jdField_a_of_type_JavaLangString, "transferAsync from Service cmd=" + paramString);
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
    return (this.jdField_a_of_type_Bmqb != null) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      bjqp.c(jdField_a_of_type_JavaLangString, "sendAsynRemoteCommandMessage mWadlService=" + this.jdField_a_of_type_Bmqb + ",mServiceConnecting=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",mCacheMsg size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if ((a()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle != null)
        {
          String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          if (QLog.isColorLevel()) {
            bjqp.c(jdField_a_of_type_JavaLangString, "##@sendAsynRemoteCommandMessage strNotifyCmd=" + str);
          }
          try
          {
            localBundle.setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_Bmqb == null) {
              continue;
            }
            bjqp.a(jdField_a_of_type_JavaLangString, 5, "send action to service cmd=" + str);
            this.jdField_a_of_type_Bmqb.a("WADL.REMOTE_ACTION_CMD", localBundle);
          }
          catch (Exception localException) {}
          if ((localException instanceof DeadObjectException))
          {
            c(localBundle);
            bjqp.b(jdField_a_of_type_JavaLangString, "remote service is dead", localException);
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    bjqp.c(jdField_a_of_type_JavaLangString, "innerStartService start");
    if (this.jdField_a_of_type_Bmqb != null) {
      if (QLog.isColorLevel()) {
        bjqp.b(jdField_a_of_type_JavaLangString, "innerStartService mWadlService is working");
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
          bjrd localbjrd = bjrd.a();
          localbjrd.c = "service dlied";
          bmqt.a().a("204685", "999", localbjrd, "08a00036462");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bjqp.b(jdField_a_of_type_JavaLangString, "innerStartService fail", localThrowable);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
    return;
    label134:
    bjqp.c(jdField_a_of_type_JavaLangString, "innerStartService is connecting mWadlService:" + this.jdField_a_of_type_Bmqb);
  }
  
  public void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      bjqp.c(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke begin cmd=" + str);
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
      bjqp.a(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke exception", paramBundle);
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
    bjqp.a(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke unknow invokeCmd");
  }
  
  public void b(bmqi parambmqi)
  {
    if (parambmqi != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambmqi);
    }
  }
  
  public void binderDied()
  {
    for (;;)
    {
      try
      {
        this.c += 1;
        bjqp.a(jdField_a_of_type_JavaLangString, "binderDied, diedCount=" + this.c);
        if (this.c > 9)
        {
          this.jdField_a_of_type_Bmqa.a(10.0F, true);
          if (!this.jdField_a_of_type_Bmqa.a()) {
            break;
          }
          bjrd localbjrd = bjrd.a();
          localbjrd.c = "service dlied";
          bmqt.a().a("204685", "444", localbjrd, "08a00036462");
          if (this.jdField_a_of_type_Bmqb == null) {
            break;
          }
          this.jdField_a_of_type_Bmqb.asBinder().unlinkToDeath(this, 0);
          this.jdField_a_of_type_Bmqb = null;
          return;
        }
        if (this.c > 6)
        {
          this.jdField_a_of_type_Bmqa.a(2.0F, true);
          continue;
        }
        if (this.c <= 3) {
          break label189;
        }
      }
      catch (Exception localException)
      {
        bjqp.a(jdField_a_of_type_JavaLangString, "binderDied exception", localException);
        return;
      }
      this.jdField_a_of_type_Bmqa.a(1.5F, true);
      continue;
      label189:
      this.jdField_a_of_type_Bmqa.a(1.0F, true);
    }
  }
  
  void c()
  {
    bjqp.c(jdField_a_of_type_JavaLangString, "destroy: " + this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Bmqa.a();
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
        localbmqb = this.jdField_a_of_type_Bmqb;
        if (localbmqb == null) {}
      }
      catch (Exception localRemoteException)
      {
        try
        {
          localbmqb.b(this);
          bjqp.c(jdField_a_of_type_JavaLangString, "destroy unregisterCallback success");
        }
        catch (RemoteException localRemoteException)
        {
          try
          {
            for (;;)
            {
              bmqb localbmqb;
              localbmqb.asBinder().unlinkToDeath(this, 0);
              bjqp.c(jdField_a_of_type_JavaLangString, "destroy unlinkToDeath success");
              if (BaseApplicationImpl.sProcessId == 1) {}
              try
              {
                BaseApplicationImpl.getApplication().unbindService(this);
                bjqp.c(jdField_a_of_type_JavaLangString, "destroy unbindService success");
                return;
              }
              catch (Exception localException4)
              {
                bjqp.a(jdField_a_of_type_JavaLangString, "destroy unbindService exception", localException4);
              }
              localException1 = localException1;
              bjqp.a(jdField_a_of_type_JavaLangString, "destroy clear callBackList exception", localException1);
              continue;
              localException2 = localException2;
              bjqp.a(jdField_a_of_type_JavaLangString, "destroy mMessageThread.quit exception", localException2);
              continue;
              localRemoteException = localRemoteException;
              bjqp.a(jdField_a_of_type_JavaLangString, "destroy unregisterCallback exception", localRemoteException);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              bjqp.a(jdField_a_of_type_JavaLangString, "destroy unlinkToDeath exception", localException3);
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
      this.jdField_a_of_type_Bmqa.a(paramMessage.getData());
      return false;
    case 5: 
      this.jdField_a_of_type_Bmqa.a();
      return false;
    case 6: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_Bmqa.a();
        return false;
      }
      this.jdField_a_of_type_Bmqa.b();
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    bjqp.c(jdField_a_of_type_JavaLangString, "reset mServiceConnecting");
    return false;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bjqp.c(jdField_a_of_type_JavaLangString, "onServiceConnected success, componentName=" + paramComponentName + ",service=" + paramIBinder);
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        bjqp.b(jdField_a_of_type_JavaLangString, "onServiceConnected,but this is destroy");
        return;
      }
      this.jdField_a_of_type_Bmqb = bmqc.a(paramIBinder);
      if (this.jdField_a_of_type_Bmqb == null)
      {
        bjqp.b(jdField_a_of_type_JavaLangString, "onServiceConnected,but asInterface fail");
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    this.jdField_a_of_type_Bmqb.a(this);
    this.jdField_a_of_type_Bmqb.asBinder().linkToDeath(this, 0);
    d();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bjqp.c(jdField_a_of_type_JavaLangString, "onServiceDisconnected");
    try
    {
      if (this.jdField_a_of_type_Bmqb != null) {
        this.jdField_a_of_type_Bmqb.b(this);
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
      this.jdField_a_of_type_Bmqb = null;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqj
 * JD-Core Version:    0.7.0.1
 */