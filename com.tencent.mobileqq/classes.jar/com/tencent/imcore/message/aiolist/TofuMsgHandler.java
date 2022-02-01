package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.tofumsg.ITofuManagerNew;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class TofuMsgHandler
  implements IAioMsgHandler
{
  public Object[] a(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, List<ChatMessage> paramList3, MessageRecord paramMessageRecord)
  {
    if ((BeancurdManager.a(paramMessageRecord)) && (!((ITofuManagerNew)paramAppRuntime.getManager(QQManagerFactory.TOFU_NEW_MANAGER)).a(paramMessageRecord)))
    {
      QLog.d("TofuNew.TofuMsgHandler", 1, new Object[] { "handleMsgInAioList, out of date, msg = ", paramMessageRecord.toString() });
      return new Object[] { paramMessageRecord, Boolean.valueOf(true) };
    }
    return new Object[] { paramMessageRecord, Boolean.valueOf(false) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.aiolist.TofuMsgHandler
 * JD-Core Version:    0.7.0.1
 */