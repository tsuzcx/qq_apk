import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aumk
  implements DialogInterface.OnClickListener
{
  aumk(aumi paramaumi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aumk
 * JD-Core Version:    0.7.0.1
 */