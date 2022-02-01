package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;

class MiniPieHelper$1
  extends MessageObserver
{
  MiniPieHelper$1(MiniPieHelper paramMiniPieHelper) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (MiniPieHelper.a(this.a) != null) {
      MiniPieHelper.a(this.a).a(paramString);
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (MiniPieHelper.a(this.a) != null) {
      MiniPieHelper.a(this.a).a(paramString);
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (MiniPieHelper.a(this.a) != null) {
      MiniPieHelper.a(this.a).a(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieHelper.1
 * JD-Core Version:    0.7.0.1
 */