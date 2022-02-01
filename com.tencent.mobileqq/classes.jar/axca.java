import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class axca
  extends Handler
{
  axca(axbz paramaxbz, Looper paramLooper, axby paramaxby)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (axby.a(this.jdField_a_of_type_Axbz.jdField_a_of_type_Axby))
    {
      axcc localaxcc = axby.a(this.jdField_a_of_type_Axbz.jdField_a_of_type_Axby, (String)paramMessage.obj);
      if (localaxcc != null) {
        localaxcc.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axca
 * JD-Core Version:    0.7.0.1
 */