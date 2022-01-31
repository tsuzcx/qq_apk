import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bfit
{
  protected bfiq a;
  public ConcurrentLinkedQueue<bfiv> a;
  protected boolean a;
  
  private void a(bfiv parambfiv)
  {
    if ((this.a != null) && (parambfiv != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambfiv));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.a.a(parambfiv.jdField_a_of_type_Int, parambfiv.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambfiv) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfit
 * JD-Core Version:    0.7.0.1
 */