import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.1;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bgrc
{
  protected bgqz a;
  public ConcurrentLinkedQueue<bgre> a;
  protected boolean a;
  
  private void a(bgre parambgre)
  {
    if ((this.a != null) && (parambgre != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, parambgre));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.a.a(parambgre.jdField_a_of_type_Int, parambgre.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException parambgre) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrc
 * JD-Core Version:    0.7.0.1
 */