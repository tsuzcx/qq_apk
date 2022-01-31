import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.smtt.sdk.TbsReaderView;

class argm
  implements DialogInterface.OnClickListener
{
  argm(argk paramargk, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    argj.a(this.jdField_a_of_type_Argk.jdField_a_of_type_Argj).userStatistics(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_Argk.jdField_a_of_type_AndroidAppActivity.getString(2131694945));
    paramDialogInterface.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    Intent localIntent = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
    paramDialogInterface.putString("big_brother_source_key", "biz_src_jc_file");
    localIntent.putExtra("param", paramDialogInterface);
    localIntent.putExtra("url", this.b);
    this.jdField_a_of_type_Argk.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argm
 * JD-Core Version:    0.7.0.1
 */