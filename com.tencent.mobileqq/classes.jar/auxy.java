import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class auxy
  implements DialogInterface.OnClickListener
{
  auxy(auxw paramauxw, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      auxw.a(this.jdField_a_of_type_Auxw, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Auxw.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (auxw.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Auxw.jdField_a_of_type_AndroidContentContext.getString(2131718011);; paramDialogInterface = auxw.jdField_a_of_type_JavaLangString)
    {
      auxw.a(this.jdField_a_of_type_Auxw, paramDialogInterface);
      if (auxw.a(this.jdField_a_of_type_Auxw) == null) {
        break;
      }
      auxw.a(this.jdField_a_of_type_Auxw).a(this.jdField_a_of_type_AndroidNetUri);
      auxw.a(this.jdField_a_of_type_Auxw, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxy
 * JD-Core Version:    0.7.0.1
 */