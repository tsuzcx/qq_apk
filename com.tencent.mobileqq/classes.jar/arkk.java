import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class arkk
  extends Handler
{
  arkk(arkj paramarkj, Looper paramLooper, arki paramarki)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (arki.a(this.jdField_a_of_type_Arkj.jdField_a_of_type_Arki))
    {
      arkm localarkm = arki.a(this.jdField_a_of_type_Arkj.jdField_a_of_type_Arki, (String)paramMessage.obj);
      if (localarkm != null) {
        localarkm.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arkk
 * JD-Core Version:    0.7.0.1
 */