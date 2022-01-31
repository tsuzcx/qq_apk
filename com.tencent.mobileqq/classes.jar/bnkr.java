import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bnkr
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    blfg.b("PtuTemplateManager", "【Camera is in Prepareing】toast show: choose cancel");
    bnko.a = null;
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkr
 * JD-Core Version:    0.7.0.1
 */