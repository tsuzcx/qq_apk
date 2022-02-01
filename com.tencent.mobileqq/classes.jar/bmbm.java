import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class bmbm
{
  private ServiceConnection a;
  protected bmbi a;
  public final String a;
  protected WeakReference<AppRuntime> a;
  protected HashSet<String> a;
  public ConcurrentLinkedQueue<bmbo> a;
  protected boolean a;
  
  public bmbm(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QfavRemoteProxyForQQ";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new bmbn(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    a("com.tencent.qqfav");
  }
  
  private void a(bmbo parambmbo)
  {
    if ((this.jdField_a_of_type_Bmbi != null) && (parambmbo != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambmbo));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bmbi.a(parambmbo.jdField_a_of_type_Int, parambmbo.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambmbo) {}
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Bmbi == null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAppRuntime != null)
      {
        QfavPluginProxyService.a(localAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection, "com.qqfav.ipc.QfavRemoteProxyService");
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
    }
    return false;
  }
  
  private boolean a(bmbo parambmbo)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambmbo);
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      a();
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      paramString = new bmbo(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_Bmbi != null) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbm
 * JD-Core Version:    0.7.0.1
 */