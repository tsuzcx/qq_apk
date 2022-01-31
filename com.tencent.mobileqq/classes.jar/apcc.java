import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class apcc
  implements DialogInterface.OnClickListener
{
  apcc(apbu paramapbu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcc
 * JD-Core Version:    0.7.0.1
 */