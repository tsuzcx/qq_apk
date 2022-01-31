import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class biwi
{
  protected biwf a;
  public ConcurrentLinkedQueue<biwk> a;
  protected boolean a;
  
  private void a(biwk parambiwk)
  {
    if ((this.a != null) && (parambiwk != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambiwk));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.a.a(parambiwk.jdField_a_of_type_Int, parambiwk.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambiwk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwi
 * JD-Core Version:    0.7.0.1
 */