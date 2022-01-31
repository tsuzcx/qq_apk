import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class asgp
  extends Handler
{
  asgp(asgo paramasgo, Looper paramLooper, asgn paramasgn)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (asgn.a(this.jdField_a_of_type_Asgo.jdField_a_of_type_Asgn))
    {
      asgr localasgr = asgn.a(this.jdField_a_of_type_Asgo.jdField_a_of_type_Asgn, (String)paramMessage.obj);
      if (localasgr != null) {
        localasgr.a(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgp
 * JD-Core Version:    0.7.0.1
 */