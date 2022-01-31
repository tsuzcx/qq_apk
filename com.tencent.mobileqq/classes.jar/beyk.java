import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class beyk
  implements auca
{
  beyk(beyi parambeyi) {}
  
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
        } while (beyi.a(this.a) == null);
        ((AudioManager)((Context)beyi.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        beyi.a(this.a).c();
        beyi.a(this.a, 1);
        if (beyi.a(this.a) != null) {
          beyi.a(this.a).onVideoStart((int)beyi.a(this.a).c());
        }
        beyi.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (beyi.a(this.a) == null);
      beyi.a(this.a).b();
      beyi.a(this.a, 4);
      if (beyi.a(this.a) != null) {
        beyi.a(this.a).onVideoStop();
      }
      beyi.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (beyi.a(this.a) == null);
    beyi.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyk
 * JD-Core Version:    0.7.0.1
 */