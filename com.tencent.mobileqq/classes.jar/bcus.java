import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bcus
  implements asgr
{
  bcus(bcuq parambcuq) {}
  
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
        } while (bcuq.a(this.a) == null);
        ((AudioManager)((Context)bcuq.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bcuq.a(this.a).c();
        bcuq.a(this.a, 1);
        if (bcuq.a(this.a) != null) {
          bcuq.a(this.a).onVideoStart((int)bcuq.a(this.a).c());
        }
        bcuq.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bcuq.a(this.a) == null);
      bcuq.a(this.a).b();
      bcuq.a(this.a, 4);
      if (bcuq.a(this.a) != null) {
        bcuq.a(this.a).onVideoStop();
      }
      bcuq.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bcuq.a(this.a) == null);
    bcuq.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcus
 * JD-Core Version:    0.7.0.1
 */