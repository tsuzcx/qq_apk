import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bbrc
  implements arkm
{
  bbrc(bbra parambbra) {}
  
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
        } while (bbra.a(this.a) == null);
        ((AudioManager)((Context)bbra.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bbra.a(this.a).c();
        bbra.a(this.a, 1);
        if (bbra.a(this.a) != null) {
          bbra.a(this.a).onVideoStart((int)bbra.a(this.a).c());
        }
        bbra.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bbra.a(this.a) == null);
      bbra.a(this.a).b();
      bbra.a(this.a, 4);
      if (bbra.a(this.a) != null) {
        bbra.a(this.a).onVideoStop();
      }
      bbra.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bbra.a(this.a) == null);
    bbra.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbrc
 * JD-Core Version:    0.7.0.1
 */