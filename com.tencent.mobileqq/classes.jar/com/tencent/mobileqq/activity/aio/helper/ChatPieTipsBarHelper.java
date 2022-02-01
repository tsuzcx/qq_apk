package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import cooperation.ilive.group.IliveGroupTipsBarHelper;

public class ChatPieTipsBarHelper
{
  public static boolean a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {
      return false;
    }
    boolean bool1 = ((TroopListenTogetherPanel)paramBaseChatPie.a(33)).c();
    boolean bool2 = ((TogetherControlHelper)paramBaseChatPie.a(43)).c();
    boolean bool3 = ((StudyRoomTipBarHelper)paramBaseChatPie.a(75)).d();
    boolean bool4 = ((IliveGroupTipsBarHelper)paramBaseChatPie.a(81)).d();
    if ((bool1) || (bool2) || (bool3) || (bool4)) {}
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ChatPieTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */