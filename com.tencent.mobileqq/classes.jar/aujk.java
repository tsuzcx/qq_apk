import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

public class aujk
  implements Handler.Callback
{
  public aujk(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a.jdField_a_of_type_Bgpa != null) && (this.a.jdField_a_of_type_Bgpa.isShowing()) && (this.a.jdField_a_of_type_Aujs != null)) {
      this.a.jdField_a_of_type_Aujs.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujk
 * JD-Core Version:    0.7.0.1
 */