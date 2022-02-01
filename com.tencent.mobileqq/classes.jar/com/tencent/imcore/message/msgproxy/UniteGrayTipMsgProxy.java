package com.tencent.imcore.message.msgproxy;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import mqq.app.AppRuntime;

public class UniteGrayTipMsgProxy
  extends MsgProxyWrapper
{
  @Metadata
  public UniteGrayTipMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  protected int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extraflag == 32772) {
      paramMessageRecord = a(paramMessageRecord, false);
    } else {
      paramMessageRecord = a(paramMessageRecord, -2006);
    }
    if (paramMessageRecord == null) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (UniteGrayTipMsgUtil.a(paramMessageRecord)) {
      return a(paramMessageRecord);
    }
    return super.a(paramMessageRecord, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.UniteGrayTipMsgProxy
 * JD-Core Version:    0.7.0.1
 */