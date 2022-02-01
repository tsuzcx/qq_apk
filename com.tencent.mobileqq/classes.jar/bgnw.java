import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.mobileqq.video.VipVideoPlayActivity.VideoPlayerPreparedListener.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class bgnw
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public bgnw(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player prepared");
    }
    this.a.runOnUiThread(new VipVideoPlayActivity.VideoPlayerPreparedListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnw
 * JD-Core Version:    0.7.0.1
 */