import android.os.Handler.Callback;
import android.os.Message;

class aqet
  implements Handler.Callback
{
  aqet(aqes paramaqes) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a.jdField_a_of_type_Bbgu != null) && (this.a.jdField_a_of_type_Bbgu.isShowing()) && (this.a.jdField_a_of_type_Aqfb != null)) {
      this.a.jdField_a_of_type_Aqfb.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqet
 * JD-Core Version:    0.7.0.1
 */