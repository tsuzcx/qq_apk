package com.tencent.av.ui.effect.toolbar.oldversion;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;

class BeautyToolbar$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BeautyToolbar$2(BeautyToolbar paramBeautyToolbar) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.mIs1stShow) && (this.a.mSeek != null) && (this.a.mSeek.getWidth() > 0))
    {
      BeautyToolbar localBeautyToolbar = this.a;
      localBeautyToolbar.mIs1stShow = false;
      localBeautyToolbar.updateTip(localBeautyToolbar.mSeek.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar.2
 * JD-Core Version:    0.7.0.1
 */