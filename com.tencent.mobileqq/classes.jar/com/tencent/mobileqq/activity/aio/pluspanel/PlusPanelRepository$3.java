package com.tencent.mobileqq.activity.aio.pluspanel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import java.util.HashMap;

class PlusPanelRepository$3
  extends HashMap<Class<? extends BaseChatPie>, Integer>
{
  PlusPanelRepository$3(PlusPanelRepository paramPlusPanelRepository)
  {
    put(TroopChatPie.class, Integer.valueOf(1));
    put(DiscussChatPie.class, Integer.valueOf(6));
    put(NearbyChatPie.class, Integer.valueOf(3));
    paramPlusPanelRepository = Integer.valueOf(2);
    put(FriendChatPie.class, paramPlusPanelRepository);
    put(BusinessCmrTmpChatPie.class, paramPlusPanelRepository);
    put(RobotChatPie.class, paramPlusPanelRepository);
    put(StrangerChatPie.class, Integer.valueOf(7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelRepository.3
 * JD-Core Version:    0.7.0.1
 */