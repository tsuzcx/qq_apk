import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bmiq
  extends Handler
{
  bmiq(bmip parambmip, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.jdField_a_of_type_Bmim = null;
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiq
 * JD-Core Version:    0.7.0.1
 */