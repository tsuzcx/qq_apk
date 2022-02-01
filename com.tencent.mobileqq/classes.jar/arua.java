import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class arua
  implements DialogInterface.OnClickListener
{
  arua(artz paramartz, String paramString, atdm paramatdm, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = new StringBuilder();
    if (this.jdField_a_of_type_Artz.a.jdField_b_of_type_Boolean) {}
    for (paramDialogInterface = "https://";; paramDialogInterface = "http://")
    {
      String str = paramDialogInterface + this.jdField_a_of_type_Artz.a.g + ":" + this.jdField_a_of_type_Artz.a.h + "/ftn_compress_getfile/rkey=" + this.jdField_a_of_type_Artz.a.e + "&filetype=" + this.jdField_a_of_type_Artz.a.jdField_b_of_type_Int + "&path=";
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, str);
      }
      paramDialogInterface = this.jdField_a_of_type_JavaLangString;
      try
      {
        localObject = URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf8");
        paramDialogInterface = (DialogInterface)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      paramDialogInterface = str + paramDialogInterface + "&";
      this.jdField_a_of_type_Atdm.b(paramDialogInterface, this.jdField_a_of_type_AndroidOsBundle);
      aszr.a("0X80052CE");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arua
 * JD-Core Version:    0.7.0.1
 */