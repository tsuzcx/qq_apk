import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bnpd
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bljn.b("PtuTemplateManager", "【Camera is in Prepareing】toast show: choose cancel");
    bnpa.a = null;
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpd
 * JD-Core Version:    0.7.0.1
 */