package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.app.AppRuntime;

public class PokeAioMsgHandler
  implements IAioMsgHandler
{
  public Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord)
  {
    if (!paramBoolean)
    {
      if ((paramInt == 0) && ((paramMessageRecord instanceof MessageForPoke)))
      {
        paramString = (MessageForPoke)paramMessageRecord;
        if (!paramString.isSend()) {
          paramList2.add(paramString);
        }
        if ((paramString.interactType == 126) && (!paramString.isPlayed) && (!paramString.isSend())) {
          return new Object[] { paramMessageRecord, Boolean.valueOf(true) };
        }
        if ((paramString.isread) && (!paramString.isPlayed) && (!paramString.isSend())) {
          paramString.setPlayed((QQAppInterface)paramAppRuntime);
        }
      }
      if ((paramInt == 0) && ((paramMessageRecord instanceof MessageForPokeEmo))) {
        paramList3.add((MessageForPokeEmo)paramMessageRecord);
      }
    }
    return new Object[] { paramMessageRecord, Boolean.valueOf(false) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.PokeAioMsgHandler
 * JD-Core Version:    0.7.0.1
 */