package com.tencent.mobileqq.activity.qwallet.impl;

import Wallet.PfaFriendRsp;

class ToPayManagerImpl$1$1
  implements Runnable
{
  ToPayManagerImpl$1$1(ToPayManagerImpl.1 param1, PfaFriendRsp paramPfaFriendRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_WalletPfaFriendRsp != null) {}
    for (boolean bool = true;; bool = false)
    {
      ToPayManagerImpl.onGetRecomendList(bool, this.jdField_a_of_type_WalletPfaFriendRsp, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletImplToPayManagerImpl$1.jdField_a_of_type_Boolean) {
        ToPayManagerImpl.refreshFromNet(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletImplToPayManagerImpl$1.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletImplToPayManagerImpl$1.b);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */