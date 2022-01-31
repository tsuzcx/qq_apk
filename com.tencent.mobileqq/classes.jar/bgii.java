import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bgii
  implements DialogInterface.OnClickListener
{
  bgii(bafb parambafb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgii
 * JD-Core Version:    0.7.0.1
 */