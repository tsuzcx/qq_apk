import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class blgi
  implements DialogInterface.OnClickListener
{
  blgi(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgi
 * JD-Core Version:    0.7.0.1
 */