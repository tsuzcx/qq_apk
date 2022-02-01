package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

class XBubbleAnimation$4
  extends View
{
  XBubbleAnimation$4(XBubbleAnimation paramXBubbleAnimation, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a()) || (this.a.b.a())) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.4.1(this));
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.a.b.d)) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.4.2(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.4
 * JD-Core Version:    0.7.0.1
 */