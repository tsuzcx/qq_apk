import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aumm
  implements DialogInterface.OnClickListener
{
  aumm(aumk paramaumk) {}
  
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
 * Qualified Name:     aumm
 * JD-Core Version:    0.7.0.1
 */