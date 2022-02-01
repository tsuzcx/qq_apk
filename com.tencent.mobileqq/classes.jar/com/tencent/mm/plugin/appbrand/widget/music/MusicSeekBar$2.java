package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.SeekBar;

class MusicSeekBar$2
  implements ValueAnimator.AnimatorUpdateListener
{
  MusicSeekBar$2(MusicSeekBar paramMusicSeekBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.d.a(f);
    MusicSeekBar.b(this.a).setThumb(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.2
 * JD-Core Version:    0.7.0.1
 */