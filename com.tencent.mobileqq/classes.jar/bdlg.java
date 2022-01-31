import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadManager.17;

public class bdlg
  implements DialogInterface.OnClickListener
{
  public bdlg(DownloadManager.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(bdlb.r, false);
    bdkx.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlg
 * JD-Core Version:    0.7.0.1
 */