import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bhmn
  implements avpj
{
  bhmn(bhml parambhml) {}
  
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
        } while (bhml.a(this.a) == null);
        ((AudioManager)((Context)bhml.a(this.a).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        bhml.a(this.a).c();
        bhml.a(this.a, 1);
        if (bhml.a(this.a) != null) {
          bhml.a(this.a).onVideoStart((int)bhml.a(this.a).c());
        }
        bhml.a(this.a).postDelayed(this.a.a, 100L);
        return;
      } while (bhml.a(this.a) == null);
      bhml.a(this.a).b();
      bhml.a(this.a, 4);
      if (bhml.a(this.a) != null) {
        bhml.a(this.a).onVideoStop();
      }
      bhml.a(this.a).removeCallbacks(this.a.a);
      return;
    } while (bhml.a(this.a) == null);
    bhml.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmn
 * JD-Core Version:    0.7.0.1
 */