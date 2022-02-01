package com.tencent.biz.subscribe.bizdapters;

import android.widget.PopupWindow;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.OnFrameAnimationListener;
import com.tencent.qphone.base.util.QLog;

class DetailBaseBlock$3$1$1
  implements PopViewAnimationDrawableHelper.OnFrameAnimationListener
{
  DetailBaseBlock$3$1$1(DetailBaseBlock.3.1 param1) {}
  
  public void a()
  {
    QLog.d(DetailBaseBlock.a, 2, "showFollowTipView");
  }
  
  public void b()
  {
    QLog.d(DetailBaseBlock.a, 2, "dismiss popupWindow followTipView");
    if (this.a.b.a.f != null) {
      this.a.b.a.f.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.3.1.1
 * JD-Core Version:    0.7.0.1
 */