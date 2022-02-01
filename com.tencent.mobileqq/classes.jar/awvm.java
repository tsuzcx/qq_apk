import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class awvm
  extends Handler
{
  awvm(awvl paramawvl, Looper paramLooper, awvk paramawvk)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (awvk.a(this.jdField_a_of_type_Awvl.jdField_a_of_type_Awvk))
    {
      awvo localawvo = awvk.a(this.jdField_a_of_type_Awvl.jdField_a_of_type_Awvk, (String)paramMessage.obj);
      if (localawvo != null) {
        localawvo.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvm
 * JD-Core Version:    0.7.0.1
 */