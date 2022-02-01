import android.os.Handler;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.24.1;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.24.2;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;

public class bdlx
  implements ISuperPlayer.OnInfoListener
{
  public bdlx(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.24.1(this));
      continue;
      TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.24.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdlx
 * JD-Core Version:    0.7.0.1
 */