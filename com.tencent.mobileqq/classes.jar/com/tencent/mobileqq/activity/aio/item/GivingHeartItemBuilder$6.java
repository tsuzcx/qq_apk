package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class GivingHeartItemBuilder$6
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  GivingHeartItemBuilder$6(GivingHeartItemBuilder paramGivingHeartItemBuilder, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.b == GivingHeartItemBuilder.b()) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.a instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.c.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      AIOUtils.a -= 1;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */