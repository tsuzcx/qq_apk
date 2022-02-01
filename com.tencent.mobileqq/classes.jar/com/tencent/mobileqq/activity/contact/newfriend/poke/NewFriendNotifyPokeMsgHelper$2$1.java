package com.tencent.mobileqq.activity.contact.newfriend.poke;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.Animation;
import android.widget.ImageView;

class NewFriendNotifyPokeMsgHelper$2$1
  implements Animator.AnimatorListener
{
  NewFriendNotifyPokeMsgHelper$2$1(NewFriendNotifyPokeMsgHelper.2 param2) {}
  
  private void a(ImageView paramImageView, Object paramObject)
  {
    if ((paramImageView != null) && (paramImageView.getAnimation() != null)) {
      paramImageView.getAnimation().cancel();
    }
    NewFriendNotifyPokeMsgHelper.a(paramObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a(this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_JavaLangObject);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    a(this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_JavaLangObject);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper.2.1
 * JD-Core Version:    0.7.0.1
 */