package com.tencent.av.ui.beauty;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;

class BeautySeekView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BeautySeekView$1(BeautySeekView paramBeautySeekView) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.a) && (BeautySeekView.a(this.a) != null) && (BeautySeekView.a(this.a).getWidth() > 0))
    {
      this.a.a = false;
      BeautySeekView.a(this.a, BeautySeekView.a(this.a).getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView.1
 * JD-Core Version:    0.7.0.1
 */