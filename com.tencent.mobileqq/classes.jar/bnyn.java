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

public class bnyn
  extends bnyj
  implements ServiceConnection, Handler.Callback, IBinder.DeathRecipient
{
  private static final String jdField_a_of_type_JavaLangString = bnyp.b + "WadlProxyServiceManager";
  private final int jdField_a_of_type_Int = 100;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientMessage.Thread", 10);
  private bnye jdField_a_of_type_Bnye;
  private bnyf jdField_a_of_type_Bnyf;
  private List<Bundle> jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList<bnym> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final int jdField_b_of_type_Int = 5000;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int c;
  
  public bnyn()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bnye = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      bkad.a(jdField_a_of_type_JavaLangString, "storeCmdToCache there must be an error too many unproceed message!");
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBundle);
  }
  
  private void d(Bundle paramBundle)
  {
    paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
    bkad.c(jdField_a_of_type_JavaLangString, "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (paramBundle != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bnym)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
      }
    }
  }
  
  private void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getParcelableArrayList("query_result");
    bkad.c(jdField_a_of_type_JavaLangString, "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    if (localObject == null) {}
    for (paramBundle = new ArrayList();; paramBundle = (Bundle)localObject)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bnym)((Iterator)localObject).next()).onQueryCallback(paramBundle);
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
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    bkad.c(jdField_a_of_type_JavaLangString, "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((bnym)paramBundle.next()).onQueryCallbackVia(localArrayList);
    }
  }
  
  private void g(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
    bkad.c(jdField_a_of_type_JavaLangString, "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramBundle.hasNext()) {
      ((bnym)paramBundle.next()).onQueryCallback(localArrayList);
    }
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
      localUniSsoServerReqComm.mqqver.set("8.4.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set((String)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getContext(), awjk.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "DownloaderReport.DownloaderMsg");
      ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("extra_timeout", 5000L);
      ((NewIntent)localObject).setObserver(new bnyo(this, str));
      paramBundle.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      bkad.a(jdField_a_of_type_JavaLangString, "onReportDownloadEvent exception:" + paramBundle.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      bkad.c(jdField_a_of_type_JavaLangString, "resetDiedCount");
    }
    this.c = 0;
    this.jdField_a_of_type_Bnye.a(1.0F, false);
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    bkad.a(jdField_a_of_type_JavaLangString, 4, "send action msg cmd=" + str);
    if (!a())
    {
      bkad.a(jdField_a_of_type_JavaLangString, "postRemoteNotify start but service is not launched and start service");
      c();
    }
    c(paramBundle);
    f();
  }
  
  public void a(bnym parambnym)
  {
    if ((parambnym != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambnym))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambnym);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      bkad.c(jdField_a_of_type_JavaLangString, "transferAsync from Service cmd=" + paramString);
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    if (paramString != null)
    {
      if (!paramString.equals("WADL.REVERSE_HEART_CMD")) {
        break label85;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramString.what = 4;
      paramString.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    }
    label85:
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
    return (this.jdField_a_of_type_Bnyf != null) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
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
      bkad.c(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke begin cmd=" + str);
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
      bkad.a(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke exception", paramBundle);
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
    bkad.a(jdField_a_of_type_JavaLangString, "onRemoteReverseInvoke unknow invokeCmd");
  }
  
  public void b(bnym parambnym)
  {
    if (parambnym != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambnym);
    }
  }
  
  public void binderDied()
  {
    for (;;)
    {
      try
      {
        this.c += 1;
        bkad.a(jdField_a_of_type_JavaLangString, "binderDied, diedCount=" + this.c);
        if (this.c > 9)
        {
          this.jdField_a_of_type_Bnye.a(10.0F, true);
          bkar localbkar = bkar.a();
          localbkar.c = "service dlied";
          bnyy.a().a("204685", "29", localbkar, "dc00087");
          if (this.jdField_a_of_type_Bnyf == null) {
            break;
          }
          this.jdField_a_of_type_Bnyf.asBinder().unlinkToDeath(this, 0);
          this.jdField_a_of_type_Bnyf = null;
          return;
        }
        if (this.c > 6)
        {
          this.jdField_a_of_type_Bnye.a(2.0F, true);
          continue;
        }
        if (this.c <= 3) {
          break label177;
        }
      }
      catch (Exception localException)
      {
        bkad.a(jdField_a_of_type_JavaLangString, "binderDied exception", localException);
        return;
      }
      this.jdField_a_of_type_Bnye.a(1.5F, true);
      continue;
      label177:
      this.jdField_a_of_type_Bnye.a(1.0F, true);
    }
  }
  
  public void c()
  {
    bkad.c(jdField_a_of_type_JavaLangString, "innerStartService start");
    if (this.jdField_a_of_type_Bnyf != null) {
      if (QLog.isColorLevel()) {
        bkad.b(jdField_a_of_type_JavaLangString, "innerStartService mWadlService is working");
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
            bkad.b(jdField_a_of_type_JavaLangString, "innerStartService fail", localThrowable);
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          }
        }
      }
    }
    bkad.c(jdField_a_of_type_JavaLangString, "innerStartService is connecting mWadlService:" + this.jdField_a_of_type_Bnyf);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      bkad.c(jdField_a_of_type_JavaLangString, "sendAsynRemoteCommandMessage mWadlService=" + this.jdField_a_of_type_Bnyf + ",mServiceConnecting=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ",mCacheMsg size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if ((a()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      while (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle != null)
        {
          String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
          if (QLog.isColorLevel()) {
            bkad.c(jdField_a_of_type_JavaLangString, "##@sendAsynRemoteCommandMessage strNotifyCmd=" + str);
          }
          try
          {
            localBundle.setClassLoader(getClass().getClassLoader());
            if (this.jdField_a_of_type_Bnyf == null) {
              continue;
            }
            bkad.a(jdField_a_of_type_JavaLangString, 5, "send action to service cmd=" + str);
            this.jdField_a_of_type_Bnyf.a("WADL.REMOTE_ACTION_CMD", localBundle);
          }
          catch (Exception localException) {}
          if ((localException instanceof DeadObjectException))
          {
            c(localBundle);
            bkad.b(jdField_a_of_type_JavaLangString, "remote service is dead", localException);
          }
        }
      }
    }
  }
  
  void e()
  {
    bkad.c(jdField_a_of_type_JavaLangString, "destroy: " + this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Bnye.a();
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
        localbnyf = this.jdField_a_of_type_Bnyf;
        if (localbnyf == null) {}
      }
      catch (Exception localRemoteException)
      {
        try
        {
          localbnyf.b(this);
          bkad.c(jdField_a_of_type_JavaLangString, "destroy unregisterCallback success");
        }
        catch (RemoteException localRemoteException)
        {
          try
          {
            for (;;)
            {
              bnyf localbnyf;
              localbnyf.asBinder().unlinkToDeath(this, 0);
              bkad.c(jdField_a_of_type_JavaLangString, "destroy unlinkToDeath success");
              if (BaseApplicationImpl.sProcessId == 1) {}
              try
              {
                BaseApplicationImpl.getApplication().unbindService(this);
                bkad.c(jdField_a_of_type_JavaLangString, "destroy unbindService success");
                return;
              }
              catch (Exception localException4)
              {
                bkad.a(jdField_a_of_type_JavaLangString, "destroy unbindService exception", localException4);
              }
              localException1 = localException1;
              bkad.a(jdField_a_of_type_JavaLangString, "destroy clear callBackList exception", localException1);
              continue;
              localException2 = localException2;
              bkad.a(jdField_a_of_type_JavaLangString, "destroy mMessageThread.quit exception", localException2);
              continue;
              localRemoteException = localRemoteException;
              bkad.a(jdField_a_of_type_JavaLangString, "destroy unregisterCallback exception", localRemoteException);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              bkad.a(jdField_a_of_type_JavaLangString, "destroy unlinkToDeath exception", localException3);
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
      c();
      return false;
    case 2: 
      d();
      return false;
    case 3: 
      b(paramMessage.getData());
      return false;
    case 4: 
      this.jdField_a_of_type_Bnye.a(paramMessage.getData());
      return false;
    case 5: 
      this.jdField_a_of_type_Bnye.a();
      return false;
    case 6: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_Bnye.a();
        return false;
      }
      this.jdField_a_of_type_Bnye.b();
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    bkad.c(jdField_a_of_type_JavaLangString, "reset mServiceConnecting");
    return false;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    bkad.c(jdField_a_of_type_JavaLangString, "onServiceConnected success, componentName=" + paramComponentName + ",service=" + paramIBinder);
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        bkad.b(jdField_a_of_type_JavaLangString, "onServiceConnected,but this is destroy");
        return;
      }
      this.jdField_a_of_type_Bnyf = bnyg.a(paramIBinder);
      if (this.jdField_a_of_type_Bnyf == null)
      {
        bkad.b(jdField_a_of_type_JavaLangString, "onServiceConnected,but asInterface fail");
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      return;
    }
    this.jdField_a_of_type_Bnyf.a(this);
    this.jdField_a_of_type_Bnyf.asBinder().linkToDeath(this, 0);
    f();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    bkad.c(jdField_a_of_type_JavaLangString, "onServiceDisconnected");
    try
    {
      if (this.jdField_a_of_type_Bnyf != null) {
        this.jdField_a_of_type_Bnyf.b(this);
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
      this.jdField_a_of_type_Bnyf = null;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyn
 * JD-Core Version:    0.7.0.1
 */