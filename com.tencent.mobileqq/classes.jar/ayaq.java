import android.os.Handler;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.23.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class ayaq
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public ayaq(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "onCompletion");
    }
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.23.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayaq
 * JD-Core Version:    0.7.0.1
 */