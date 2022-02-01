package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.FansTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.util.QLog;

public class FansTroopTipsBarHelper
  implements ILifeCycleHelper
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  public FansTroopTipsBar a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new FansTroopTipsBarHelper.1(this);
  TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new FansTroopTipsBarHelper.2(this);
  
  public FansTroopTipsBarHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void b()
  {
    a();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b();
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar = new FansTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar.a((TipsManager)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar.a((TipsManager)localObject1, true)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FansTroop_tip_show_times");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FansTroop_tip_show_times");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), i + 1).apply();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar;
      if (localObject2 != null) {
        ((FansTroopTipsBar)localObject2).a((TipsManager)localObject1, false);
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = (TroopFansEntryConfig)QConfigManager.a().a(701);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (!((TroopFansEntryConfig)localObject).isGuideSwitchOn()) {
        return false;
      }
      if (((TroopListenTogetherPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(33)).c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
        }
        return false;
      }
      if (((StudyRoomTipBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(75)).d())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isStudyRoomTime");
        }
        return false;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        bool1 = bool2;
        if (b())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FansTroop_tip_show_times");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          bool1 = bool2;
          if (((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) < 3) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    boolean bool1 = StudyModeManager.a();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject2 = null;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    Object localObject1 = localObject2;
    if (localSessionInfo != null)
    {
      localObject1 = localObject2;
      if (localTroopManager != null) {
        localObject1 = localTroopManager.b(localSessionInfo.a);
      }
    }
    if (localObject1 == null) {
      return false;
    }
    bool1 = bool2;
    if (((TroopInfo)localObject1).isFansTroop())
    {
      if (!((TroopInfo)localObject1).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        return false;
      }
      bool1 = bool2;
      if (((TroopInfo)localObject1).getFansTroopStarId() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getTag()
  {
    return "FansTroopTipsBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 15) {
          return;
        }
        d();
        return;
      }
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */