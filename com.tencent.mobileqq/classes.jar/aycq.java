import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.1.1;

public class aycq
  implements MediaPlayer.OnCompletionListener
{
  public aycq(VideoSprite paramVideoSprite) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.j) {
      this.a.b.b(new VideoSprite.1.1(this));
    }
    do
    {
      return;
      this.a.g = false;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    } while (this.a.jdField_a_of_type_Aycd == null);
    this.a.jdField_a_of_type_Aycd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycq
 * JD-Core Version:    0.7.0.1
 */