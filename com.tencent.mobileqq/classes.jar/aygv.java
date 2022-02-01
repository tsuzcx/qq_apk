import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.3.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class aygv
  implements TVK_IMediaPlayer.OnInfoListener
{
  aygv(aygs paramaygs) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoViewTVKImpl", 2, "onInfo what=" + paramInt + "  ex:" + paramObject);
    }
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.3.1(this, paramInt, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygv
 * JD-Core Version:    0.7.0.1
 */