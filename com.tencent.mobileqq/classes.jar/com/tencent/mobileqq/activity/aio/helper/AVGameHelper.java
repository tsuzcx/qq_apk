package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AVGameHelper
  implements ILifeCycleHelper
{
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameHelper.1(this);
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private AVGameStatusTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public AVGameHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
  }
  
  public void a()
  {
    AVGameStatusTipsBar localAVGameStatusTipsBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar;
    if (localAVGameStatusTipsBar != null) {
      localAVGameStatusTipsBar.a();
    }
  }
  
  public void a(TipsManager paramTipsManager)
  {
    if (paramTipsManager != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(2002)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar = new AVGameStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, paramTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        paramTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAvGameManager.class, "");
    if (localObject != null)
    {
      boolean bool = ((IAvGameManager)localObject).isAVGameOpen(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a);
      if (bool) {
        ((IAvGameManager)localObject).requestGameRoomListForGroup(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, 0, 1);
      }
      if ((QLog.isColorLevel()) && (paramBoolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Enter AIO, troopUin :");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a);
        ((StringBuilder)localObject).append("isAVGameOpen is: ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AVGameHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public String getTag()
  {
    return "AVGameHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 10)
        {
          if (paramInt != 15) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsAVGameStatusTipsBar = null;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
          return;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
        return;
      }
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper
 * JD-Core Version:    0.7.0.1
 */