package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.IMsgTipsListener;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import java.util.Observable;
import java.util.Observer;

public class TroopTipsHelper
  extends TipsHelper
  implements IMsgTipsListener, OnActivityResultCallback
{
  GamePartyTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar;
  TroopAssistTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
  private final Observer jdField_a_of_type_JavaUtilObserver = new TroopTipsHelper.1(this);
  
  public TroopTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(3))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar = new TroopAssistTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(14))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
    }
  }
  
  public void a(AIOContext paramAIOContext)
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
  }
  
  public void a(AIOContext paramAIOContext, Message paramMessage) {}
  
  public boolean a()
  {
    TroopAssistTipsBar localTroopAssistTipsBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
    return (localTroopAssistTipsBar != null) && (localTroopAssistTipsBar.a());
  }
  
  public void b()
  {
    TroopAssistTipsBar localTroopAssistTipsBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
    if (localTroopAssistTipsBar != null) {
      localTroopAssistTipsBar.a();
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "TroopTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 4, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
      if ((paramIntent != null) && (paramIntent.a()) && (TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
    }
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopTipsHelper
 * JD-Core Version:    0.7.0.1
 */