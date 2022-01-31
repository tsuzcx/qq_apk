import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class atom
  implements DialogInterface.OnClickListener
{
  atom(atok paramatok) {}
  
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
 * Qualified Name:     atom
 * JD-Core Version:    0.7.0.1
 */