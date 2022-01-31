import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bjif
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjic.a = null;
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjif
 * JD-Core Version:    0.7.0.1
 */