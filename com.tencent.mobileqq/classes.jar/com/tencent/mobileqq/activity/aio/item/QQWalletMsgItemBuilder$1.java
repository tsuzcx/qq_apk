package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;

class QQWalletMsgItemBuilder$1
  implements Runnable
{
  QQWalletMsgItemBuilder$1(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (!QWalletHelperDelegate.isQWalletProcessExist(this.this$0.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel())
      {
        String str = QQWalletMsgItemBuilder.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload qwallet process by qqWalletMsg isTroop=");
        localStringBuilder.append(this.a);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "qwallet_red");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */