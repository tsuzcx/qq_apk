package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.AIOTipsController.AIOTipsListener;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import cooperation.ilive.group.IliveGroupTipsBarHelper;

class TroopChatPie$35
  implements AIOTipsController.AIOTipsListener
{
  TroopChatPie$35(TroopChatPie paramTroopChatPie) {}
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    Object localObject = (TroopListenTogetherPanel)this.a.a(33);
    boolean bool1 = ((TroopListenTogetherPanel)localObject).c();
    TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)this.a.a(43);
    boolean bool2 = localTogetherControlHelper.c();
    StudyRoomTipBarHelper localStudyRoomTipBarHelper = (StudyRoomTipBarHelper)this.a.a(75);
    boolean bool3 = localStudyRoomTipBarHelper.d();
    IliveGroupTipsBarHelper localIliveGroupTipsBarHelper = (IliveGroupTipsBarHelper)this.a.a(81);
    boolean bool4 = localIliveGroupTipsBarHelper.d();
    if (bool1) {
      ((TroopListenTogetherPanel)localObject).b(1, paramTipsBarTask);
    }
    for (;;)
    {
      localObject = (AVGameHelper)this.a.a(71);
      if (localObject != null) {
        ((AVGameHelper)localObject).a(false);
      }
      ((QQGamePubAIOHelper)this.a.a(90)).a(paramTipsBarTask);
      return;
      if (bool2) {
        localTogetherControlHelper.a(1, paramTipsBarTask);
      } else if (bool3) {
        localStudyRoomTipBarHelper.a(paramTipsBarTask);
      } else if (bool4) {
        localIliveGroupTipsBarHelper.a(paramTipsBarTask);
      }
    }
  }
  
  public void a(TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    ((TroopListenTogetherPanel)this.a.a(33)).a(1, paramTipsBarTask2);
    ((TogetherControlHelper)this.a.a(43)).b(1, paramTipsBarTask2);
    ((QQGamePubAIOHelper)this.a.a(90)).a(paramTipsBarTask1, paramTipsBarTask2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.35
 * JD-Core Version:    0.7.0.1
 */