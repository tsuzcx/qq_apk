import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

public final class bjfm
  implements DialogInterface.OnClickListener
{
  public bjfm(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjfq.c();
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfm
 * JD-Core Version:    0.7.0.1
 */