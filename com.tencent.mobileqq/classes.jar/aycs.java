import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class aycs
  implements MediaPlayer.OnPreparedListener
{
  public aycs(VideoSprite paramVideoSprite) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.a.n = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
      this.a.o = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.a.g = true;
      if (this.a.jdField_a_of_type_Aycv != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a, 33L);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(paramMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycs
 * JD-Core Version:    0.7.0.1
 */