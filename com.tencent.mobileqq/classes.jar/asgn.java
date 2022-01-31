import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class asgn
  extends Handler
{
  asgn(asgm paramasgm, Looper paramLooper, asgl paramasgl)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (asgl.a(this.jdField_a_of_type_Asgm.jdField_a_of_type_Asgl))
    {
      asgp localasgp = asgl.a(this.jdField_a_of_type_Asgm.jdField_a_of_type_Asgl, (String)paramMessage.obj);
      if (localasgp != null) {
        localasgp.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgn
 * JD-Core Version:    0.7.0.1
 */