package com.tencent.imcore.message.aiolist;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import java.util.List;
import mqq.app.AppRuntime;

public class StructingAioMsgHandler
  implements IAioMsgHandler
{
  public Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord)
  {
    if ((paramInt == 1008) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramList3 = paramMessageRecord.getExtInfoFromExtStr("pa_phone_msg_tip");
      if (!TextUtils.isEmpty(paramList3))
      {
        paramList2 = new TroopTipsEntity();
        paramList2.optContent = paramList3;
        ((TroopTipsMsgMgr)paramAppRuntime.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).c(paramList2);
        paramList3 = new MessageForGrayTips();
        long l = paramMessageRecord.time;
        paramAppRuntime = paramAppRuntime.getAccount();
        paramList3.init(paramAppRuntime, paramString, paramAppRuntime, paramList2.optContent, l, -1048, paramInt, l);
        paramList3.isread = true;
        TroopTipsMsgMgr.a(paramList3, paramList2.highlightItems);
        paramList1.add(paramList3);
      }
    }
    return new Object[] { paramMessageRecord, Boolean.valueOf(false) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.StructingAioMsgHandler
 * JD-Core Version:    0.7.0.1
 */