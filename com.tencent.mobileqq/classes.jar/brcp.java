import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class brcp
  implements DialogInterface.OnClickListener
{
  public brcp(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.pauseDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     brcp
 * JD-Core Version:    0.7.0.1
 */