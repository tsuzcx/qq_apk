import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;

final class bcgi
  implements DialogInterface.OnClickListener
{
  bcgi(Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("qqupdate_support_go_market", 0);
    if ((paramDialogInterface != null) && (paramInt != 0))
    {
      UpgradeDetailActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      awqx.b(null, "dc00898", "", "", "0X800A74F", "0X800A74F", 0, 0, "", "", "", "");
      bchb.a(this.jdField_a_of_type_AndroidOsBundle.getString(bcgl.b));
      return;
    }
    bcgh.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    awqx.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bcgl.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bcgl.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bcgl.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bcar.a().a(25, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcgi
 * JD-Core Version:    0.7.0.1
 */