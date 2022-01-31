import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class awdt
  implements DialogInterface.OnClickListener
{
  awdt(awdr paramawdr) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdt
 * JD-Core Version:    0.7.0.1
 */