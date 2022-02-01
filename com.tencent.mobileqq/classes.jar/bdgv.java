import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.os.MqqHandler;

public class bdgv
  implements Handler.Callback, bdhb
{
  private bdhc jdField_a_of_type_Bdhc;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this, true);
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(paramInt1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public void a(bdhc parambdhc)
  {
    this.jdField_a_of_type_Bdhc = parambdhc;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bdhc != null) {
      return this.jdField_a_of_type_Bdhc.a(paramMessage.what);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgv
 * JD-Core Version:    0.7.0.1
 */