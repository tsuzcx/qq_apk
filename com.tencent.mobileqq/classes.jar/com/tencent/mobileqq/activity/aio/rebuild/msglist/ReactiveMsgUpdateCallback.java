package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;

public class ReactiveMsgUpdateCallback
  implements IMsgUpdateCallback
{
  public void a(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if (paramAIOContext.a())
    {
      BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
      if (((paramChatMessage instanceof MessageForUniteGrayTip)) && (localBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramChatMessage.senderuin)) && (ConfessMsgUtil.a(paramChatMessage.istroop, paramChatMessage.getConfessTopicId(), localBaseSessionInfo.jdField_a_of_type_Int, localBaseSessionInfo.e)))
      {
        paramChatMessage = (MessageForUniteGrayTip)paramChatMessage;
        paramChatMessage.hasRead = 1;
        paramChatMessage.updateUniteGrayTipMsgData(paramAIOContext.a());
        if (paramChatMessage.tipParam.b == 2097153) {
          OldMutualMarkLogicHelper.a(paramAIOContext.a(), localBaseSessionInfo, paramChatMessage, paramAIOContext.a(), paramAIOContext.a(), paramChatMessage.subType);
        }
      }
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ReactiveMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */