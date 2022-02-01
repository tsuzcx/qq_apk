package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import java.util.List;

public class MarketFaceReloadFilter
  implements IReloadFilter
{
  public List<ChatMessage> a(AIOContext paramAIOContext, List<ChatMessage> paramList)
  {
    if ((paramAIOContext.e().e().f()) && (paramList.size() > 0))
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      localChatMessage.mPendantAnimatable = true;
      if (((localChatMessage instanceof MessageForMarketFace)) && (!((FullScreenInputHelper)paramAIOContext.a(24)).e()))
      {
        MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)localChatMessage;
        MarkFaceMessage localMarkFaceMessage2 = localMessageForMarketFace.mMarkFaceMessage;
        MarkFaceMessage localMarkFaceMessage1 = localMarkFaceMessage2;
        if (localMarkFaceMessage2 == null)
        {
          localChatMessage.parse();
          localMarkFaceMessage1 = localMessageForMarketFace.mMarkFaceMessage;
        }
        if (((localMarkFaceMessage1.mobileparam != null) && (localMarkFaceMessage1.mobileparam.length > 0)) || ((localMarkFaceMessage1.mediaType == 3) && (UinTypeUtil.b(paramAIOContext.O().a)))) {
          localMessageForMarketFace.needToPlay = true;
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.MarketFaceReloadFilter
 * JD-Core Version:    0.7.0.1
 */