package com.tencent.mobileqq.activity.aio.helper;

import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class AVGameHelper
  implements ILifeCycleHelper
{
  public FragmentActivity a;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameHelper.1(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AVGameStatusTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public AVGameHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar.a();
    }
  }
  
  public void a(TipsManager paramTipsManager)
  {
    if (paramTipsManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar = new AVGameStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    paramTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar);
  }
  
  public void a(boolean paramBoolean)
  {
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localAvGameManager != null)
    {
      boolean bool = localAvGameManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (bool) {
        localAvGameManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, 1);
      }
      if ((QLog.isColorLevel()) && (paramBoolean)) {
        QLog.d("AVGameHelper", 2, "Enter AIO, troopUin :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "isAVGameOpen is: " + bool);
      }
    }
  }
  
  public String getTag()
  {
    return "AVGameHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 6, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
      return;
    case 6: 
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper
 * JD-Core Version:    0.7.0.1
 */