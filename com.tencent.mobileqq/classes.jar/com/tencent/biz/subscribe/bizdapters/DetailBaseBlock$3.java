package com.tencent.biz.subscribe.bizdapters;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

class DetailBaseBlock$3
  implements AnimationDrawableFactory.CreateDrawableResultListener
{
  DetailBaseBlock$3(DetailBaseBlock paramDetailBaseBlock) {}
  
  public void a(boolean paramBoolean, Drawable paramDrawable)
  {
    if ((paramBoolean) && ((paramDrawable instanceof AnimationDrawable)))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      if (DetailBaseBlock.a(this.a) != null) {
        DetailBaseBlock.f(this.a).runOnUiThread(new DetailBaseBlock.3.1(this, paramDrawable));
      }
      return;
    }
    QLog.d(DetailBaseBlock.a, 2, "showFollowTipView error, create animationDrawable error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.3
 * JD-Core Version:    0.7.0.1
 */