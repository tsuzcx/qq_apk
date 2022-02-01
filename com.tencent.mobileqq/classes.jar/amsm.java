import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class amsm
  implements DialogInterface.OnDismissListener
{
  public amsm(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FrameHelperActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsm
 * JD-Core Version:    0.7.0.1
 */