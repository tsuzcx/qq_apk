package com.tencent.mobileqq.activity.aio.pluspanel.loader.troop;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.studymode.StudyModeManager;

public class AnonymousPlusPanelAppLoader
  extends TroopPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie.ah.a);
    a(paramBaseChatPie.ah.a, 1200000004);
    if (!StudyModeManager.h()) {
      a(paramBaseChatPie.ah.a, 1200000006);
    }
    a(paramBaseChatPie.ah.a, 1200000005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.AnonymousPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */