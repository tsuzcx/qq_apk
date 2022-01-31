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

public class bioc
{
  protected static ConcurrentHashMap<String, bioc> a;
  protected volatile long a;
  protected ServiceConnection a;
  private binv jdField_a_of_type_Binv;
  public volatile biny a;
  protected Object a;
  private String jdField_a_of_type_JavaLangString;
  public ConcurrentLinkedQueue<SendMsg> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public bioc(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidContentServiceConnection = new biod(this);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static bioc a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new bioc(null, paramString));
      }
      paramString = (bioc)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    this.jdField_a_of_type_Biny.a(paramSendMsg);
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
      if (this.jdField_a_of_type_Binv != null)
      {
        this.jdField_a_of_type_Binv.a(paramRecvMsg);
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
    return this.jdField_a_of_type_Biny != null;
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
      if (this.jdField_a_of_type_Biny == null)
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
      bimp localbimp = new bimp(1);
      localbimp.b = "qappcenter_plugin.apk";
      localbimp.d = alpo.a(2131713773);
      localbimp.jdField_a_of_type_JavaLangString = this.b;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (localbimp.e = "com.tencent.plugin.qappcenter.remote.RemoteService";; localbimp.e = this.jdField_a_of_type_JavaLangString)
      {
        localbimp.jdField_a_of_type_AndroidContentIntent = localIntent;
        localbimp.jdField_a_of_type_AndroidContentServiceConnection = this.jdField_a_of_type_AndroidContentServiceConnection;
        bimg.c(BaseApplicationImpl.getApplication(), localbimp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bioc
 * JD-Core Version:    0.7.0.1
 */