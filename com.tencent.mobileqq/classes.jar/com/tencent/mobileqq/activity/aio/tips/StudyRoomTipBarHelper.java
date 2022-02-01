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
  private TroopChatPie a;
  private StudyRoomTipsBar b;
  private long c = 0L;
  private final MqqHandler d = new MqqWeakReferenceHandler(Looper.getMainLooper(), new StudyRoomTipBarHelper.1(this));
  private StudyRoomManager.TroopStudyMemberChangeObserver e = new StudyRoomTipBarHelper.2(this);
  
  public StudyRoomTipBarHelper(TroopChatPie paramTroopChatPie)
  {
    this.a = paramTroopChatPie;
    this.b = new StudyRoomTipsBar(paramTroopChatPie.d, paramTroopChatPie.f);
  }
  
  private void f()
  {
    if ((this.b == null) && (this.a.bx().a(28)))
    {
      g();
      this.b.a(this.a.ah.b);
    }
  }
  
  private StudyRoomTipsBar g()
  {
    if (this.b == null)
    {
      this.b = new StudyRoomTipsBar(this.a.d, this.a.f);
      if (this.a.J() != null) {
        this.a.J().b(this.b);
      }
    }
    return this.b;
  }
  
  private void h()
  {
    this.a.cc();
  }
  
  public String a(boolean paramBoolean)
  {
    int i = ((StudyRoomManager)this.a.d.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).b(this.a.ah.b);
    Object localObject = this.a.f.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localObject = ((Resources)localObject).getString(2131916830, new Object[] { localStringBuilder.toString() });
    if (paramBoolean) {
      localObject = HardCodeUtil.a(2131891260);
    }
    return localObject;
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
    Object localObject = this.b;
    if ((localObject != null) && (localObject != paramTipsBarTask))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "onOtherTipsHide tip not equal StudyRoomTip");
      }
      b();
      h();
    }
  }
  
  public boolean a()
  {
    if (this.a.J() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or together is null");
      }
      return false;
    }
    if (this.a.J().a() == this.b)
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
    if (!e()) {
      return false;
    }
    if (this.a.J() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.a.J().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomTipBarHelper", 2, "currTip is other");
      }
      return false;
    }
    if (localTipsBarTask != null) {
      this.b.d();
    } else {
      this.a.J().a(this.b, new Object[0]);
    }
    h();
    return true;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "dismissTogetherTip");
    }
    if ((this.b != null) && (this.a.J() != null))
    {
      TipsBarTask localTipsBarTask = this.a.J().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StudyRoomTipBarHelper", 2, "currTip is studyRoomTips");
        }
        this.a.J().c();
        h();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomTipBarHelper", 2, "tipManager is null or studyRoomTips is null");
    }
    return false;
  }
  
  public void d()
  {
    if (Math.abs(System.currentTimeMillis() - this.c) < 500L) {
      return;
    }
    if (a()) {
      c();
    } else {
      b();
    }
    h();
    this.c = System.currentTimeMillis();
  }
  
  public boolean e()
  {
    return ((StudyRoomManager)this.a.d.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).b(this.a.ah.b) > 0;
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
    StudyRoomManager localStudyRoomManager = (StudyRoomManager)this.a.i().getManager(QQManagerFactory.STUDY_ROOM_MANAGER);
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 10)
        {
          if (paramInt != 15) {
            return;
          }
          this.b = null;
          localStudyRoomManager.b(this.e);
          return;
        }
        f();
        return;
      }
      localStudyRoomManager.a(this.e);
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = this.a.ah.b;
    if (localTroopManager.f(str) != null) {
      localStudyRoomManager.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper
 * JD-Core Version:    0.7.0.1
 */