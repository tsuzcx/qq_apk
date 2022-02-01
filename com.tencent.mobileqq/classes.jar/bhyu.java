import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

class bhyu
  implements DialogInterface.OnClickListener
{
  bhyu(bhys parambhys, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bhys.a(this.jdField_a_of_type_Bhys, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
    bcef.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bibw.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bibw.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bibw.d);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    bhwl.a().a(25, paramDialogInterface);
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bibw.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bibw.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bibw.d);
    bhzd.b("6006", "2", "0", this.jdField_a_of_type_AndroidOsBundle.getString(bibw.i), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyu
 * JD-Core Version:    0.7.0.1
 */