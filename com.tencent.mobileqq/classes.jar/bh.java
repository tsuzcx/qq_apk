import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;

public class bh
  implements DialogInterface.OnClickListener
{
  public bh(LiteActivity paramLiteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LiteActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bh
 * JD-Core Version:    0.7.0.1
 */