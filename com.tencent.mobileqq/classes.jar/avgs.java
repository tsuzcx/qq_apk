import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.4.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

public class avgs
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  avgs(avgo paramavgo) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avgs
 * JD-Core Version:    0.7.0.1
 */