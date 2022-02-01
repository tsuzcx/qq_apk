package com.tencent.mobileqq.activity.aio.item;

import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;

class QQWalletMsgItemBuilder$1
  implements Runnable
{
  QQWalletMsgItemBuilder$1(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {}
    while (QWalletHelperImpl.isQWalletProcessExist(this.this$0.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(QQWalletMsgItemBuilder.jdField_a_of_type_JavaLangString, 2, "preload qwallet process by qqWalletMsg isTroop=" + this.a);
    }
    QWalletHelperImpl.preloadQWallet(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "qwallet_red");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */