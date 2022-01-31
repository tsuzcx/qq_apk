import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appstore.dl.DownloadManagerV2.19;

public class bdhm
  implements DialogInterface.OnClickListener
{
  public bdhm(DownloadManagerV2.19 param19) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(bdlb.r, false);
    bdho.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhm
 * JD-Core Version:    0.7.0.1
 */