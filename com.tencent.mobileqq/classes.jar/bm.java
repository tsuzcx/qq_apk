import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.dataline.activities.LiteActivity;

public class bm
  implements DialogInterface.OnDismissListener
{
  public bm(LiteActivity paramLiteActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (LiteActivity.b(this.a))
    {
      LiteActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.7.0.1
 */