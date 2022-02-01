import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aodr
  implements DialogInterface.OnClickListener
{
  aodr(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aodp.a("1");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aodr
 * JD-Core Version:    0.7.0.1
 */