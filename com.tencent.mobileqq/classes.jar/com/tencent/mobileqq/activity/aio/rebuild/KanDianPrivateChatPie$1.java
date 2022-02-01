package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import java.util.List;
import msf.msgsvc.msg_svc.TransSvrInfo;

class KanDianPrivateChatPie$1
  extends MessageObserver
{
  KanDianPrivateChatPie$1(KanDianPrivateChatPie paramKanDianPrivateChatPie) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    super.onSendResult(paramBoolean, paramString, paramLong);
    if (paramString != null)
    {
      if (!paramString.equals(this.a.ah.b)) {
        return;
      }
      paramString = this.a;
      paramString.as = true;
      paramString.a(262144, null, paramLong);
    }
  }
  
  protected void onSendResultWithTransInfo(boolean paramBoolean, msg_svc.TransSvrInfo paramTransSvrInfo)
  {
    super.onSendResultWithTransInfo(paramBoolean, paramTransSvrInfo);
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    super.onUpdateMsgContent(paramBoolean, paramString);
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    super.onUpdateSendMsgError(paramString1, paramInt1, paramInt2, paramSendMessageHandler, paramLong1, paramLong2, paramString2);
    if (paramString1 != null)
    {
      if (!paramString1.equals(this.a.ah.b)) {
        return;
      }
      this.a.j(196608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.KanDianPrivateChatPie.1
 * JD-Core Version:    0.7.0.1
 */