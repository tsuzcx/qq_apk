import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

class bdhq
  implements DialogInterface.OnClickListener
{
  bdhq(bdho parambdho, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdho.a(this.jdField_a_of_type_Bdho, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    axqy.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bdfh.a().a(25, paramDialogInterface);
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.d);
    bdhz.b("6006", "2", "0", this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.i), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhq
 * JD-Core Version:    0.7.0.1
 */