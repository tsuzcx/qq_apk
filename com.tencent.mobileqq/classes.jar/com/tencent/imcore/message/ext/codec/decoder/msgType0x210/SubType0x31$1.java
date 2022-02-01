package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import mqq.observer.SubAccountObserver;

final class SubType0x31$1
  extends SubAccountObserver
{
  SubType0x31$1(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubAccountManager paramSubAccountManager) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a() == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a().getAccount())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(paramString2, paramString3, true);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a(), (byte)1, paramString2);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a(), paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x31.1
 * JD-Core Version:    0.7.0.1
 */