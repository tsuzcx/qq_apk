import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import java.io.IOException;
import java.io.InputStream;

public class be
  implements DialogInterface.OnClickListener
{
  public be(LiteActivity paramLiteActivity, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     be
 * JD-Core Version:    0.7.0.1
 */