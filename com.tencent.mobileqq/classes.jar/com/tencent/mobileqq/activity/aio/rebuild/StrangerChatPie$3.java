package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;

class StrangerChatPie$3
  extends MessageObserver
{
  StrangerChatPie$3(StrangerChatPie paramStrangerChatPie) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    this.a.a(paramBoolean, paramString, paramLong);
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.a.a))
      {
        paramString = this.a;
        paramString.m = true;
        paramString.a(262144, null, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    StrangerChatPie.a(this.a, paramString1, paramInt1, paramInt2, paramLong2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie.3
 * JD-Core Version:    0.7.0.1
 */