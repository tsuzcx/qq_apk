import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class auby
  extends Handler
{
  auby(aubx paramaubx, Looper paramLooper, aubw paramaubw)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (aubw.a(this.jdField_a_of_type_Aubx.jdField_a_of_type_Aubw))
    {
      auca localauca = aubw.a(this.jdField_a_of_type_Aubx.jdField_a_of_type_Aubw, (String)paramMessage.obj);
      if (localauca != null) {
        localauca.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auby
 * JD-Core Version:    0.7.0.1
 */