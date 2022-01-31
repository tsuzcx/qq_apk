import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.2;

public class bdgq
  implements DialogInterface.OnClickListener
{
  public bdgq(DownloadJSApi.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(bdlb.r, false);
    bdgp.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgq
 * JD-Core Version:    0.7.0.1
 */