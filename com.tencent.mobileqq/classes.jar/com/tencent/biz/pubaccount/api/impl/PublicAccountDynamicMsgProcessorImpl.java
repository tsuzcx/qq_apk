package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.DynamicMsgProcessor;
import com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class PublicAccountDynamicMsgProcessorImpl
  implements IPublicAccountDynamicMsgProcessor
{
  private DynamicMsgProcessor processor;
  
  public IPublicAccountDynamicMsgProcessor init(AppInterface paramAppInterface, BusinessHandler paramBusinessHandler)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && ((paramBusinessHandler instanceof MessageHandler))) {
      this.processor = new DynamicMsgProcessor((QQAppInterface)paramAppInterface, (MessageHandler)paramBusinessHandler);
    }
    return this;
  }
  
  public void processHistoryMsg(long paramLong, List<msg_comm.Msg> paramList)
  {
    DynamicMsgProcessor localDynamicMsgProcessor = this.processor;
    if (localDynamicMsgProcessor != null) {
      localDynamicMsgProcessor.a(paramLong, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountDynamicMsgProcessorImpl
 * JD-Core Version:    0.7.0.1
 */