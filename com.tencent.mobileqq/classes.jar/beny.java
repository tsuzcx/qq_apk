import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.os.MqqHandler;

public class beny
  implements Handler.Callback, beoe
{
  private beof jdField_a_of_type_Beof;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  
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
  
  public void a(beof parambeof)
  {
    this.jdField_a_of_type_Beof = parambeof;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Beof != null) {
      return this.jdField_a_of_type_Beof.a(paramMessage.what);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beny
 * JD-Core Version:    0.7.0.1
 */