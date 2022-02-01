package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopClassInfoTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.qphone.base.util.QLog;

public class HWTroopClassInfoTipsHelper
  implements ILifeCycleHelper
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  public HomeworkTroopClassInfoTipsBar a;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new HWTroopClassInfoTipsHelper.2(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new HWTroopClassInfoTipsHelper.1(this);
  public TroopClassControllerManager a;
  
  public HWTroopClassInfoTipsHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      return;
    }
    a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    c();
  }
  
  private void c()
  {
    int j = 1;
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    }
    int i;
    TroopManager localTroopManager;
    TroopInfo localTroopInfo;
    if (localObject != null)
    {
      Boolean localBoolean = Boolean.valueOf(((Intent)localObject).getBooleanExtra("isFromContactTab", false));
      int k = ((Intent)localObject).getIntExtra("aio_msg_source", -1);
      i = j;
      if (k != 0)
      {
        i = j;
        if (k != 1)
        {
          if (!localBoolean.booleanValue()) {
            break label235;
          }
          i = j;
        }
      }
      if (i != 0)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        if (localObject != null)
        {
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          localTroopInfo = localTroopManager.b((String)localObject);
          if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (localTroopManager.o((String)localObject)) && (localTroopInfo.isNotSetTroopClassInfo()) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
          {
            i = localTroopManager.a((String)localObject);
            if (i < 3)
            {
              if (!localBoolean.booleanValue()) {
                break label240;
              }
              HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, HWTroopUtils.b);
            }
          }
        }
      }
    }
    for (;;)
    {
      localTroopManager.a((String)localObject, i + 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_edu", "", "Grp_data", "classinfo_Clk", 0, 0, localTroopInfo.troopuin, "", "", "");
      return;
      label235:
      i = 0;
      break;
      label240:
      HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, HWTroopUtils.a);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {}
    do
    {
      do
      {
        do
        {
          TroopManager localTroopManager;
          TroopInfo localTroopInfo;
          do
          {
            return;
            localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          } while (localTroopInfo == null);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager = ((TroopClassControllerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
          }
          if ((!localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!localTroopManager.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) || (!localTroopInfo.isNotSetTroopClassInfo()) || (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        } while (!(this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a instanceof HomeworkTroopController));
        ((HomeworkTroopController)this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopClassInfoTipsBar == null);
      if (QLog.isColorLevel()) {
        QLog.d("HWTroopClassInfoTipsHelper", 2, "mHomeworkTroopClassInfoChangedReceiver dismissTipsBar.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopClassInfoTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, false);
  }
  
  public String getTag()
  {
    return "HWTroopClassInfoTipsHelper";
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
    case 7: 
      a();
      return;
    case 4: 
      b();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HWTroopClassInfoTipsHelper
 * JD-Core Version:    0.7.0.1
 */