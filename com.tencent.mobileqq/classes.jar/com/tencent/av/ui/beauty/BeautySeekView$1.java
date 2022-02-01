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
      BeautySeekView localBeautySeekView = this.a;
      localBeautySeekView.a = false;
      BeautySeekView.a(localBeautySeekView, BeautySeekView.a(localBeautySeekView).getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView.1
 * JD-Core Version:    0.7.0.1
 */