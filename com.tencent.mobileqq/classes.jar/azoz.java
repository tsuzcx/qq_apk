import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public final class azoz
  implements TVK_IMediaPlayer.OnErrorListener
{
  public azoz(aznp paramaznp) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.i("SplashMiniGameStarter", 1, "splash_logoerro+ errotype" + paramInt1 + "errcode =" + paramInt2);
    this.a.a(15, 1, 0L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azoz
 * JD-Core Version:    0.7.0.1
 */