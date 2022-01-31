import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bkcl
  extends Handler
{
  bkcl(bkck parambkck, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.jdField_a_of_type_Bkch = null;
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcl
 * JD-Core Version:    0.7.0.1
 */