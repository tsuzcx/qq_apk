import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anup
  extends beyf
{
  WeakReference<anuq> a;
  
  public anup(anuq paramanuq)
  {
    this.a = new WeakReference(paramanuq);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if (localbete.b == 35) {
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramMessage = localbete.a;
        if ((this.a != null) && (this.a.get() != null))
        {
          ((anuq)this.a.get()).b(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
      return;
      if ((this.a != null) && (this.a.get() != null))
      {
        ((anuq)this.a.get()).a(localbete.g);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anup
 * JD-Core Version:    0.7.0.1
 */