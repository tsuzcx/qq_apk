package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class FraudHelper
  implements ILifeCycleHelper
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private FraudTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new FraudHelper.1(this);
  
  public FraudHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  @NonNull
  public String getTag()
  {
    return "FraudHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(0)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = new FraudTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FraudHelper
 * JD-Core Version:    0.7.0.1
 */