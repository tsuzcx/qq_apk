import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class auxx
  implements DialogInterface.OnClickListener
{
  auxx(auxw paramauxw, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      auxw.a(this.jdField_a_of_type_Auxw).finish();
      return;
    }
    catch (IOException paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("UriParserPathHelper", 1, "system share.exception.e=", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxx
 * JD-Core Version:    0.7.0.1
 */