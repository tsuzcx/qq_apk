import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class bnfi
  implements DialogInterface.OnClickListener
{
  public bnfi(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShortVideoPlayActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfi
 * JD-Core Version:    0.7.0.1
 */