package com.tencent.mobileqq.activity.aio.qwallet;

import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class KuaKuaRedPkgViewHolder
  extends BaseViewHolder
{
  PasswdRedBagManager a;
  
  public KuaKuaRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.i = 0;; this.i = paramQQWalletBaseMsgElem.effectsId)
    {
      this.j = 2130847606;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.n);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.setTextColor(Color.parseColor("#FFDDB2"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.setText(QWalletTools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void h()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
    PasswdRedBagInfo localPasswdRedBagInfo1 = localPasswdRedBagInfo2;
    if (localPasswdRedBagInfo2 == null)
    {
      localPasswdRedBagInfo1 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, false, false, false, 7);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 7);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.KuaKuaRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */