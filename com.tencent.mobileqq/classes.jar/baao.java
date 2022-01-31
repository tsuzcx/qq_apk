import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.CompletionListener.1;
import mqq.util.WeakReference;

public class baao
  implements MediaPlayer.OnCompletionListener
{
  private WeakReference<VideoSprite> a;
  
  private baao(VideoSprite paramVideoSprite)
  {
    this.a = new WeakReference(paramVideoSprite);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = (VideoSprite)this.a.get();
    if (paramMediaPlayer == null) {}
    do
    {
      return;
      if (paramMediaPlayer.j)
      {
        paramMediaPlayer.b.b(new VideoSprite.CompletionListener.1(this, paramMediaPlayer));
        return;
      }
      paramMediaPlayer.g = false;
      paramMediaPlayer.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    } while (paramMediaPlayer.jdField_a_of_type_Baaa == null);
    paramMediaPlayer.jdField_a_of_type_Baaa.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baao
 * JD-Core Version:    0.7.0.1
 */