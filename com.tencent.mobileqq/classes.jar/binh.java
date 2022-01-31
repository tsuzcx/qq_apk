import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class binh
  implements DialogInterface.OnClickListener
{
  binh(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     binh
 * JD-Core Version:    0.7.0.1
 */