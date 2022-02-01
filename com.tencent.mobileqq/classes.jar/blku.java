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

public class blku
{
  private ServiceConnection a;
  protected blkq a;
  public final String a;
  protected HashSet<String> a;
  public ConcurrentLinkedQueue<blkw> a;
  protected AppRuntime a;
  protected boolean a;
  public final String b = "com.qqfav.ipc.QfavRemoteProxyService";
  
  public blku(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QfavRemoteProxyForQQ";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new blkv(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(blkw paramblkw)
  {
    if ((this.jdField_a_of_type_Blkq != null) && (paramblkw != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, paramblkw));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_Blkq.a(paramblkw.jdField_a_of_type_Int, paramblkw.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException paramblkw) {}
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Blkq == null) && (!this.jdField_a_of_type_Boolean))
    {
      QfavPluginProxyService.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection, "com.qqfav.ipc.QfavRemoteProxyService");
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private boolean a(blkw paramblkw)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramblkw);
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
      paramString = new blkw(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_Blkq != null) {
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
 * Qualified Name:     blku
 * JD-Core Version:    0.7.0.1
 */