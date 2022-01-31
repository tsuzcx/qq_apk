import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qqfav.widget.QfavJumpActivity;
import java.io.IOException;
import java.io.InputStream;

public class bgrv
  implements DialogInterface.OnClickListener
{
  public bgrv(QfavJumpActivity paramQfavJumpActivity, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity.finish();
      return;
    }
    catch (IOException paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgrv
 * JD-Core Version:    0.7.0.1
 */