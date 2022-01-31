import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bgnk
  extends Handler
{
  bgnk(bgnj parambgnj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.jdField_a_of_type_Bgng = null;
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgnk
 * JD-Core Version:    0.7.0.1
 */