import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;

public class apwa
  implements DialogInterface.OnClickListener
{
  public apwa(ArkAppModuleBase.APIAuthority.1 param1, bhpc parambhpc, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_Apwc != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_Apwc.b();
    }
    if (this.jdField_a_of_type_Bhpc.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      label39:
      apvy.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.d, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.e, 2);
      paramDialogInterface = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131690104), 2131718195, 2131718195, new bhme(), null);
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
 * Qualified Name:     apwa
 * JD-Core Version:    0.7.0.1
 */