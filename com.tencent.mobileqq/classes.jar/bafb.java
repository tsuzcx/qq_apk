import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class bafb
  implements MediaPlayer.OnPreparedListener
{
  private WeakReference<VideoSprite> a;
  
  private bafb(VideoSprite paramVideoSprite)
  {
    this.a = new WeakReference(paramVideoSprite);
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (VideoSprite)this.a.get();
    if (paramMediaPlayer == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramMediaPlayer.n = paramMediaPlayer.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
          paramMediaPlayer.o = paramMediaPlayer.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
          paramMediaPlayer.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          paramMediaPlayer.g = true;
          if (paramMediaPlayer.jdField_a_of_type_Bafa != null)
          {
            paramMediaPlayer.jdField_a_of_type_AndroidOsHandler.postDelayed(paramMediaPlayer, 33L);
            return;
          }
        }
        catch (Exception paramMediaPlayer) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(paramMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafb
 * JD-Core Version:    0.7.0.1
 */