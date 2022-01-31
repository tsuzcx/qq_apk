import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class aqvv
  implements DialogInterface.OnClickListener
{
  aqvv(aqvt paramaqvt, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      aqvt.a(this.jdField_a_of_type_Aqvt, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqvt.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (aqvt.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Aqvt.jdField_a_of_type_AndroidContentContext.getString(2131719481);; paramDialogInterface = aqvt.jdField_a_of_type_JavaLangString)
    {
      aqvt.a(this.jdField_a_of_type_Aqvt, paramDialogInterface);
      if (aqvt.a(this.jdField_a_of_type_Aqvt) == null) {
        break;
      }
      aqvt.a(this.jdField_a_of_type_Aqvt).a(this.jdField_a_of_type_AndroidNetUri);
      aqvt.a(this.jdField_a_of_type_Aqvt, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqvv
 * JD-Core Version:    0.7.0.1
 */