import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class baey
  implements MediaPlayer.OnErrorListener
{
  private WeakReference<VideoSprite> a;
  
  private baey(VideoSprite paramVideoSprite)
  {
    this.a = new WeakReference(paramVideoSprite);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (VideoSprite)this.a.get();
    if (paramMediaPlayer == null) {}
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("VideoSprite", 2, "onError: " + paramInt1);
      }
    } while (paramInt1 != 1);
    if (paramMediaPlayer.a != null) {
      paramMediaPlayer.a.a();
    }
    paramMediaPlayer.j();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baey
 * JD-Core Version:    0.7.0.1
 */