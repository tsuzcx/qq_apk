import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.core.widget.media.VideoGestureLayout;
import com.tencent.qqmini.sdk.core.widget.media.VideoGestureRelativeLayout;

public class bgsz
  implements bgtj
{
  public bgsz(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (MiniAppVideoPlayer.a(this.a).getVisibility() != 8)
    {
      if (MiniAppVideoPlayer.a(this.a).getVisibility() == 4) {
        MiniAppVideoPlayer.a(this.a);
      }
    }
    else {
      return;
    }
    MiniAppVideoPlayer.b(this.a);
  }
  
  public void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 0.0F;
    if (!this.a.o) {}
    while (this.a.c) {
      return;
    }
    paramFloat2 = (paramMotionEvent1.getY() - paramMotionEvent2.getY()) / MiniAppVideoPlayer.a(this.a).getHeight() + MiniAppVideoPlayer.a(this.a);
    if (paramFloat2 < 0.0F) {}
    for (;;)
    {
      if ((MiniAppVideoPlayer.a(this.a) != null) && (MiniAppVideoPlayer.a(this.a) != null))
      {
        MiniAppVideoPlayer.a(this.a).screenBrightness = paramFloat1;
        MiniAppVideoPlayer.a(this.a).setAttributes(MiniAppVideoPlayer.a(this.a));
      }
      MiniAppVideoPlayer.a(this.a).setProgress((int)(paramFloat1 * 100.0F));
      MiniAppVideoPlayer.a(this.a).setImageResource(2130840966);
      MiniAppVideoPlayer.a(this.a).a();
      return;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      } else {
        paramFloat1 = paramFloat2;
      }
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    if (this.a.B)
    {
      this.a.b();
      MiniAppVideoPlayer.a(this.a, MiniAppVideoPlayer.a(this.a).isPlaying());
      if (MiniAppVideoPlayer.a(this.a).isPlaying()) {
        MiniAppVideoPlayer.a(this.a);
      }
    }
    else
    {
      return;
    }
    MiniAppVideoPlayer.c(this.a);
  }
  
  public void b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.o) {}
    while ((this.a.c) || (MiniAppVideoPlayer.a(this.a) == 0)) {
      return;
    }
    int i = MiniAppVideoPlayer.a(this.a).getHeight() / MiniAppVideoPlayer.a(this.a);
    i = (int)((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / i + MiniAppVideoPlayer.b(this.a));
    if (MiniAppVideoPlayer.a(this.a) != null) {
      MiniAppVideoPlayer.a(this.a).setStreamVolume(3, i, 4);
    }
    i = (int)(i / Float.valueOf(MiniAppVideoPlayer.a(this.a)).floatValue() * 100.0F);
    if (i >= 50) {
      MiniAppVideoPlayer.a(this.a).setImageResource(2130840971);
    }
    for (;;)
    {
      MiniAppVideoPlayer.a(this.a).setProgress(i);
      MiniAppVideoPlayer.a(this.a).a();
      return;
      if (i > 0) {
        MiniAppVideoPlayer.a(this.a).setImageResource(2130840972);
      } else {
        MiniAppVideoPlayer.a(this.a).setImageResource(2130840973);
      }
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    MiniAppVideoPlayer.b(this.a, MiniAppVideoPlayer.d(this.a));
    if (MiniAppVideoPlayer.a(this.a) != null) {
      MiniAppVideoPlayer.c(this.a, MiniAppVideoPlayer.a(this.a).getStreamVolume(3));
    }
    if (MiniAppVideoPlayer.a(this.a) != null) {
      MiniAppVideoPlayer.a(this.a, MiniAppVideoPlayer.a(this.a).screenBrightness);
    }
    if (MiniAppVideoPlayer.a(this.a) == -1.0F) {
      MiniAppVideoPlayer.a(this.a, MiniAppVideoPlayer.e(this.a) / 255.0F);
    }
  }
  
  public void c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.w) {}
    while (MiniAppVideoPlayer.a(this.a) == null) {
      return;
    }
    paramFloat1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    if (paramFloat1 > 0.0F)
    {
      MiniAppVideoPlayer.a(this.a).setImageResource(2130840967);
      paramMotionEvent1 = this.a;
      paramFloat2 = MiniAppVideoPlayer.c(this.a);
      MiniAppVideoPlayer.a(paramMotionEvent1, (int)(paramFloat1 / MiniAppVideoPlayer.a(this.a).getWidth() * 100.0F + paramFloat2));
      if (MiniAppVideoPlayer.d(this.a) > 100) {
        MiniAppVideoPlayer.a(this.a, 100);
      }
    }
    for (;;)
    {
      MiniAppVideoPlayer.a(this.a).setProgress(MiniAppVideoPlayer.d(this.a));
      MiniAppVideoPlayer.a(this.a).a();
      int i = (int)MiniAppVideoPlayer.a(this.a).getDuration() * MiniAppVideoPlayer.d(this.a) / 100;
      MiniAppVideoPlayer.a(this.a).seekTo(i);
      return;
      MiniAppVideoPlayer.a(this.a).setImageResource(2130840968);
      paramMotionEvent1 = this.a;
      paramFloat2 = MiniAppVideoPlayer.c(this.a);
      MiniAppVideoPlayer.a(paramMotionEvent1, (int)(paramFloat1 / MiniAppVideoPlayer.a(this.a).getWidth() * 100.0F + paramFloat2));
      if (MiniAppVideoPlayer.d(this.a) < 0) {
        MiniAppVideoPlayer.a(this.a, 0);
      }
    }
  }
  
  public void d(MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsz
 * JD-Core Version:    0.7.0.1
 */