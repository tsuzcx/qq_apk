package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DatalineMessageIpadManager
  extends DatalineMessageManager
{
  public DatalineMessageIpadManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.c = AppConstants.DATALINE_IPAD_UIN;
    this.d = 6003;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord != null)
    {
      paramDataLineMsgRecord.selfuin = this.c;
      paramDataLineMsgRecord.frienduin = paramDataLineMsgRecord.selfuin;
      paramDataLineMsgRecord.senderuin = paramDataLineMsgRecord.selfuin;
      paramDataLineMsgRecord.istroop = this.d;
      paramDataLineMsgRecord.dataline_type = 1;
    }
    return super.a(paramDataLineMsgRecord, paramBoolean);
  }
  
  protected DataLineMsgProxy a()
  {
    return this.a.getDataLineMsgProxy(1);
  }
  
  protected void b()
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageIpadManager
 * JD-Core Version:    0.7.0.1
 */