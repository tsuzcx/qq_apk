import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bnpb
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bnpa.a = null;
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpb
 * JD-Core Version:    0.7.0.1
 */