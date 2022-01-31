import CardPay.Channel;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.thirdpay.ThirdPayGate;

public class amot
  extends Handler
{
  public amot(ThirdPayGate paramThirdPayGate, String paramString, long paramLong, Channel paramChannel, Bundle paramBundle, Activity paramActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-suc", 0, 0, this.jdField_a_of_type_JavaLangString, System.currentTimeMillis() - this.jdField_a_of_type_Long + "", "" + this.jdField_a_of_type_CardPayChannel.pluginSize, "");
      ThirdPayGate.access$300(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
      return;
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-fail", 0, 0, this.jdField_a_of_type_JavaLangString, "by download", "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    } while (ThirdPayGate.access$400(this.jdField_a_of_type_CooperationThirdpayThirdPayGate) == null);
    ThirdPayGate.access$400(this.jdField_a_of_type_CooperationThirdpayThirdPayGate).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amot
 * JD-Core Version:    0.7.0.1
 */