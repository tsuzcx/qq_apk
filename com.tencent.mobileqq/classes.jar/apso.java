import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class apso
  implements DialogInterface.OnClickListener
{
  public apso(ArkAppModuleBase.APIAuthority.1 param1, QQCustomDialog paramQQCustomDialog, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_Apsq != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_Apsq.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label39:
      apsm.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.d, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.e, 2);
      paramDialogInterface = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131690161), 2131718822, 2131718822, new bhdx(), null);
      try
      {
        paramDialogInterface.show();
        return;
      }
      catch (Exception paramDialogInterface) {}
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apso
 * JD-Core Version:    0.7.0.1
 */