import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bnkp
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bnko.a = null;
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkp
 * JD-Core Version:    0.7.0.1
 */