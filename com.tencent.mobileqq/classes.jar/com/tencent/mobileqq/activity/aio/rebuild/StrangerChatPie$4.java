package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;

class StrangerChatPie$4
  extends MessageObserver
{
  StrangerChatPie$4(StrangerChatPie paramStrangerChatPie) {}
  
  public void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.p();
      }
    }
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.p();
      }
    }
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    this.a.a(paramBoolean, paramString, paramLong);
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.a.a)) {
      return;
    }
    this.a.q = true;
    this.a.a(262144, null, paramLong);
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.g(65536);
  }
  
  public void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    StrangerChatPie.a(this.a, paramString1, paramInt1, paramInt2, paramLong2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie.4
 * JD-Core Version:    0.7.0.1
 */