import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bhwt
  extends Handler
{
  bhwt(bhws parambhws, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.jdField_a_of_type_Bhwp = null;
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhwt
 * JD-Core Version:    0.7.0.1
 */