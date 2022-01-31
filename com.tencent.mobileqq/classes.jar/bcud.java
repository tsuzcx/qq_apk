import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bcud
  implements asgp
{
  bcud(bcub parambcub) {}
  
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
        } while (bcub.a(this.a) == null);
        ((AudioManager)((Context)bcub.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bcub.a(this.a).c();
        bcub.a(this.a, 1);
        if (bcub.a(this.a) != null) {
          bcub.a(this.a).onVideoStart((int)bcub.a(this.a).c());
        }
        bcub.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bcub.a(this.a) == null);
      bcub.a(this.a).b();
      bcub.a(this.a, 4);
      if (bcub.a(this.a) != null) {
        bcub.a(this.a).onVideoStop();
      }
      bcub.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bcub.a(this.a) == null);
    bcub.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcud
 * JD-Core Version:    0.7.0.1
 */