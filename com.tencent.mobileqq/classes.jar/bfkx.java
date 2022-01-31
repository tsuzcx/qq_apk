import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

class bfkx
  implements DialogInterface.OnClickListener
{
  bfkx(bfkv parambfkv, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bfkv.a(this.jdField_a_of_type_Bfkv, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    azqs.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bfio.a().a(25, paramDialogInterface);
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.d);
    bflg.b("6006", "2", "0", this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.i), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkx
 * JD-Core Version:    0.7.0.1
 */