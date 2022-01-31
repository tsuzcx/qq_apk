import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class arjf
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  arjf(aris paramaris) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.runOnUiThread(new VideoFilePresenter.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjf
 * JD-Core Version:    0.7.0.1
 */