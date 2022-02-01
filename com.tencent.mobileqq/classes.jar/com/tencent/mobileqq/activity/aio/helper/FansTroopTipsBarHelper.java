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
  public FansTroopTipsBar a;
  TroopObserver b = new FansTroopTipsBarHelper.1(this);
  TroopPushObserver c = new FansTroopTipsBarHelper.2(this);
  private TroopChatPie d;
  private QQAppInterface e;
  private SessionInfo f;
  
  public FansTroopTipsBarHelper(TroopChatPie paramTroopChatPie)
  {
    this.d = paramTroopChatPie;
    this.e = paramTroopChatPie.d;
    this.f = paramTroopChatPie.ah;
  }
  
  private void d()
  {
    a();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBarHelper", 2, "onCreate()");
    }
    this.e.addObserver(this.c);
    this.e.addObserver(this.b);
  }
  
  private void f()
  {
    this.e.removeObserver(this.c);
    this.e.removeObserver(this.b);
  }
  
  public void a()
  {
    Object localObject1 = this.d.ca();
    Object localObject2;
    if ((this.f != null) && (b()))
    {
      if (this.a == null) {
        this.a = new FansTroopTipsBar(this.e, this.d.f, this.f, this.d);
      }
      if ((!this.a.a((TipsManager)localObject1)) && (this.a.a((TipsManager)localObject1, true)))
      {
        localObject1 = this.e.getPreferences();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FansTroop_tip_show_times");
        ((StringBuilder)localObject2).append(this.f.b);
        int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("FansTroop_tip_show_times");
        ((StringBuilder)localObject2).append(this.f.b);
        ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), i + 1).apply();
      }
    }
    else
    {
      localObject2 = this.a;
      if (localObject2 != null) {
        ((FansTroopTipsBar)localObject2).a((TipsManager)localObject1, false);
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = (TroopFansEntryConfig)QConfigManager.b().b(701);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (!((TroopFansEntryConfig)localObject).isGuideSwitchOn()) {
        return false;
      }
      if (((TroopListenTogetherPanel)this.d.q(33)).e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
        }
        return false;
      }
      if (((StudyRoomTipBarHelper)this.d.q(75)).e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FansTroopTipsBarHelper", 2, "showHomeworkTroopIdentityAIOTip. isStudyRoomTime");
        }
        return false;
      }
      bool1 = bool2;
      if (this.f != null)
      {
        bool1 = bool2;
        if (c())
        {
          localObject = this.e.getPreferences();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FansTroop_tip_show_times");
          localStringBuilder.append(this.f.b);
          bool1 = bool2;
          if (((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) < 3) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    boolean bool1 = StudyModeManager.h();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject2 = null;
    TroopManager localTroopManager = (TroopManager)this.e.getManager(QQManagerFactory.TROOP_MANAGER);
    SessionInfo localSessionInfo = this.f;
    Object localObject1 = localObject2;
    if (localSessionInfo != null)
    {
      localObject1 = localObject2;
      if (localTroopManager != null) {
        localObject1 = localTroopManager.f(localSessionInfo.b);
      }
    }
    if (localObject1 == null) {
      return false;
    }
    bool1 = bool2;
    if (((TroopInfo)localObject1).isFansTroop())
    {
      if (!((TroopInfo)localObject1).isOwnerOrAdmin(this.e.getCurrentAccountUin())) {
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
        f();
        return;
      }
      d();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FansTroopTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */