package com.tencent.imcore.message.aiolist;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.util.List;
import mqq.app.AppRuntime;

public class GrayTipsAioMsgHandler
  implements IAioMsgHandler
{
  public Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord)
  {
    paramAppRuntime = paramMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    paramBoolean = TextUtils.isEmpty(paramAppRuntime);
    paramList2 = Boolean.valueOf(true);
    if (!paramBoolean)
    {
      if (paramMessageRecord.isSend())
      {
        paramMessageRecord.saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
        return new Object[] { paramMessageRecord, paramList2 };
      }
      paramList3 = new bankcode_info.BankcodeCtrlInfo();
    }
    for (;;)
    {
      try
      {
        paramList3.mergeFrom(HexUtil.hexStr2Bytes(paramAppRuntime));
        if (!paramList3.msgtail_id.has()) {
          break label245;
        }
        paramInt = paramList3.msgtail_id.get();
        if (paramInt != 1) {
          return new Object[] { paramMessageRecord, paramList2 };
        }
        ((ChatMessage)paramMessageRecord).parse();
        paramAppRuntime = MessageRecordFactory.a(-1014);
        paramAppRuntime.msgtype = -1046;
        paramAppRuntime.senderuin = paramAppRuntime.selfuin;
        paramAppRuntime.frienduin = paramString;
        paramAppRuntime.istroop = paramMessageRecord.istroop;
        paramAppRuntime.msg = "";
        paramAppRuntime.isread = true;
        paramAppRuntime.shmsgseq = paramMessageRecord.shmsgseq;
        paramAppRuntime.time = paramMessageRecord.time;
        paramAppRuntime.saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(paramMessageRecord.uniseq));
        paramList1.add((ChatMessage)paramAppRuntime);
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
      return new Object[] { paramMessageRecord, Boolean.valueOf(false) };
      label245:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.GrayTipsAioMsgHandler
 * JD-Core Version:    0.7.0.1
 */