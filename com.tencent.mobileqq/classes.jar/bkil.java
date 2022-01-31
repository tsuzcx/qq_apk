import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyService;
import cooperation.wadl.ipc.WadlProxyServiceManager.1;
import cooperation.wadl.ipc.WadlProxyServiceMonitor;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bkil
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bkin(this);
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientMessage.Thread", 10);
  private IBinder.DeathRecipient jdField_a_of_type_AndroidOsIBinder$DeathRecipient = new bkim(this);
  private bkic jdField_a_of_type_Bkic;
  private bkid jdField_a_of_type_Bkid;
  private bkip jdField_a_of_type_Bkip;
  private bkiq jdField_a_of_type_Bkiq = new bkiq(this);
  private List<Bundle> jdField_a_of_type_JavaUtilList = new Vector();
  private CopyOnWriteArrayList<bkik> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public boolean a;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public bkil()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Bkip = new bkip(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("WadlClientJob.Thread", 10);
    this.jdField_b_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bkic = new WadlProxyServiceMonitor(this);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 100)
    {
      bfrz.a("WadlProxyServiceManager", "##@there must be an error too many unproceed message!");
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBundle);
  }
  
  private void d(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      paramBundle = (WadlResult)paramBundle.getParcelable("download_result");
      bfrz.c("WadlProxyServiceManager", "downloadActionCallback params:" + paramBundle + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      if (paramBundle != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator.hasNext()) {
          ((bkik)localIterator.next()).onWadlTaskStatusChanged(paramBundle);
        }
      }
    }
    else
    {
      bfrz.a("WadlProxyServiceManager", "callBackList is null");
    }
  }
  
  private void e()
  {
    Message localMessage = this.jdField_a_of_type_Bkip.obtainMessage();
    localMessage.what = 2;
    this.jdField_a_of_type_Bkip.sendMessage(localMessage);
  }
  
  private void e(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      bfrz.c("WadlProxyServiceManager", "onQueryCallback params:" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((bkik)paramBundle.next()).onQueryCallback(localArrayList);
      }
    }
    bfrz.a("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void f(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      bfrz.c("WadlProxyServiceManager", "onQueryCallbackVia params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((bkik)paramBundle.next()).onQueryCallbackVia(localArrayList);
      }
    }
    bfrz.a("WadlProxyServiceManager", "callBackList is null");
  }
  
  private void g(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("query_result");
      bfrz.c("WadlProxyServiceManager", "onQueryAllTaskCallback params" + paramBundle.toString() + ",callBackList size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      paramBundle = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramBundle.hasNext()) {
        ((bkik)paramBundle.next()).onQueryCallback(localArrayList);
      }
    }
    bfrz.a("WadlProxyServiceManager", "callBackList is null");
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
      localUniSsoServerReqComm.mqqver.set("8.3.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set((String)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getContext(), atkg.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "DownloaderReport.DownloaderMsg");
      ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("extra_timeout", 5000L);
      ((NewIntent)localObject).setObserver(new bkio(this, str));
      paramBundle.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      bfrz.a("WadlProxyServiceManager", "onReportDownloadEvent exception:" + paramBundle.toString());
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REVERSE_ACTION_CMD_NAME");
    if (QLog.isColorLevel()) {
      bfrz.c("WadlProxyServiceManager", "onRemoteReverseInvoke begin cmd=" + str);
    }
    if (str == null) {
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_StartWadlService"))
    {
      a();
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_onWadlTaskStatusChanged"))
    {
      d(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyResult"))
    {
      e(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyResultVia"))
    {
      f(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_Report_Event"))
    {
      h(paramBundle);
      return paramBundle;
    }
    if (str.equals("Wadl_Reverse_QnQureyAllTask"))
    {
      g(paramBundle);
      return paramBundle;
    }
    bfrz.a("WadlProxyServiceManager", "onRemoteReverseInvoke unknow invokeCmd");
    return paramBundle;
  }
  
  public List<bkik> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    Message localMessage = this.jdField_a_of_type_Bkip.obtainMessage();
    localMessage.what = 1;
    this.jdField_a_of_type_Bkip.sendMessage(localMessage);
  }
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
    bfrz.a("WadlProxyServiceManager", 4, "send action msg cmd=" + str);
    if (!a())
    {
      bfrz.a("WadlProxyServiceManager", "postRemoteNotify start but service is not launched and start service");
      b();
    }
    c(paramBundle);
    e();
  }
  
  public void a(bkik parambkik)
  {
    if ((parambkik != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambkik))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambkik);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bkid != null) && (!this.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    bfrz.c("WadlProxyServiceManager", "innerStartService start");
    if (this.jdField_a_of_type_Bkid != null)
    {
      if (QLog.isColorLevel()) {
        bfrz.c("WadlProxyServiceManager", "innerStartService:mWadlService is working");
      }
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("##@innerStartService:mWadlService is connecting >> [mServiceConnecting:").append(this.jdField_a_of_type_Boolean).append(",mWadlService:");
      if (this.jdField_a_of_type_Bkid == null) {}
      for (String str = "invaliad";; str = "valid")
      {
        bfrz.c("WadlProxyServiceManager", str + "]");
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    try
    {
      bfrz.c("WadlProxyServiceManager", "##@innerStartService:bindWadlService");
      WadlProxyService.a(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new WadlProxyServiceManager.1(this), 5000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bfrz.b("WadlProxyServiceManager", "##@failed to lauch servie", localException);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bkic != null) {
      this.jdField_a_of_type_Bkic.a(paramBundle);
    }
  }
  
  public void b(bkik parambkik)
  {
    if (parambkik != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambkik);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      bfrz.c("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage()");
    }
    if (a())
    {
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label42;
      }
      bfrz.c("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage(empty) END");
    }
    label41:
    label42:
    Bundle localBundle;
    do
    {
      break label42;
      break label42;
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label41;
        }
        localBundle = (Bundle)this.jdField_a_of_type_JavaUtilList.remove(0);
        if (localBundle == null) {
          break;
        }
        String str = localBundle.getString("WADL.REMOTE_NOTIFY_CMD_NAME");
        if (QLog.isColorLevel()) {
          bfrz.c("WadlProxyServiceManager", "##@sendAsynRemoteCommandMessage():" + str);
        }
        try
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          if (this.jdField_a_of_type_Bkid != null)
          {
            bfrz.a("WadlProxyServiceManager", 5, "send action to service cmd=" + str);
            this.jdField_a_of_type_Bkid.a("WADL.REMOTE_ACTION_CMD", localBundle);
          }
        }
        catch (Exception localException) {}
      }
    } while (!(localException instanceof DeadObjectException));
    c(localBundle);
    bfrz.b("WadlProxyServiceManager", "remote service is dead", localException);
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: ldc 117
    //   2: new 144	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 501
    //   12: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 166	bfrz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 107	bkil:jdField_b_of_type_Boolean	Z
    //   30: aload_0
    //   31: getfield 91	bkil:jdField_a_of_type_Bkic	Lbkic;
    //   34: ifnull +12 -> 46
    //   37: aload_0
    //   38: getfield 91	bkil:jdField_a_of_type_Bkic	Lbkic;
    //   41: invokeinterface 502 1 0
    //   46: aload_0
    //   47: getfield 56	bkil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   50: ifnull +11 -> 61
    //   53: aload_0
    //   54: getfield 56	bkil:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   57: invokevirtual 505	android/os/HandlerThread:quit	()Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 74	bkil:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: getfield 74	bkil:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   72: invokevirtual 505	android/os/HandlerThread:quit	()Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 98	bkil:jdField_a_of_type_Bkid	Lbkid;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +46 -> 128
    //   85: aload_1
    //   86: aload_0
    //   87: getfield 47	bkil:jdField_a_of_type_Bkiq	Lbkiq;
    //   90: invokeinterface 508 2 0
    //   95: ldc 117
    //   97: ldc_w 510
    //   100: invokestatic 166	bfrz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokeinterface 514 1 0
    //   109: aload_0
    //   110: getfield 37	bkil:jdField_a_of_type_AndroidOsIBinder$DeathRecipient	Landroid/os/IBinder$DeathRecipient;
    //   113: iconst_0
    //   114: invokeinterface 520 3 0
    //   119: pop
    //   120: ldc 117
    //   122: ldc_w 522
    //   125: invokestatic 166	bfrz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: invokestatic 241	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   131: aload_0
    //   132: getfield 42	bkil:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   135: invokevirtual 525	com/tencent/common/app/BaseApplicationImpl:unbindService	(Landroid/content/ServiceConnection;)V
    //   138: ldc 117
    //   140: ldc_w 527
    //   143: invokestatic 166	bfrz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: return
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 530	java/lang/Exception:printStackTrace	()V
    //   152: goto -76 -> 76
    //   155: astore_2
    //   156: aload_2
    //   157: invokevirtual 531	android/os/RemoteException:printStackTrace	()V
    //   160: goto -57 -> 103
    //   163: astore_1
    //   164: return
    //   165: astore_1
    //   166: goto -38 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	bkil
    //   80	24	1	localbkid	bkid
    //   147	2	1	localException1	Exception
    //   163	1	1	localException2	Exception
    //   165	1	1	localException3	Exception
    //   155	2	2	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   30	46	147	java/lang/Exception
    //   46	61	147	java/lang/Exception
    //   61	76	147	java/lang/Exception
    //   85	103	155	android/os/RemoteException
    //   128	146	163	java/lang/Exception
    //   103	128	165	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkil
 * JD-Core Version:    0.7.0.1
 */