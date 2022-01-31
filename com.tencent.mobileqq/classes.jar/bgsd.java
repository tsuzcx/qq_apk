import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.1;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class bgsd
{
  private ServiceConnection a;
  protected bgrt a;
  public final String a;
  protected WeakReference<AppRuntime> a;
  protected HashSet<String> a;
  public ConcurrentLinkedQueue<bgsf> a;
  protected boolean a;
  public final String b = "com.qqindividuality.ipc.QQIndividualityRemoteProxyService";
  
  public bgsd(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QQIndividualityRemoteProxy";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new bgse(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    a("qqindividuality_signature");
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Bgrt == null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppRuntime != null)
      {
        QQIndividualityPluginProxyService.a(localAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection, "com.qqindividuality.ipc.QQIndividualityRemoteProxyService");
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  private boolean a(bgsf parambgsf)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambgsf);
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bgrt != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppRuntime != null)
      {
        QQIndividualityPluginProxyService.a(localAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_Bgrt = null;
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return true;
  }
  
  public void a(bgsf parambgsf)
  {
    if ((this.jdField_a_of_type_Bgrt != null) && (parambgsf != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QQIndividualityRemoteProxy.1(this, parambgsf));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bgrt.a(parambgsf.jdField_a_of_type_Int, parambgsf.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambgsf) {}
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      paramString = new bgsf(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_Bgrt != null) {
        a(paramString);
      }
      for (;;)
      {
        return true;
        a(paramString);
        a();
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      if (this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
        b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsd
 * JD-Core Version:    0.7.0.1
 */