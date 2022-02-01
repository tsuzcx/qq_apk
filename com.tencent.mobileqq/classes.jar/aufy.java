import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aufy
  implements DialogInterface.OnClickListener
{
  aufy(aufu paramaufu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.c();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufy
 * JD-Core Version:    0.7.0.1
 */