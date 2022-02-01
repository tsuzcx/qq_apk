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

public class bmfd
  implements blvx
{
  private static bmfd jdField_a_of_type_Bmfd;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Object b = new Object();
  private bmfg jdField_a_of_type_Bmfg;
  IActionListener jdField_a_of_type_CooperationQzoneRemoteIActionListener = new bmfe(this);
  private RemoteServiceProxy jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy;
  private ArrayList<WeakReference<bmfh>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public bmfd()
  {
    if (blvu.b(this)) {
      a();
    }
  }
  
  public static bmfd a()
  {
    if (jdField_a_of_type_Bmfd == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bmfd == null) {
        jdField_a_of_type_Bmfd = new bmfd();
      }
      return jdField_a_of_type_Bmfd;
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
      if ((blvu.b(new bmff(this, localSendMsg))) && (a() != null))
      {
        a().sendMsg(localSendMsg);
        return i;
      }
      QLog.e("RemoteHandleManager", 1, "sendData getServiceProxy()== null cmd= " + paramString);
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
  
  public bmfg a()
  {
    if (this.jdField_a_of_type_Bmfg == null) {
      this.jdField_a_of_type_Bmfg = new bmfg(this);
    }
    return this.jdField_a_of_type_Bmfg;
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
  
  public void a(bmfh parambmfh)
  {
    if (parambmfh == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (bmfh)((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == parambmfh) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parambmfh));
  }
  
  public void b(bmfh parambmfh)
  {
    if (parambmfh == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (bmfh)((WeakReference)localObject).get();
          if (localObject == null) {
            localIterator.remove();
          } else if (localObject == parambmfh) {
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
 * Qualified Name:     bmfd
 * JD-Core Version:    0.7.0.1
 */