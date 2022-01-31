import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class aqbt
  implements DialogInterface.OnClickListener
{
  aqbt(aqbr paramaqbr, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      aqbr.a(this.jdField_a_of_type_Aqbr, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqbr.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UriParserPathHelper", 2, "copy file error", paramDialogInterface);
      }
      if (aqbr.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Aqbr.jdField_a_of_type_AndroidContentContext.getString(2131653600);; paramDialogInterface = aqbr.jdField_a_of_type_JavaLangString)
    {
      aqbr.a(this.jdField_a_of_type_Aqbr, paramDialogInterface);
      if (aqbr.a(this.jdField_a_of_type_Aqbr) == null) {
        break;
      }
      aqbr.a(this.jdField_a_of_type_Aqbr).a(this.jdField_a_of_type_AndroidNetUri);
      aqbr.a(this.jdField_a_of_type_Aqbr, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqbt
 * JD-Core Version:    0.7.0.1
 */