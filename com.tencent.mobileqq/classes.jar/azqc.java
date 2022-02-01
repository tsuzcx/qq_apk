import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class azqc
  implements DialogInterface.OnClickListener
{
  azqc(azpy paramazpy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqc
 * JD-Core Version:    0.7.0.1
 */