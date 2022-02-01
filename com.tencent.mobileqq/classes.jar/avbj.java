import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

public class avbj
  implements Handler.Callback
{
  public avbj(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a.jdField_a_of_type_Bhpc != null) && (this.a.jdField_a_of_type_Bhpc.isShowing()) && (this.a.jdField_a_of_type_Avbr != null)) {
      this.a.jdField_a_of_type_Avbr.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbj
 * JD-Core Version:    0.7.0.1
 */