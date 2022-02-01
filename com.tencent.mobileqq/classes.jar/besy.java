import android.os.Handler;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.22.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

public class besy
  implements ISuperPlayer.OnCompletionListener
{
  public besy(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "onCompletion");
    }
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.22.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besy
 * JD-Core Version:    0.7.0.1
 */