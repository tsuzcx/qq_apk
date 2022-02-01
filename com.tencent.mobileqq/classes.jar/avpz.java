import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class avpz
  implements DialogInterface.OnClickListener
{
  avpz(avpx paramavpx, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      avpx.a(this.jdField_a_of_type_Avpx, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Avpx.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (avpx.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Avpx.jdField_a_of_type_AndroidContentContext.getString(2131718143);; paramDialogInterface = avpx.jdField_a_of_type_JavaLangString)
    {
      avpx.a(this.jdField_a_of_type_Avpx, paramDialogInterface);
      if (avpx.a(this.jdField_a_of_type_Avpx) == null) {
        break;
      }
      avpx.a(this.jdField_a_of_type_Avpx).a(this.jdField_a_of_type_AndroidNetUri);
      avpx.a(this.jdField_a_of_type_Avpx, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpz
 * JD-Core Version:    0.7.0.1
 */