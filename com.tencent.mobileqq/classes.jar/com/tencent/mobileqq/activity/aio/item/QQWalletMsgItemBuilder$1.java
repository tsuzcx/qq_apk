package com.tencent.mobileqq.activity.aio.item;

import adxv;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public class QQWalletMsgItemBuilder$1
  implements Runnable
{
  public QQWalletMsgItemBuilder$1(adxv paramadxv, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {}
    while (QWalletHelper.isQWalletProcessExist(this.this$0.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(adxv.jdField_a_of_type_JavaLangString, 2, "preload qwallet process by qqWalletMsg isTroop=" + this.a);
    }
    QWalletHelper.preloadQWallet(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "qwallet_red");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */