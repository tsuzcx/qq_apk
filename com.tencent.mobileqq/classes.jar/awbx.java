import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class awbx
  implements DialogInterface.OnCancelListener
{
  public awbx(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: -1})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbx
 * JD-Core Version:    0.7.0.1
 */