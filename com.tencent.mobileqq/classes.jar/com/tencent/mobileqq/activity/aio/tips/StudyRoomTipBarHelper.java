package com.tencent.mobileqq.activity.aio.tips;

import android.content.res.Resources;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar = new StudyRoomTipsBar(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private StudyRoomTipsBar a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar = new StudyRoomTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b().a(28)))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.aF();
  }
  
  public String a(boolean paramBoolean)
  {
    int i = ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localObject = ((Resources)localObject).getString(2131719278, new Object[] { localStringBuilder.toString() });
    if (paramBoolean) {
      localObject = HardCodeUtil.a(2131693685);
    }
    return localObject;
  }
  
  public void a()
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {
      return;
    }
    if (a()) {
      c();
    } else {
      b();
    }
    c();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOtherTipsHide tip=");
      ((StringBuilder)localObject).append(paramTipsBarTask);
      QLog.d("StudyRoomTipBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar;
    if ((localObject != null) && (localObject != paramTipsBarTask))
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or together is null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "curTip is studyRoomTip");
      }
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "showStudyRoomTip");
    }
    if (!d()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "currTip is other");
      }
      return false;
    }
    if (localTipsBarTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar.a();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar, new Object[0]);
    }
    c();
    return true;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null))
    {
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StudyRoomTipBarHelper", 2, "currTip is studyRoomTips");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
        c();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or studyRoomTips is null");
    }
    return false;
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
    return new int[] { 4, 3, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    StudyRoomManager localStudyRoomManager = (StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().getManager(QQManagerFactory.STUDY_ROOM_MANAGER);
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 10)
        {
          if (paramInt != 15) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsStudyRoomTipsBar = null;
          localStudyRoomManager.b(this.jdField_a_of_type_ComTencentMobileqqStudyroomStudyRoomManager$TroopStudyMemberChangeObserver);
          return;
        }
        b();
        return;
      }
      localStudyRoomManager.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomStudyRoomManager$TroopStudyMemberChangeObserver);
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    if (localTroopManager.b(str) != null) {
      localStudyRoomManager.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper
 * JD-Core Version:    0.7.0.1
 */