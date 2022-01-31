import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bgyw
  implements DialogInterface.OnClickListener
{
  bgyw(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyw
 * JD-Core Version:    0.7.0.1
 */