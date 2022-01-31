import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bkzh
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjah.b("PtuTemplateManager", "【Camera is in Prepareing】toast show: choose cancel");
    bkze.a = null;
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzh
 * JD-Core Version:    0.7.0.1
 */