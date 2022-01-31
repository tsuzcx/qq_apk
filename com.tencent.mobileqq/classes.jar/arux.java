import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class arux
  implements DialogInterface.OnClickListener
{
  arux(arut paramarut) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.c();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arux
 * JD-Core Version:    0.7.0.1
 */