import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class borl
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bpam.d("AEResUtil", "【Camera is in Prepareing】toast show: choose cancel");
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borl
 * JD-Core Version:    0.7.0.1
 */