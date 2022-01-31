import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

class bdhb
  implements DialogInterface.OnClickListener
{
  bdhb(bdgz parambdgz, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdgz.a(this.jdField_a_of_type_Bdgz, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    axqw.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bdes.a().a(25, paramDialogInterface);
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.d);
    bdhk.b("6006", "2", "0", this.jdField_a_of_type_AndroidOsBundle.getString(bdkm.i), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhb
 * JD-Core Version:    0.7.0.1
 */