import android.os.Handler;
import com.tencent.mobileqq.hotpic.VideoBaseItem.2.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class aqhn
  implements TVK_IMediaPlayer.OnCompletionListener
{
  aqhn(aqhl paramaqhl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    aqhl.a(this.a).post(new VideoBaseItem.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqhn
 * JD-Core Version:    0.7.0.1
 */