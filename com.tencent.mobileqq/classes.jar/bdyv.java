import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2;
import com.tencent.qphone.base.util.QLog;

public class bdyv
  implements MediaPlayer.OnSeekCompleteListener
{
  public bdyv(VideoSprite.2 param2) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.a.this$0.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.a.this$0.g = true;
      if (this.a.this$0.jdField_a_of_type_Bdyz != null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyv
 * JD-Core Version:    0.7.0.1
 */