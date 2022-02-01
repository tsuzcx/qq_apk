import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bifi
  implements awjk
{
  bifi(bifg parambifg) {}
  
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
        } while (bifg.a(this.a) == null);
        ((AudioManager)((Context)bifg.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bifg.a(this.a).c();
        bifg.a(this.a, 1);
        if (bifg.a(this.a) != null) {
          bifg.a(this.a).onVideoStart((int)bifg.a(this.a).c());
        }
        bifg.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bifg.a(this.a) == null);
      bifg.a(this.a).b();
      bifg.a(this.a, 4);
      if (bifg.a(this.a) != null) {
        bifg.a(this.a).onVideoStop();
      }
      bifg.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bifg.a(this.a) == null);
    bifg.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifi
 * JD-Core Version:    0.7.0.1
 */