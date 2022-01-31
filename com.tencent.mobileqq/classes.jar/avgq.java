import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import mqq.os.MqqHandler;

public class avgq
  implements TVK_IMediaPlayer.OnErrorListener
{
  avgq(avgo paramavgo) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoViewTVKImpl", 2, "onError called with: tvk_iMediaPlayer = [" + paramTVK_IMediaPlayer + "], model = [" + paramInt1 + "], what = [" + paramInt2 + "], position = [" + paramInt3 + "], extra = [" + paramString + "], Info = [" + paramObject + "]");
    }
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.2.1(this, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avgq
 * JD-Core Version:    0.7.0.1
 */