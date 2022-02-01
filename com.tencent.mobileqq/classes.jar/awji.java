import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class awji
  extends Handler
{
  awji(awjh paramawjh, Looper paramLooper, awjg paramawjg)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (awjg.a(this.jdField_a_of_type_Awjh.jdField_a_of_type_Awjg))
    {
      awjk localawjk = awjg.a(this.jdField_a_of_type_Awjh.jdField_a_of_type_Awjg, (String)paramMessage.obj);
      if (localawjk != null) {
        localawjk.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awji
 * JD-Core Version:    0.7.0.1
 */