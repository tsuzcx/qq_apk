package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class BubbleNewAIOAnim$3
  extends AnimatorListenerAdapter
{
  BubbleNewAIOAnim$3(BubbleNewAIOAnim paramBubbleNewAIOAnim) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a("animator set end!");
    if (this.a.c != null)
    {
      BubbleNewAIOAnim.a(this.a).removeView(this.a.c);
      this.a.c = null;
    }
    else
    {
      this.a.a("something wrong, bubble view is null!");
    }
    if (this.a.d != null)
    {
      BubbleNewAIOAnim.b(this.a).removeView(this.a.d);
      this.a.d = null;
    }
    else
    {
      this.a.a("something wrong, pendview is null!");
    }
    if (this.a.e != null)
    {
      this.a.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      paramAnimator.a = -1L;
      paramAnimator.b();
    }
    if (this.a.jdField_b_of_type_AndroidViewView != null) {
      this.a.jdField_b_of_type_AndroidViewView.invalidate();
    }
    paramAnimator = this.a;
    paramAnimator.jdField_a_of_type_JavaLangString = "";
    paramAnimator.jdField_b_of_type_JavaLangString = "";
    paramAnimator.a(true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a("animator set start!");
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.3
 * JD-Core Version:    0.7.0.1
 */