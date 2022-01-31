import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bgql
{
  protected bgqi a;
  public ConcurrentLinkedQueue<bgqn> a;
  protected boolean a;
  
  private void a(bgqn parambgqn)
  {
    if ((this.a != null) && (parambgqn != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambgqn));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.a.a(parambgqn.jdField_a_of_type_Int, parambgqn.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambgqn) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgql
 * JD-Core Version:    0.7.0.1
 */