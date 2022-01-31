import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qappcenter.QAppCenterPluginProxyService;
import cooperation.qappcenter.remote.RecvMsg;
import cooperation.qappcenter.remote.RemoteServiceProxy.2;
import cooperation.qappcenter.remote.RemoteServiceProxy.3;
import cooperation.qappcenter.remote.SendMsg;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bgnd
{
  protected static ConcurrentHashMap<String, bgnd> a;
  protected volatile long a;
  protected ServiceConnection a;
  private bgmw jdField_a_of_type_Bgmw;
  public volatile bgmz a;
  protected Object a;
  private String jdField_a_of_type_JavaLangString;
  public ConcurrentLinkedQueue<SendMsg> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public bgnd(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidContentServiceConnection = new bgne(this);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static bgnd a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new bgnd(null, paramString));
      }
      paramString = (bgnd)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public RecvMsg a(SendMsg paramSendMsg, String paramString)
  {
    paramSendMsg = new RecvMsg(paramSendMsg.a(), paramSendMsg.a());
    paramSendMsg.a(1002, paramString);
    return paramSendMsg;
  }
  
  protected void a()
  {
    RemoteServiceProxy.2 local2 = new RemoteServiceProxy.2(this);
    local2.setName("handleWaitSendProxyMsgThread");
    local2.start();
  }
  
  public void a(SendMsg paramSendMsg)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new RemoteServiceProxy.3(this, paramSendMsg), 10, null, false);
      return;
    }
    this.jdField_a_of_type_Bgmz.a(paramSendMsg);
  }
  
  public void a(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
  {
    try
    {
      if (paramSendMsg.a() != null)
      {
        paramSendMsg.a().a(paramRecvMsg);
        return;
      }
      if (this.jdField_a_of_type_Bgmw != null)
      {
        this.jdField_a_of_type_Bgmw.a(paramRecvMsg);
        return;
      }
    }
    catch (RemoteException paramSendMsg)
    {
      paramSendMsg.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Bgmz != null;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long == -1L) || (l - this.jdField_a_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Long = l;
      c();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RemoteServiceProxy", 2, "wait start " + this.jdField_a_of_type_JavaLangString + " service result, skiped...");
  }
  
  public void b(SendMsg paramSendMsg)
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (a())
        {
          a(paramSendMsg);
          return;
        }
        c(paramSendMsg);
        b();
      }
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      c(paramSendMsg);
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_Bgmz == null)
      {
        c(paramSendMsg);
        return;
      }
      localException.printStackTrace();
    }
  }
  
  void c()
  {
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QAppCenterPluginProxyService.class);
      bglq localbglq = new bglq(1);
      localbglq.b = "qappcenter_plugin.apk";
      localbglq.d = ajya.a(2131713401);
      localbglq.jdField_a_of_type_JavaLangString = this.b;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (localbglq.e = "com.tencent.plugin.qappcenter.remote.RemoteService";; localbglq.e = this.jdField_a_of_type_JavaLangString)
      {
        localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
        localbglq.jdField_a_of_type_AndroidContentServiceConnection = this.jdField_a_of_type_AndroidContentServiceConnection;
        bglh.c(BaseApplicationImpl.getApplication(), localbglq);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RemoteServiceProxy", 2, " start service finish");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void c(SendMsg paramSendMsg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramSendMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgnd
 * JD-Core Version:    0.7.0.1
 */