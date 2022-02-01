import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class audp
  implements DialogInterface.OnClickListener
{
  audp(audq paramaudq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onNo();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audp
 * JD-Core Version:    0.7.0.1
 */