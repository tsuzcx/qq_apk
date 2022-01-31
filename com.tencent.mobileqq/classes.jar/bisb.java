import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bisb
{
  protected biry a;
  public ConcurrentLinkedQueue<bisd> a;
  protected boolean a;
  
  private void a(bisd parambisd)
  {
    if ((this.a != null) && (parambisd != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambisd));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.a.a(parambisd.jdField_a_of_type_Int, parambisd.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambisd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bisb
 * JD-Core Version:    0.7.0.1
 */