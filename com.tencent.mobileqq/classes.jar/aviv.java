import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class aviv
  implements DialogInterface.OnClickListener
{
  aviv(avit paramavit, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      avit.a(this.jdField_a_of_type_Avit, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Avit.b = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (avit.jdField_a_of_type_JavaLangString != null) {}
    }
    for (paramDialogInterface = this.jdField_a_of_type_Avit.jdField_a_of_type_AndroidContentContext.getString(2131718770);; paramDialogInterface = avit.jdField_a_of_type_JavaLangString)
    {
      avit.a(this.jdField_a_of_type_Avit, paramDialogInterface);
      if (avit.a(this.jdField_a_of_type_Avit) == null) {
        break;
      }
      avit.a(this.jdField_a_of_type_Avit).a(this.jdField_a_of_type_AndroidNetUri);
      avit.a(this.jdField_a_of_type_Avit, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviv
 * JD-Core Version:    0.7.0.1
 */