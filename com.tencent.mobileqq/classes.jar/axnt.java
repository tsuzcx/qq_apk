import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.splashad.SplashADView.1.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

public class axnt
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public axnt(SplashADView paramSplashADView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().postDelayed(new SplashADView.1.1(this), 200L);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axnt
 * JD-Core Version:    0.7.0.1
 */