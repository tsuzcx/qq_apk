package com.tencent.luggage.wxa.op;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.qz.o;

class f$6
  implements AudioManager.OnAudioFocusChangeListener
{
  f$6(f paramf) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    String str = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioFocusChange, focusChange: ");
    localStringBuilder.append(paramInt);
    o.e(str, localStringBuilder.toString());
    if (f.w(this.a))
    {
      o.d(f.a(this.a), "onAudioFocusChange, runtime paused");
      return;
    }
    if (f.d(this.a) == null)
    {
      o.e(f.a(this.a), "onAudioFocusChange, null == mPipVideoSession");
      return;
    }
    if ((paramInt != -3) && (paramInt != -2))
    {
      if (paramInt != -1)
      {
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
          return;
        }
        f.d(this.a).g.f();
        return;
      }
      o.e(f.a(this.a), "onAudioFocusChange, abandonAudioFocus");
      f.z(this.a).abandonAudioFocus(f.B(this.a));
      f.i(this.a, false);
    }
    f.d(this.a).g.g();
    f.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.6
 * JD-Core Version:    0.7.0.1
 */