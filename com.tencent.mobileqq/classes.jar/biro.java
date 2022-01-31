import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class biro
  implements DialogInterface.OnClickListener
{
  biro(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biro
 * JD-Core Version:    0.7.0.1
 */