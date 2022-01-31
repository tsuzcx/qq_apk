import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.5;
import com.tencent.qphone.base.util.QLog;

public class ayct
  implements MediaPlayer.OnSeekCompleteListener
{
  public ayct(VideoSprite.5 param5) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.a.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.a.this$0.g = true;
      if (this.a.this$0.jdField_a_of_type_Aycv != null) {
        this.a.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.this$0, 33L);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "playVideo: " + QLog.getStackTraceString(paramMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayct
 * JD-Core Version:    0.7.0.1
 */