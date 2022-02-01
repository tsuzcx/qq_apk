import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;

public class amig
  extends BroadcastReceiver
{
  public amig(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onReceive ===>" + paramContext);
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      if ((this.a.a != null) && (this.a.a.get() != null) && (((TVK_IMediaPlayer)this.a.a.get()).isPlaying())) {
        this.a.k = true;
      }
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amig
 * JD-Core Version:    0.7.0.1
 */