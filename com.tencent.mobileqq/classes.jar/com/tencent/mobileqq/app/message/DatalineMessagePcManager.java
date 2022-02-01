package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;

public class DatalineMessagePcManager
  extends DatalineMessageManager
{
  public DatalineMessagePcManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.c = AppConstants.DATALINE_PC_UIN;
    this.d = 6000;
  }
  
  protected DataLineMsgProxy a()
  {
    return this.a.getDataLineMsgProxy(0);
  }
  
  protected void b()
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessagePcManager
 * JD-Core Version:    0.7.0.1
 */