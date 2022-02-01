import android.os.Handler;
import com.tencent.mobileqq.hotpic.VideoBaseItem.2.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class avvz
  implements TVK_IMediaPlayer.OnCompletionListener
{
  avvz(avvx paramavvx) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    avvx.a(this.a).post(new VideoBaseItem.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvz
 * JD-Core Version:    0.7.0.1
 */