package com.tencent.mobileqq.activity.aio.qwallet;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class VoiceRedPkgViewHolder
  extends BaseViewHolder
{
  PasswdRedBagManager a;
  
  public VoiceRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847609;
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.e);
    return true;
  }
  
  public void h()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
    PasswdRedBagInfo localPasswdRedBagInfo1 = localPasswdRedBagInfo2;
    if (localPasswdRedBagInfo2 == null)
    {
      localPasswdRedBagInfo1 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 1);
    }
    if (!a(localPasswdRedBagInfo1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.VoiceRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */