import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

public final class bcty
  implements DialogInterface.OnClickListener
{
  public bcty(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcub.c();
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcty
 * JD-Core Version:    0.7.0.1
 */