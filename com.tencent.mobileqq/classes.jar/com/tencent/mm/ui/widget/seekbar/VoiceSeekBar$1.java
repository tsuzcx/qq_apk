package com.tencent.mm.ui.widget.seekbar;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class VoiceSeekBar$1
  implements ViewTreeObserver.OnPreDrawListener
{
  VoiceSeekBar$1(VoiceSeekBar paramVoiceSeekBar) {}
  
  public boolean onPreDraw()
  {
    this.a.c.getViewTreeObserver().removeOnPreDrawListener(this);
    Object localObject = this.a;
    ((VoiceSeekBar)localObject).f = ((VoiceSeekBar)localObject).c.getHeight();
    localObject = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)((1.0F - this.a.e) * this.a.f));
    this.a.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.requestLayout();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.seekbar.VoiceSeekBar.1
 * JD-Core Version:    0.7.0.1
 */