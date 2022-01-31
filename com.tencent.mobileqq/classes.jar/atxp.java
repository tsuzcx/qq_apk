import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class atxp
  extends Handler
{
  atxp(atxo paramatxo, Looper paramLooper, atxn paramatxn)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (atxn.a(this.jdField_a_of_type_Atxo.jdField_a_of_type_Atxn))
    {
      atxr localatxr = atxn.a(this.jdField_a_of_type_Atxo.jdField_a_of_type_Atxn, (String)paramMessage.obj);
      if (localatxr != null) {
        localatxr.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxp
 * JD-Core Version:    0.7.0.1
 */