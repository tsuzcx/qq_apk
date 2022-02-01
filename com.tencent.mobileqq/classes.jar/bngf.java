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

public class bngf
  implements bmwz
{
  private static bngf jdField_a_of_type_Bngf;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Object b = new Object();
  private bngi jdField_a_of_type_Bngi;
  IActionListener jdField_a_of_type_CooperationQzoneRemoteIActionListener = new bngg(this);
  private RemoteServiceProxy jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy;
  private ArrayList<WeakReference<bngj>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public bngf()
  {
    if (bmww.b(this)) {
      a();
    }
  }
  
  public static bngf a()
  {
    if (jdField_a_of_type_Bngf == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bngf == null) {
        jdField_a_of_type_Bngf = new bngf();
      }
      return jdField_a_of_type_Bngf;
    }
  }
  
  protected int a(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if ((localBundle != null) && (localBundle.size() > 0)) {
      localSendMsg.extraData.putAll(localBundle);
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
      if ((bmww.b(null)) && (a() != null))
      {
        a().sendMsg(localSendMsg);
        return i;
      }
      bmww.b(new bngh(this, localSendMsg, paramString));
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
  
  public bngi a()
  {
    if (this.jdField_a_of_type_Bngi == null) {
      this.jdField_a_of_type_Bngi = new bngi(this);
    }
    return this.jdField_a_of_type_Bngi;
  }
  
  public RemoteServiceProxy a()
  {
    if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy != null) {
      return this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy;
    }
    synchronized (b)
    {
      if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy == null)
      {
        this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy = new RemoteServiceProxy("com.qzone.common.webplugin.WebPluginHandleService", QzoneWebPluginProxyService.class, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.setActionListener(this.jdField_a_of_type_CooperationQzoneRemoteIActionListener);
      }
      return this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy;
    }
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
  
  public void a(bngj parambngj)
  {
    if (parambngj == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (bngj)((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == parambngj) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parambngj));
  }
  
  public void b(bngj parambngj)
  {
    if (parambngj == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (bngj)((WeakReference)localObject).get();
          if (localObject == null) {
            localIterator.remove();
          } else if (localObject == parambngj) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngf
 * JD-Core Version:    0.7.0.1
 */