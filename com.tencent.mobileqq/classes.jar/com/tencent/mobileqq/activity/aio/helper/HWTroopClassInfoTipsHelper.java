package com.tencent.mobileqq.activity.aio.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopClassInfoTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.troop.groupclass.TroopAioClassController;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.SoLibraryChecker;
import com.tencent.qphone.base.util.QLog;

public class HWTroopClassInfoTipsHelper
  implements OnFinishListener, ILifeCycleHelper, PanelListener
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  public HomeworkTroopClassInfoTipsBar a;
  private HomeworkTroopSurveyBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar;
  public HomeworkTroopTipsBar a;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new HWTroopClassInfoTipsHelper.1(this);
  private TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new HWTroopClassInfoTipsHelper.2(this);
  private TroopClassControllerManager jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
  public boolean a;
  
  public HWTroopClassInfoTipsHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b().a().a(this);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      TroopChatPie localTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if ((localTroopChatPie != null) && (localTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          return;
        }
        a();
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    d();
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null) {
      localObject = ((BaseActivity)localObject).getIntent();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      int i = 0;
      Boolean localBoolean = Boolean.valueOf(((Intent)localObject).getBooleanExtra("isFromContactTab", false));
      int j = ((Intent)localObject).getIntExtra("aio_msg_source", -1);
      if ((j == 0) || (j == 1) || (localBoolean.booleanValue())) {
        i = 1;
      }
      if (i != 0)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        if (localObject != null)
        {
          TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          TroopInfo localTroopInfo = localTroopManager.b((String)localObject);
          if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (localTroopManager.n((String)localObject)) && (localTroopInfo.isNotSetTroopClassInfo()) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
          {
            i = localTroopManager.a((String)localObject);
            if (i < 3)
            {
              if (localBoolean.booleanValue()) {
                HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, HWTroopUtils.b);
              } else {
                HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, HWTroopUtils.a);
              }
              localTroopManager.a((String)localObject, i + 1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_edu", "", "Grp_data", "classinfo_Clk", 0, 0, localTroopInfo.troopuin, "", "", "");
            }
          }
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopClassControllerManager localTroopClassControllerManager = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
      if (localTroopClassControllerManager != null)
      {
        localTroopClassControllerManager.a(true);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("uin");
    int i = ((Intent)localObject).getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
      if ((localObject != null) && (((TroopClassControllerManager)localObject).a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a = null;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    j();
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("HWTroopClassInfoTipsHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void h()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      new SoLibraryChecker(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new HWTroopClassInfoTipsHelper.3(this);
      }
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    catch (Exception localException)
    {
      label109:
      break label109;
    }
    QLog.e("HWTroopClassInfoTipsHelper", 1, "register homework receiver exception.");
    HomeworkTroopController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager = ((TroopClassControllerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(localTroopInfo.dwGroupClassExt, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void j()
  {
    TroopClassControllerManager localTroopClassControllerManager = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
    if (localTroopClassControllerManager != null) {
      localTroopClassControllerManager.b();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public TroopClassControllerManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager = ((TroopClassControllerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((SessionInfo)localObject).jdField_a_of_type_JavaLangString)) {
          return;
        }
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager = ((TroopClassControllerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
        }
        if ((localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (((TroopManager)localObject).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localTroopInfo.isNotSetTroopClassInfo()))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
          if (localObject != null)
          {
            ((TroopClassControllerManager)localObject).a = ((TroopClassControllerManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (!(this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a instanceof HomeworkTroopController)) {
              return;
            }
            ((HomeworkTroopController)this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
            return;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopClassInfoTipsBar != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HWTroopClassInfoTipsHelper", 2, "mHomeworkTroopClassInfoChangedReceiver dismissTipsBar.");
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = ((TroopChatPie)localObject).b();
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopClassInfoTipsBar.a((TipsManager)localObject, false);
          }
        }
      }
    }
  }
  
  public void a(TipsManager paramTipsManager, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar = new HomeworkTroopTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar.a(paramTipsManager, paramBoolean);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(TipsManager paramTipsManager)
  {
    HomeworkTroopTipsBar localHomeworkTroopTipsBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopTipsBar;
    return (localHomeworkTroopTipsBar != null) && (localHomeworkTroopTipsBar.a(paramTipsManager));
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    if (((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b().a().a(24)).c()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar == null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar = new HomeworkTroopSurveyBar(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localQQAppInterface.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 0)
    {
      TroopClassControllerManager localTroopClassControllerManager = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
      if (localTroopClassControllerManager != null) {
        localTroopClassControllerManager.c();
      }
    }
  }
  
  public String getTag()
  {
    return "HWTroopClassInfoTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 8, 15, 6 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8)
        {
          if (paramInt != 10)
          {
            if (paramInt != 15) {
              return;
            }
            g();
            return;
          }
          e();
          return;
        }
        i();
        h();
        a();
        b();
        return;
      }
      f();
      return;
    }
    c();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    TroopClassControllerManager localTroopClassControllerManager = this.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager;
    if (localTroopClassControllerManager != null) {
      localTroopClassControllerManager.a();
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HWTroopClassInfoTipsHelper
 * JD-Core Version:    0.7.0.1
 */