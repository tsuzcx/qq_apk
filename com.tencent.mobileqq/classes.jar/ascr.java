import android.os.Handler.Callback;
import android.os.Message;

class ascr
  implements Handler.Callback
{
  ascr(ascq paramascq) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a.jdField_a_of_type_Bdjz != null) && (this.a.jdField_a_of_type_Bdjz.isShowing()) && (this.a.jdField_a_of_type_Ascz != null)) {
      this.a.jdField_a_of_type_Ascz.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascr
 * JD-Core Version:    0.7.0.1
 */