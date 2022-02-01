package com.tencent.mobileqq.activity.aio.item;

import ahfz;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public class QQWalletMsgItemBuilder$1
  implements Runnable
{
  public QQWalletMsgItemBuilder$1(ahfz paramahfz, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {}
    while (QWalletHelper.isQWalletProcessExist(this.this$0.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ahfz.jdField_a_of_type_JavaLangString, 2, "preload qwallet process by qqWalletMsg isTroop=" + this.a);
    }
    QWalletHelper.preloadQWallet(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "qwallet_red");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */