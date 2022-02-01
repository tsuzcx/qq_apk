package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$12
  implements UnlimitedBladeWorks.UnlimitedEndListener
{
  GivingHeartItemBuilder$12(GivingHeartItemBuilder paramGivingHeartItemBuilder, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "HIDE_PLACEHOLDER Unlimited 1");
    }
    PokeItemAnimationManager.a().a(20);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageMatrix(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.b == GivingHeartItemBuilder.b()) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder.a instanceof ChatHistoryActivity)) && (!GivingHeartItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.c.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.c.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */