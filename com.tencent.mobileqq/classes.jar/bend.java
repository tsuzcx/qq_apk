import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.os.MqqHandler;

public class bend
  implements Handler.Callback, benj
{
  private benk jdField_a_of_type_Benk;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  
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
  
  public void a(benk parambenk)
  {
    this.jdField_a_of_type_Benk = parambenk;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Benk != null) {
      return this.jdField_a_of_type_Benk.a(paramMessage.what);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bend
 * JD-Core Version:    0.7.0.1
 */