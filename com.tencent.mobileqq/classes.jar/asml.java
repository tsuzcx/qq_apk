import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class asml
  implements DialogInterface.OnClickListener
{
  asml(asmj paramasmj, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      asmj.a(this.jdField_a_of_type_Asmj, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Asmj.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (asmj.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Asmj.jdField_a_of_type_AndroidContentContext.getString(2131720024);; paramDialogInterface = asmj.jdField_a_of_type_JavaLangString)
    {
      asmj.a(this.jdField_a_of_type_Asmj, paramDialogInterface);
      if (asmj.a(this.jdField_a_of_type_Asmj) == null) {
        break;
      }
      asmj.a(this.jdField_a_of_type_Asmj).a(this.jdField_a_of_type_AndroidNetUri);
      asmj.a(this.jdField_a_of_type_Asmj, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asml
 * JD-Core Version:    0.7.0.1
 */