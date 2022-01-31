import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ayvt
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.search.util.VADHelper.c = false;
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvt
 * JD-Core Version:    0.7.0.1
 */