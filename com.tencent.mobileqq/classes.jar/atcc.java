import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class atcc
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(null, "dc00898", "", "", "0X800ADA8", "0X800ADA8", 2, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcc
 * JD-Core Version:    0.7.0.1
 */