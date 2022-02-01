import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public final class bccp
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public bccp(bcad parambcad) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "video finish");
    this.a.a(15, 1, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bccp
 * JD-Core Version:    0.7.0.1
 */