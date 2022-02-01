import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

final class avxj
  implements DialogInterface.OnClickListener
{
  avxj(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    biwm.c();
    FloatingScreenPermission.requestPermission(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxj
 * JD-Core Version:    0.7.0.1
 */