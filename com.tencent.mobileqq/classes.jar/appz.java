import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.4.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

public class appz
  implements TVK_IMediaPlayer.OnInfoListener
{
  appz(appt paramappt) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    new Handler(Looper.getMainLooper()).post(new VideoFilePresenter.4.1(this, paramInt));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appz
 * JD-Core Version:    0.7.0.1
 */