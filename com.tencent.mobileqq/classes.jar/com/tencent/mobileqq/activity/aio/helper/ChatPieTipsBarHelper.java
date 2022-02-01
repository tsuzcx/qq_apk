package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import cooperation.ilive.group.IliveGroupTipsBarHelper;

public class ChatPieTipsBarHelper
{
  public static boolean a(BaseChatPie paramBaseChatPie)
  {
    boolean bool1 = false;
    if (paramBaseChatPie == null) {
      return false;
    }
    boolean bool3 = ((TroopListenTogetherPanel)paramBaseChatPie.q(33)).e();
    boolean bool4 = ((TogetherControlHelper)paramBaseChatPie.q(43)).e();
    boolean bool5 = ((StudyRoomTipBarHelper)paramBaseChatPie.q(75)).e();
    boolean bool2 = ((IliveGroupTipsBarHelper)paramBaseChatPie.q(81)).e();
    if ((bool3) || (bool4) || (bool5) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ChatPieTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */