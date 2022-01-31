package com.tencent.mobileqq.app.lbs;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;
import zyj;
import zyk;

public class LbsInfoMgr
  implements Manager
{
  public int a;
  public long a;
  private BizTroopHandler jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler;
  public BizTroopObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LbsInfoMgr.LocationInfo jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo;
  
  public LbsInfoMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 900000;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new zyk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)paramQQAppInterface.a(22));
    this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo = new LbsInfoMgr.LocationInfo();
  }
  
  public LbsInfoMgr.LocationInfo a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "getSeltLocation:lat=" + this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo.b + ", lon=" + this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo.jdField_a_of_type_Long);
    }
    b();
    return this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo;
  }
  
  public void a()
  {
    b();
  }
  
  public boolean a()
  {
    TroopInfoManager localTroopInfoManager;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager == null) {
        break label64;
      }
    }
    label64:
    for (boolean bool = localTroopInfoManager.a();; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "hasShareLbsTroop, hasShareLbsTroop=" + bool);
      }
      return bool;
      return false;
    }
  }
  
  public void b()
  {
    if ((!a()) && (!b())) {}
    while ((!c()) || (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.post(new zyj(this), 5, null, false);
  }
  
  public boolean b()
  {
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    boolean bool;
    if (localObject != null)
    {
      localObject = ((HotChatManager)localObject).b();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "hasHotChat, hasJoinHotChat=" + bool);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public boolean c()
  {
    long l1 = System.currentTimeMillis();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (!((PowerManager)localBaseApplication.getSystemService("power")).isScreenOn())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "isApplicationShowing: false");
      }
      return false;
    }
    if (((KeyguardManager)localBaseApplication.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "isApplicationShowing: false");
      }
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "isApplicationShowing: false");
      }
      return false;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "isApplicationShowing: true, timecost=" + (l2 - l1));
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.lbs.LbsInfoMgr
 * JD-Core Version:    0.7.0.1
 */