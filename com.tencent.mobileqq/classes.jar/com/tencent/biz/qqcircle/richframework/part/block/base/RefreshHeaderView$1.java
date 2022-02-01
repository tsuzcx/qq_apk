package com.tencent.biz.qqcircle.richframework.part.block.base;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class RefreshHeaderView$1
  implements AnimationDrawableFactory.CreateResultListener
{
  RefreshHeaderView$1(RefreshHeaderView paramRefreshHeaderView) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      RefreshHeaderView.a(this.a, paramQQAnimationDrawable);
      this.a.getMainHandler().post(new RefreshHeaderView.1.1(this));
      return;
    }
    this.a.getMainHandler().post(new RefreshHeaderView.1.2(this));
    QLog.e("RefreshHeaderView", 1, "fetchAnimDrawable fail! use static logo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.1
 * JD-Core Version:    0.7.0.1
 */