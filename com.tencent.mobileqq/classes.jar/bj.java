import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.dataline.activities.LiteActivity;

public class bj
  implements DialogInterface.OnDismissListener
{
  public bj(LiteActivity paramLiteActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (LiteActivity.a(this.a))
    {
      LiteActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bj
 * JD-Core Version:    0.7.0.1
 */