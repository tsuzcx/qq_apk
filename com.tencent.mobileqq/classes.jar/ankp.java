import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ankp
  implements DialogInterface.OnClickListener
{
  ankp(ankn paramankn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    paramDialogInterface = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ankp
 * JD-Core Version:    0.7.0.1
 */