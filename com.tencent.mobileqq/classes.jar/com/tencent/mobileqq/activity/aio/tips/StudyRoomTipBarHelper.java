package com.tencent.mobileqq.activity.aio.tips;

import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.studyroom.StudyRoomManager.TroopStudyMemberChangeObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class StudyRoomTipBarHelper
  implements ILifeCycleHelper
{
  private long jdField_a_of_type_Long = 0L;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private StudyRoomTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar;
  private StudyRoomManager.TroopStudyMemberChangeObserver jdField_a_of_type_ComTencentMobileqqStudyroomStudyRoomManager$TroopStudyMemberChangeObserver = new StudyRoomTipBarHelper.2(this);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), new StudyRoomTipBarHelper.1(this));
  
  public StudyRoomTipBarHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar = new StudyRoomTipsBar(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  private StudyRoomTipsBar a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar = new StudyRoomTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bB();
  }
  
  public String a(boolean paramBoolean)
  {
    int i = ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719559, new Object[] { i + "" });
    if (paramBoolean) {
      str = HardCodeUtil.a(2131693732);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip=" + paramTipsBarTask);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar != paramTipsBarTask))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip not equal StudyRoomTip");
      }
      b();
      c();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a() != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "curTip is studyRoomTip");
    }
    return true;
  }
  
  public void b()
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {
      return;
    }
    if (a()) {
      c();
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      b();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "showStudyRoomTip");
    }
    if (!d()) {}
    TipsBarTask localTipsBarTask;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null");
      return false;
      localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
      if ((localTipsBarTask == null) || (localTipsBarTask == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StudyRoomTipBarHelper", 2, "currTip is other");
    return false;
    if (localTipsBarTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar.a();
    }
    for (;;)
    {
      c();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or studyRoomTips is null");
      }
    }
    TipsBarTask localTipsBarTask;
    do
    {
      return false;
      localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    } while ((localTipsBarTask == null) || (localTipsBarTask != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar));
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "currTip is studyRoomTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    c();
    return true;
  }
  
  public boolean d()
  {
    return ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) > 0;
  }
  
  public String getTag()
  {
    return "StudyRoomTipBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 3, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    StudyRoomManager localStudyRoomManager = (StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().getManager(QQManagerFactory.STUDY_ROOM_MANAGER);
    switch (paramInt)
    {
    default: 
    case 4: 
    case 3: 
      TroopManager localTroopManager;
      String str;
      do
      {
        return;
        localStudyRoomManager.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomStudyRoomManager$TroopStudyMemberChangeObserver);
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      } while (localTroopManager.b(str) == null);
      localStudyRoomManager.a(str);
      return;
    }
    localStudyRoomManager.b(this.jdField_a_of_type_ComTencentMobileqqStudyroomStudyRoomManager$TroopStudyMemberChangeObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper
 * JD-Core Version:    0.7.0.1
 */