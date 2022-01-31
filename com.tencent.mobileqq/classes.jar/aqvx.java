import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class aqvx
  implements DialogInterface.OnClickListener
{
  aqvx(aqvv paramaqvv, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      aqvv.a(this.jdField_a_of_type_Aqvv, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqvv.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (aqvv.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Aqvv.jdField_a_of_type_AndroidContentContext.getString(2131719492);; paramDialogInterface = aqvv.jdField_a_of_type_JavaLangString)
    {
      aqvv.a(this.jdField_a_of_type_Aqvv, paramDialogInterface);
      if (aqvv.a(this.jdField_a_of_type_Aqvv) == null) {
        break;
      }
      aqvv.a(this.jdField_a_of_type_Aqvv).a(this.jdField_a_of_type_AndroidNetUri);
      aqvv.a(this.jdField_a_of_type_Aqvv, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqvx
 * JD-Core Version:    0.7.0.1
 */