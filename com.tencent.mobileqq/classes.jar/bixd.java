import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bixd
  implements awvo
{
  bixd(bixb parambixb) {}
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TVKVideoController", 4, new Object[] { "onFocusChange focusType:", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (bixb.a(this.a) == null);
        ((AudioManager)((Context)bixb.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bixb.a(this.a).c();
        bixb.a(this.a, 1);
        if (bixb.a(this.a) != null) {
          bixb.a(this.a).onVideoStart((int)bixb.a(this.a).c());
        }
        bixb.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bixb.a(this.a) == null);
      bixb.a(this.a).b();
      bixb.a(this.a, 4);
      if (bixb.a(this.a) != null) {
        bixb.a(this.a).onVideoStop();
      }
      bixb.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bixb.a(this.a) == null);
    bixb.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixd
 * JD-Core Version:    0.7.0.1
 */