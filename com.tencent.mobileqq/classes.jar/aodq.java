import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aodq
  implements DialogInterface.OnClickListener
{
  aodq(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aodq
 * JD-Core Version:    0.7.0.1
 */