import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.remote.logic.QzoneWebPluginProxyService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class bjmn
{
  private static bjmn jdField_a_of_type_Bjmn;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private bjmp jdField_a_of_type_Bjmp;
  IActionListener jdField_a_of_type_CooperationQzoneRemoteIActionListener = new bjmo(this);
  private RemoteServiceProxy jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy = new RemoteServiceProxy("com.qzone.common.webplugin.WebPluginHandleService", QzoneWebPluginProxyService.class, BaseApplicationImpl.getApplication().getRuntime().getAccount());
  private ArrayList<WeakReference<bjmq>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public bjmn()
  {
    this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.setActionListener(this.jdField_a_of_type_CooperationQzoneRemoteIActionListener);
  }
  
  public static bjmn a()
  {
    if (jdField_a_of_type_Bjmn == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bjmn == null) {
        jdField_a_of_type_Bjmn = new bjmn();
      }
      return jdField_a_of_type_Bjmn;
    }
  }
  
  protected int a(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      localSendMsg.extraData.putAll(paramString);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    localSendMsg.setRequestId(i);
    if (paramLong > 0L) {
      localSendMsg.setTimeout(paramLong);
    }
    localSendMsg.setNeedCallback(paramBoolean);
    if (paramBoolean) {
      localSendMsg.actionListener = this.jdField_a_of_type_CooperationQzoneRemoteIActionListener;
    }
    try
    {
      this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.sendMsg(localSendMsg);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      int i = a(paramString, paramBundle, 0L, paramBoolean);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public bjmp a()
  {
    if (this.jdField_a_of_type_Bjmp == null) {
      this.jdField_a_of_type_Bjmp = new bjmp(this);
    }
    return this.jdField_a_of_type_Bjmp;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteHandleManager", 2, "----destroy----");
    }
    if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy != null) {
      this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.unbindBaseService();
    }
  }
  
  public void a(bjmq parambjmq)
  {
    if (parambjmq == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (bjmq)((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == parambjmq) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parambjmq));
  }
  
  public void b(bjmq parambjmq)
  {
    if (parambjmq == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (bjmq)((WeakReference)localObject).get();
          if (localObject == null) {
            localIterator.remove();
          } else if (localObject == parambjmq) {
            localIterator.remove();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmn
 * JD-Core Version:    0.7.0.1
 */