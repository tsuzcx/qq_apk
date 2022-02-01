import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class aryp
  implements DialogInterface.OnClickListener
{
  aryp(aryn paramaryn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    paramDialogInterface = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryp
 * JD-Core Version:    0.7.0.1
 */