import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

final class arkq
  implements DialogInterface.OnClickListener
{
  arkq(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcub.c();
    FloatingScreenPermission.requestPermission(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkq
 * JD-Core Version:    0.7.0.1
 */