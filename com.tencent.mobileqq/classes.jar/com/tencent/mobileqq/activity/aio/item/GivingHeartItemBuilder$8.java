package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$8
  extends AnimatorListenerAdapter
{
  GivingHeartItemBuilder$8(GivingHeartItemBuilder paramGivingHeartItemBuilder, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    GivingHeartItemBuilder.f = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.b == GivingHeartItemBuilder.b()) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.c.setVisibility(0);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isPlayed) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.b);
    }
    if (!PokeItemHelper.a("fullscreen", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId)) {
      if (!((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.b).a()) {
        break label222;
      }
    }
    label222:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.b, "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("GivingHeart.sprite", 2, "show sprite (normal) in bubble.");
        }
      }
      return;
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    GivingHeartItemBuilder.f = true;
    if (PokeItemHelper.a()) {
      HapticManager.a().a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId), 2);
    }
    PokeItemAnimationManager.a().a(7, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.setEnableXCoordinateMirrored(false);
    }
    for (;;)
    {
      PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, null, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId, "view_aio");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.setEnableXCoordinateMirrored(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */