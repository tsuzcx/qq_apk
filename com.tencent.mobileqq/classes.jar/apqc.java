import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class apqc
  implements TVK_IMediaPlayer.OnCompletionListener
{
  apqc(appt paramappt) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    new Handler(Looper.getMainLooper()).post(new VideoFilePresenter.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqc
 * JD-Core Version:    0.7.0.1
 */