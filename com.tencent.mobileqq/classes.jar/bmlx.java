import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class bmlx
{
  private ServiceConnection a;
  protected bmlt a;
  public final String a;
  protected HashSet<String> a;
  public ConcurrentLinkedQueue<bmlz> a;
  protected AppRuntime a;
  protected boolean a;
  public final String b = "com.qqfav.ipc.QfavRemoteProxyService";
  
  public bmlx(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QfavRemoteProxyForQQ";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new bmly(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(bmlz parambmlz)
  {
    if ((this.jdField_a_of_type_Bmlt != null) && (parambmlz != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambmlz));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bmlt.a(parambmlz.jdField_a_of_type_Int, parambmlz.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambmlz) {}
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Bmlt == null) && (!this.jdField_a_of_type_Boolean))
    {
      QfavPluginProxyService.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection, "com.qqfav.ipc.QfavRemoteProxyService");
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private boolean a(bmlz parambmlz)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambmlz);
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
      paramString = new bmlz(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_Bmlt != null) {
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
 * Qualified Name:     bmlx
 * JD-Core Version:    0.7.0.1
 */