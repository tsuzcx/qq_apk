import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class audb
  implements DialogInterface.OnClickListener
{
  audb(aucz paramaucz, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      aucz.a(this.jdField_a_of_type_Aucz, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aucz.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (aucz.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Aucz.jdField_a_of_type_AndroidContentContext.getString(2131718384);; paramDialogInterface = aucz.jdField_a_of_type_JavaLangString)
    {
      aucz.a(this.jdField_a_of_type_Aucz, paramDialogInterface);
      if (aucz.a(this.jdField_a_of_type_Aucz) == null) {
        break;
      }
      aucz.a(this.jdField_a_of_type_Aucz).a(this.jdField_a_of_type_AndroidNetUri);
      aucz.a(this.jdField_a_of_type_Aucz, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audb
 * JD-Core Version:    0.7.0.1
 */