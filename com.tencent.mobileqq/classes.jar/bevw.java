import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bevw
  implements DialogInterface.OnClickListener
{
  bevw(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevw
 * JD-Core Version:    0.7.0.1
 */