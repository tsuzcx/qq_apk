import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class awic
  implements DialogInterface.OnClickListener
{
  awic(awia paramawia) {}
  
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
 * Qualified Name:     awic
 * JD-Core Version:    0.7.0.1
 */