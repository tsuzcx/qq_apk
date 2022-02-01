import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class atxo
  implements DialogInterface.OnClickListener
{
  atxo(atxk paramatxk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.c();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxo
 * JD-Core Version:    0.7.0.1
 */