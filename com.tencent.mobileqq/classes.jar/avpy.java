import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class avpy
  implements DialogInterface.OnClickListener
{
  avpy(avpx paramavpx, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      avpx.a(this.jdField_a_of_type_Avpx).finish();
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
 * Qualified Name:     avpy
 * JD-Core Version:    0.7.0.1
 */