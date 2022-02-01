import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class azws
  implements DialogInterface.OnClickListener
{
  azws(azwo paramazwo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azws
 * JD-Core Version:    0.7.0.1
 */