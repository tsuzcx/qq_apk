import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class asqu
  implements DialogInterface.OnClickListener
{
  asqu(asqs paramasqs, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      asqs.a(this.jdField_a_of_type_Asqs, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Asqs.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (asqs.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Asqs.jdField_a_of_type_AndroidContentContext.getString(2131720036);; paramDialogInterface = asqs.jdField_a_of_type_JavaLangString)
    {
      asqs.a(this.jdField_a_of_type_Asqs, paramDialogInterface);
      if (asqs.a(this.jdField_a_of_type_Asqs) == null) {
        break;
      }
      asqs.a(this.jdField_a_of_type_Asqs).a(this.jdField_a_of_type_AndroidNetUri);
      asqs.a(this.jdField_a_of_type_Asqs, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqu
 * JD-Core Version:    0.7.0.1
 */