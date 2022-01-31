import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class ariu
  implements TVK_IMediaPlayer.OnCompletionListener
{
  ariu(aris paramaris) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManagerV2.getUIHandlerV2().post(new VideoFilePresenter.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariu
 * JD-Core Version:    0.7.0.1
 */