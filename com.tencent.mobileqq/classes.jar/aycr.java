import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class aycr
  implements MediaPlayer.OnErrorListener
{
  public aycr(VideoSprite paramVideoSprite) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoSprite", 2, "onError: " + paramInt1);
    }
    if (paramInt1 == 1)
    {
      if (this.a.a != null) {
        this.a.a.a();
      }
      this.a.j();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycr
 * JD-Core Version:    0.7.0.1
 */