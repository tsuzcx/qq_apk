import android.os.SystemClock;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class batd
  implements TVK_IMediaPlayer.OnErrorListener
{
  public batd(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("video player error model=" + paramInt1);
      paramTVK_IMediaPlayer.append(",what=" + paramInt2);
      paramTVK_IMediaPlayer.append(",extra=" + paramInt3);
      paramTVK_IMediaPlayer.append(",detailInfo=" + paramString);
      QLog.d("VipVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = VipVideoPlayActivity.b(this.a);
    this.a.a("play_error", paramInt1, paramInt2, l1 - l2, paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batd
 * JD-Core Version:    0.7.0.1
 */