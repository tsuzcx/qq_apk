import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bgup
  implements DialogInterface.OnClickListener
{
  bgup(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgup
 * JD-Core Version:    0.7.0.1
 */