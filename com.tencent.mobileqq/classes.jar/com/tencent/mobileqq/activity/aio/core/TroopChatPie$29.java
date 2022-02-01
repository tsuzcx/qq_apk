package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopToDoHelper;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoController;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.group.IliveGroupTipsBarHelper;

class TroopChatPie$29
  implements AIOTipsController.AIOTipsListener
{
  TroopChatPie$29(TroopChatPie paramTroopChatPie) {}
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    Object localObject = (TroopListenTogetherPanel)this.a.q(33);
    boolean bool1 = ((TroopListenTogetherPanel)localObject).e();
    TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)this.a.q(43);
    boolean bool2 = localTogetherControlHelper.e();
    StudyRoomTipBarHelper localStudyRoomTipBarHelper = (StudyRoomTipBarHelper)this.a.q(75);
    boolean bool3 = localStudyRoomTipBarHelper.e();
    IliveGroupTipsBarHelper localIliveGroupTipsBarHelper = (IliveGroupTipsBarHelper)this.a.q(81);
    boolean bool4 = localIliveGroupTipsBarHelper.e();
    if (bool1) {
      ((TroopListenTogetherPanel)localObject).b(1, paramTipsBarTask);
    } else if (bool2) {
      localTogetherControlHelper.a(1, paramTipsBarTask);
    } else if (bool3) {
      localStudyRoomTipBarHelper.a(paramTipsBarTask);
    } else if (bool4) {
      localIliveGroupTipsBarHelper.a(paramTipsBarTask);
    }
    localObject = (AVGameHelper)this.a.q(71);
    if (localObject != null) {
      ((AVGameHelper)localObject).a(false);
    }
    ((QQGamePubAIOHelper)this.a.q(90)).a(paramTipsBarTask);
    paramTipsBarTask = ((TroopToDoHelper)this.a.q(139)).a();
    if (paramTipsBarTask == null)
    {
      QLog.e("TodoInfo", 1, "troopToDoHelper.getTroopToDoController() == null");
      return;
    }
    paramTipsBarTask.e();
  }
  
  public void a(TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    ((TroopListenTogetherPanel)this.a.q(33)).a(1, paramTipsBarTask2);
    ((TogetherControlHelper)this.a.q(43)).b(1, paramTipsBarTask2);
    ((QQGamePubAIOHelper)this.a.q(90)).a(paramTipsBarTask1, paramTipsBarTask2);
    paramTipsBarTask1 = ((TroopToDoHelper)this.a.q(139)).a();
    if (paramTipsBarTask1 == null)
    {
      QLog.e("TodoInfo", 1, "troopToDoHelper.getTroopToDoController() == null");
      return;
    }
    paramTipsBarTask1.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.29
 * JD-Core Version:    0.7.0.1
 */