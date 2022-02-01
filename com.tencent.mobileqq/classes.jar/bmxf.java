import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
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
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bmxf
  extends bmxb
  implements ServiceConnection, Handler.Callback, IBinder.DeathRecipient
{
  private final int jdField_a_of_type_Int = 100;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientMessage.Thread", 10);
  private bmww jdField_a_of_type_Bmww;
  private bmwx jdField_a_of_type_Bmwx;
  private List<Bundle> jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList<bmxe> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int = 5000;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public bmxf()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bmww = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      bize.a("WadlProxyServiceManager", "storeCmdToCache there must be an error too many unproceed message!");
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBundle);
  }
  
  private void d(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
      bize.c("WadlProxyServiceManager", "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      if (paramBundle != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator.hasNext()) {
          ((bmxe)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
        }
      }
    }
    else
    {
      bize.a("WadlProxyServiceManager", "callBackList is null");
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      localObject = paramBundle.getParcelableArrayList("query_result");
      bize.c("WadlProxyServiceManager", "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      if (localObject != null) {
        break label111;
      }
    }
    label111:
    for (paramBundle = new ArrayList();; paramBundle = (Bundle)localObject)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((bmxe)((Iterator)localObject).next()).onQueryCallback(paramBundle);
        continue;
        bize.a("WadlProxyServiceManager", "callBackList is null");
      }
      return;
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
    }
  }
  
  private void f(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      bize.c("WadlProxyServiceManager", "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((bmxe)paramBundle.next()).onQueryCallbackVia(localArrayList);
      }
    }
    bize.a("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void g(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      bize.c("WadlProxyServiceManager", "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((bmxe)paramBundle.next()).onQueryCallback(localArrayList);
      }
    }
    bize.a("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void h(Bundle paramBundle)
  {
    String str = paramBundle.getString("report_oper_id");
    Object localObject = paramBundle.getString("report_sso_event");
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramBundle != null)) {}
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("8.4.1");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set((String)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getContext(), avqx.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "DownloaderReport.DownloaderMsg");
      ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("extra_timeout", 5000L);
      ((NewIntent)localObject).setObserver(new bmxg(this, str));
      paramBundle.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      bize.a("WadlProxyServiceManager", "onReportDownloadEvent exception:" + paramBundle.toString());
    }
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Bmww.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    bize.a("WadlProxyServiceManager", 4, "send action msg cmd=" + str);
    if (!a())
    {
      bize.a("WadlProxyServiceManager", "postRemoteNotify start but service is not launched and start service");
      c();
    }
    c(paramBundle);
    f();
  }
  
  public void a(bmxe parambmxe)
  {
    if ((parambmxe != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambmxe))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambmxe);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      bize.c("WadlProxyServiceManager", "##@Call back from Service: " + paramString);
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
    return (this.jdField_a_of_type_Bmwx != null) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1).sendToTarget();
    }
  }
  
  public void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      bize.c("WadlProxyServiceManager", "onRemoteReverseInvoke begin cmd=" + str);
    }
    if (str == null) {
      return;
    }
    try
    {
      if (str.equals("Wadl_Reverse_StartWadlService"))
      {
        b();
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      bize.a("WadlProxyServiceManager", "onRemoteReverseInvoke exception", paramBundle);
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
    if (str.equals("Wadl_Reverse_Report_Event"))
    {
      h(paramBundle);
      return;
    }
    if (str.equals("Wadl_Reverse_QnQureyAllTask"))
    {
      g(paramBundle);
      return;
    }
    bize.a("WadlProxyServiceManager", "onRemoteReverseInvoke unknow invokeCmd");
  }
  
  public void b(bmxe parambmxe)
  {
    if (parambmxe != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambmxe);
    }
  }
  
  public void binderDied()
  {
    bize.b("WadlProxyServiceManager", "wadl download process is died!");
    try
    {
      if (this.jdField_a_of_type_Bmwx != null)
      {
        this.jdField_a_of_type_Bmwx.asBinder().unlinkToDeath(this, 0);
        this.jdField_a_of_type_Bmwx = null;
      }
      if (this.jdField_a_of_type_Bmww.a())
      {
        bize.c("WadlProxyServiceManager", "wadl download process died restart service");
        c();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    bize.c("WadlProxyServiceManager", "innerStartService start");
    if (this.jdField_a_of_type_Bmwx != null) {
      if (QLog.isColorLevel()) {
        bize.b("WadlProxyServiceManager", "innerStartService mWadlService is working");
      }
    }
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
        try
        {
          WadlProxyService.a(this);
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            bize.b("WadlProxyServiceManager", "innerStartService fail", localThrowable);
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          }
        }
      }
    }
    bize.c("WadlProxyServiceManager", "innerStartService is connecting mWadlService:" + this.jdField_a_of_type_Bmwx);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      bize.c("WadlProxyServiceManager", "sendAsynRemoteCommandMessage mWadlService=" + this.jdField_a_of_type_Bmwx + ",mServiceConnecting=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",mCacheMsg size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if ((a()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle != null)
        {
          String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          if (QLog.isColorLevel()) {
            bize.c("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage strNotifyCmd=" + str);
          }
          try
          {
            localBundle.setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_Bmwx == null) {
              continue;
            }
            bize.a("WadlProxyServiceManager", 5, "send action to service cmd=" + str);
            this.jdField_a_of_type_Bmwx.a("WADL.REMOTE_ACTION_CMD", localBundle);
          }
          catch (Exception localException) {}
          if ((localException instanceof DeadObjectException))
          {
            c(localBundle);
            bize.b("WadlProxyServiceManager", "remote service is dead", localException);
          }
        }
      }
    }
  }
  
  void e()
  {
    bize.c("WadlProxyServiceManager", "destroy: " + this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Bmww.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      localbmwx = this.jdField_a_of_type_Bmwx;
      if (localbmwx == null) {}
    }
    catch (Exception localRemoteException)
    {
      try
      {
        localbmwx.b(this);
        bize.c("WadlProxyServiceManager", "destroy: unregisterCallback success");
      }
      catch (RemoteException localRemoteException)
      {
        try
        {
          for (;;)
          {
            bmwx localbmwx;
            localbmwx.asBinder().unlinkToDeath(this, 0);
            bize.c("WadlProxyServiceManager", "destroy: unlinkToDeath success");
            try
            {
              BaseApplicationImpl.getApplication().unbindService(this);
              bize.c("WadlProxyServiceManager", "destroy: unbindService success");
              return;
            }
            catch (Exception localException3)
            {
              bize.a("WadlProxyServiceManager", "destroy: unbindService exception", localException3);
            }
            localException1 = localException1;
            bize.a("WadlProxyServiceManager", "onDestroy mMessageThread.quit exception", localException1);
            continue;
            localRemoteException = localRemoteException;
            bize.a("WadlProxyServiceManager", "destroy: unregisterCallback exception", localRemoteException);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bize.a("WadlProxyServiceManager", "destroy: unlinkToDeath exception", localException2);
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
      c();
      return false;
    case 2: 
      d();
      return false;
    case 3: 
      b(paramMessage.getData());
      return false;
    case 4: 
      this.jdField_a_of_type_Bmww.a(paramMessage.getData());
      return false;
    case 5: 
      this.jdField_a_of_type_Bmww.a();
      return false;
    case 6: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_Bmww.a();
        return false;
      }
      this.jdField_a_of_type_Bmww.b();
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    bize.c("WadlProxyServiceManager", "reset mServiceConnecting");
    return false;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bize.c("WadlProxyServiceManager", "onServiceConnected success");
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        bize.c("WadlProxyServiceManager", "onServiceConnected,but can't use it! mDestroy=true");
        return;
      }
      this.jdField_a_of_type_Bmwx = bmwy.a(paramIBinder);
      if (this.jdField_a_of_type_Bmwx == null)
      {
        bize.c("WadlProxyServiceManager", "onServiceConnected,but can't use it! mWadlService=" + this.jdField_a_of_type_Bmwx);
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    this.jdField_a_of_type_Bmwx.a(this);
    this.jdField_a_of_type_Bmwx.asBinder().linkToDeath(this, 0);
    a();
    f();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bize.c("WadlProxyServiceManager", "onServiceDisconnected");
    try
    {
      this.jdField_a_of_type_Bmww.a();
      if (this.jdField_a_of_type_Bmwx != null) {
        this.jdField_a_of_type_Bmwx.b(this);
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
      this.jdField_a_of_type_Bmwx = null;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxf
 * JD-Core Version:    0.7.0.1
 */