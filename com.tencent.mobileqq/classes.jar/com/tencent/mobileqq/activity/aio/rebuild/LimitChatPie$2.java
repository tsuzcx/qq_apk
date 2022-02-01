package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import java.util.List;

class LimitChatPie$2
  extends MessageObserver
{
  LimitChatPie$2(LimitChatPie paramLimitChatPie) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    this.a.b(paramList);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    this.a.a(paramBoolean, paramString, paramLong);
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    LimitChatPie.a(this.a, paramBoolean, paramString);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    LimitChatPie.a(this.a, paramString1, paramInt1, paramInt2, paramSendMessageHandler, paramLong1, paramLong2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.2
 * JD-Core Version:    0.7.0.1
 */