package com.tencent.biz.troop.feeds;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OverScroller;

class TroopNewGuidePopWindow$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopNewGuidePopWindow$6(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, int paramInt) {}
  
  public void onGlobalLayout()
  {
    this.b.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.b.b.getLayoutParams();
    int i = this.b.I - this.b.H - this.a * 2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("maxHeight = ");
      localStringBuilder.append(i);
      QLog.d("TroopTipsPopWindow", 2, localStringBuilder.toString());
    }
    if (this.b.b.getMeasuredHeight() > i)
    {
      localLayoutParams.height = (i - 5);
      this.b.b.setLayoutParams(localLayoutParams);
    }
    if ((this.b.C != null) && (this.b.D) && (this.b.p.getOverScroller() != null)) {
      this.b.p.getOverScroller().startScroll(0, 0, 0, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.6
 * JD-Core Version:    0.7.0.1
 */