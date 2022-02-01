import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

final class bjmv
  implements DialogInterface.OnClickListener
{
  bjmv(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjmu.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    bdla.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bjhn.a().a(25, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmv
 * JD-Core Version:    0.7.0.1
 */