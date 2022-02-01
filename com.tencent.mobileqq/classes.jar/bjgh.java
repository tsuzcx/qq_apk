import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bjgh
  implements axcc
{
  bjgh(bjgf parambjgf) {}
  
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
        } while (bjgf.a(this.a) == null);
        ((AudioManager)((Context)bjgf.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bjgf.a(this.a).c();
        bjgf.a(this.a, 1);
        if (bjgf.a(this.a) != null) {
          bjgf.a(this.a).onVideoStart((int)bjgf.a(this.a).c());
        }
        bjgf.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bjgf.a(this.a) == null);
      bjgf.a(this.a).b();
      bjgf.a(this.a, 4);
      if (bjgf.a(this.a) != null) {
        bjgf.a(this.a).onVideoStop();
      }
      bjgf.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bjgf.a(this.a) == null);
    bjgf.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgh
 * JD-Core Version:    0.7.0.1
 */