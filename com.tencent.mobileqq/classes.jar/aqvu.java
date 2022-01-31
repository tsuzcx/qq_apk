import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class aqvu
  implements DialogInterface.OnClickListener
{
  aqvu(aqvt paramaqvt, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      aqvt.a(this.jdField_a_of_type_Aqvt).finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqvu
 * JD-Core Version:    0.7.0.1
 */