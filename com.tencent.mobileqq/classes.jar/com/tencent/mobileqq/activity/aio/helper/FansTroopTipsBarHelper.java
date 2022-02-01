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
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

public class FansTroopTipsBarHelper
  implements ILifeCycleHelper
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  public FansTroopTipsBar a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new FansTroopTipsBarHelper.2(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new FansTroopTipsBarHelper.1(this);
  
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar = new FansTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar.a((TipsManager)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar.a((TipsManager)localObject, true)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        i = ((SharedPreferences)localObject).getInt("FansTroop_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0);
        ((SharedPreferences)localObject).edit().putInt("FansTroop_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + 1).apply();
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFansTroopTipsBar.a((TipsManager)localObject, false);
  }
  
  public boolean a()
  {
    TroopFansEntryConfig localTroopFansEntryConfig = (TroopFansEntryConfig)QConfigManager.a().a(701);
    if ((localTroopFansEntryConfig == null) || (!localTroopFansEntryConfig.isGuideSwitchOn())) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!((TroopListenTogetherPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(33)).c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
        return false;
        if (!((StudyRoomTipBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(75)).d()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isStudyRoomTime");
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!b()));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("FansTroop_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0) < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b()
  {
    if (StudyModeManager.a()) {}
    for (;;)
    {
      return false;
      Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (localObject != null)) {}
      for (localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a); (localObject != null) && (((TroopInfo)localObject).isFansTroop()) && (((TroopInfo)localObject).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())); localObject = null)
      {
        if (((TroopInfo)localObject).getFansTroopStarId() == 0) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    }
  }
  
  public String getTag()
  {
    return "FansTroopTipsBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      c();
      return;
    case 7: 
      b();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */