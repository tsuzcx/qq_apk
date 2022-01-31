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

public class biya
{
  private ServiceConnection a;
  protected bixq a;
  public final String a;
  protected WeakReference<AppRuntime> a;
  protected HashSet<String> a;
  public ConcurrentLinkedQueue<biyc> a;
  protected boolean a;
  public final String b = "com.qqindividuality.ipc.QQIndividualityRemoteProxyService";
  
  public biya(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QQIndividualityRemoteProxy";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new biyb(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    a("qqindividuality_signature");
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Bixq == null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
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
  
  private boolean a(biyc parambiyc)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambiyc);
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bixq != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppRuntime != null)
      {
        QQIndividualityPluginProxyService.a(localAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_Bixq = null;
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return true;
  }
  
  public void a(biyc parambiyc)
  {
    if ((this.jdField_a_of_type_Bixq != null) && (parambiyc != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QQIndividualityRemoteProxy.1(this, parambiyc));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bixq.a(parambiyc.jdField_a_of_type_Int, parambiyc.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambiyc) {}
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
      paramString = new biyc(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_Bixq != null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biya
 * JD-Core Version:    0.7.0.1
 */