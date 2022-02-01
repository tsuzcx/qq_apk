import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aopo
  implements DialogInterface.OnClickListener
{
  public aopo(ArkAppModuleBase.APIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_Aopp != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_Aopp.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label39:
      aopl.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.d, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.e, 1);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopo
 * JD-Core Version:    0.7.0.1
 */