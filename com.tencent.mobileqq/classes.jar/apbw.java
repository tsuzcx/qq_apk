import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class apbw
  implements DialogInterface.OnClickListener
{
  apbw(apbu paramapbu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    paramDialogInterface = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbw
 * JD-Core Version:    0.7.0.1
 */