import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class auti
  implements Handler.Callback
{
  public auti(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (this.a.jdField_a_of_type_Autq != null)) {
      this.a.jdField_a_of_type_Autq.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auti
 * JD-Core Version:    0.7.0.1
 */