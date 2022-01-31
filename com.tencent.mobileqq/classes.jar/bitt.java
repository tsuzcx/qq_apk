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

public class bitt
{
  private ServiceConnection a;
  protected bitj a;
  public final String a;
  protected WeakReference<AppRuntime> a;
  protected HashSet<String> a;
  public ConcurrentLinkedQueue<bitv> a;
  protected boolean a;
  public final String b = "com.qqindividuality.ipc.QQIndividualityRemoteProxyService";
  
  public bitt(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QQIndividualityRemoteProxy";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new bitu(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    a("qqindividuality_signature");
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Bitj == null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
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
  
  private boolean a(bitv parambitv)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambitv);
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bitj != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppRuntime != null)
      {
        QQIndividualityPluginProxyService.a(localAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_Bitj = null;
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return true;
  }
  
  public void a(bitv parambitv)
  {
    if ((this.jdField_a_of_type_Bitj != null) && (parambitv != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QQIndividualityRemoteProxy.1(this, parambitv));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bitj.a(parambitv.jdField_a_of_type_Int, parambitv.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambitv) {}
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
      paramString = new bitv(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_Bitj != null) {
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
 * Qualified Name:     bitt
 * JD-Core Version:    0.7.0.1
 */