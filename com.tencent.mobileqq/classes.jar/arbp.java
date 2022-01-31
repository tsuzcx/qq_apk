import android.os.Handler;
import com.tencent.mobileqq.hotpic.VideoBaseItem.2.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class arbp
  implements TVK_IMediaPlayer.OnCompletionListener
{
  arbp(arbn paramarbn) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    arbn.a(this.a).post(new VideoBaseItem.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbp
 * JD-Core Version:    0.7.0.1
 */