package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar;
import com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import java.util.Observable;
import java.util.Observer;

public class DiscTipsHelper
  extends TipsHelper
{
  GamePartyTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar;
  private Observer jdField_a_of_type_JavaUtilObserver = new DiscTipsHelper.1(this);
  
  public DiscTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    super.a();
    DiscActiveTipsBar localDiscActiveTipsBar = new DiscActiveTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    DiscFreqPttGrayTips localDiscFreqPttGrayTips = new DiscFreqPttGrayTips(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localDiscActiveTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localDiscFreqPttGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  @NonNull
  public String getTag()
  {
    return "DiscTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      return;
    }
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DiscTipsHelper
 * JD-Core Version:    0.7.0.1
 */