package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;

class XBubbleAnimation$4
  extends View
{
  XBubbleAnimation$4(XBubbleAnimation paramXBubbleAnimation, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.a.p.g()) || (this.a.q.g())) {
      this.a.r.post(new XBubbleAnimation.4.1(this));
    }
    if ((this.a.p.C) && (this.a.q.C)) {
      this.a.r.post(new XBubbleAnimation.4.2(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.4
 * JD-Core Version:    0.7.0.1
 */