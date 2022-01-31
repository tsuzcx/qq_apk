import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class beub
  implements atxr
{
  beub(betz parambetz) {}
  
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
        } while (betz.a(this.a) == null);
        ((AudioManager)((Context)betz.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        betz.a(this.a).c();
        betz.a(this.a, 1);
        if (betz.a(this.a) != null) {
          betz.a(this.a).onVideoStart((int)betz.a(this.a).c());
        }
        betz.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (betz.a(this.a) == null);
      betz.a(this.a).b();
      betz.a(this.a, 4);
      if (betz.a(this.a) != null) {
        betz.a(this.a).onVideoStop();
      }
      betz.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (betz.a(this.a) == null);
    betz.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beub
 * JD-Core Version:    0.7.0.1
 */