import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class aqvw
  implements DialogInterface.OnClickListener
{
  aqvw(aqvv paramaqvv, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      aqvv.a(this.jdField_a_of_type_Aqvv).finish();
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
 * Qualified Name:     aqvw
 * JD-Core Version:    0.7.0.1
 */