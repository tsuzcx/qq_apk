import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.thirdpay.ThirdPayGate;

public class anna
  implements DialogInterface.OnClickListener
{
  public anna(ThirdPayGate paramThirdPayGate, String paramString, PluginInterface paramPluginInterface, Activity paramActivity, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-again", 0, 0, this.jdField_a_of_type_JavaLangString, "by download", "", "");
    paramDialogInterface.dismiss();
    ThirdPayGate.access$100(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface, this.jdField_a_of_type_JavaLangString);
    ThirdPayGate.access$200(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anna
 * JD-Core Version:    0.7.0.1
 */