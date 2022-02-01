package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class FriendTipsHelper
  extends TipsHelper
  implements Handler.Callback
{
  GamePartyTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar;
  protected LightalkBlueTipsBar a;
  private Observer jdField_a_of_type_JavaUtilObserver = new FriendTipsHelper.2(this);
  
  public FriendTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = null;
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  @NonNull
  public String getTag()
  {
    return "FriendTipsHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 38)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar, new Object[0]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.getSubThreadHandler().post(new FriendTipsHelper.1(this));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
      }
      return true;
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendTipsHelper
 * JD-Core Version:    0.7.0.1
 */