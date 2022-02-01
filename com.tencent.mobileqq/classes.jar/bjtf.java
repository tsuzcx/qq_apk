import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

class bjtf
  implements DialogInterface.OnClickListener
{
  bjtf(bjtd parambjtd, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjtd.a(this.jdField_a_of_type_Bjtd, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    bdll.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bjqw.a().a(25, paramDialogInterface);
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.d);
    bjto.b("6006", "2", "0", this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.i), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtf
 * JD-Core Version:    0.7.0.1
 */