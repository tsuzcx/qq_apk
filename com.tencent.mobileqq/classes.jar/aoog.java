import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class aoog
  implements DialogInterface.OnClickListener
{
  aoog(aoof paramaoof, String paramString, apdc paramapdc, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str2 = "http://" + this.jdField_a_of_type_Aoof.a.h + ":" + this.jdField_a_of_type_Aoof.a.i + "/ftn_compress_getfile/rkey=" + this.jdField_a_of_type_Aoof.a.f + "&filetype=" + this.jdField_a_of_type_Aoof.a.b + "&path=";
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, str2);
    }
    paramDialogInterface = this.jdField_a_of_type_JavaLangString;
    try
    {
      String str1 = URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf8");
      paramDialogInterface = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    paramDialogInterface = str2 + paramDialogInterface + "&";
    this.jdField_a_of_type_Apdc.b(paramDialogInterface, this.jdField_a_of_type_AndroidOsBundle);
    apue.a("0X80052CE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoog
 * JD-Core Version:    0.7.0.1
 */