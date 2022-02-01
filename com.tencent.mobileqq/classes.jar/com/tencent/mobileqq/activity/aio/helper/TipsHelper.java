package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class TipsHelper
  implements ILifeCycleHelper
{
  protected BaseSessionInfo a;
  protected final AIOContext a;
  protected TipsManager a;
  protected BaseActivity a;
  protected QQAppInterface a;
  private boolean a;
  
  public TipsHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    HongbaoKeywordGrayTips localHongbaoKeywordGrayTips = new HongbaoKeywordGrayTips(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    ComicTipsBar localComicTipsBar = new ComicTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localComicTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localHongbaoKeywordGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localVipSpecialCareGrayTips);
  }
  
  @NonNull
  public String getTag()
  {
    return "TipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 10)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a();
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else if (paramInt == 15) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TipsHelper
 * JD-Core Version:    0.7.0.1
 */