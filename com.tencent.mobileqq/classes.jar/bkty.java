import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class bkty
  implements DialogInterface.OnClickListener
{
  public bkty(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShortVideoPlayActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkty
 * JD-Core Version:    0.7.0.1
 */