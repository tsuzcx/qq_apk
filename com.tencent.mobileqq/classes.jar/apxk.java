import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class apxk
  implements DialogInterface.OnClickListener
{
  public apxk(ArkAppSchemeCenter.TelSchemeHandler.1 param1, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppSchemeCenter$TelSchemeHandler$1.a));
    ArkAppCenter.a(paramDialogInterface);
    BaseActivity.sTopActivity.startActivity(paramDialogInterface);
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxk
 * JD-Core Version:    0.7.0.1
 */