package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.service.message.MessageCache;

class DataLineHandler$9
  extends MessageObserver
{
  DataLineHandler$9(DataLineHandler paramDataLineHandler) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.b()))
    {
      this.a.b(true);
      DataLineHandler.b(this.a, MessageCache.a());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(1).b();
    }
  }
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.a()))
    {
      this.a.a(true);
      DataLineHandler.a(this.a, MessageCache.a());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(0).b();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.9
 * JD-Core Version:    0.7.0.1
 */