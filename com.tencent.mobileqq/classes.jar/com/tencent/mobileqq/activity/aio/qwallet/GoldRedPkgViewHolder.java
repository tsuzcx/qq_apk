package com.tencent.mobileqq.activity.aio.qwallet;

import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class GoldRedPkgViewHolder
  extends BaseViewHolder
{
  PasswdRedBagManager a;
  
  public GoldRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
    {
      this.i = 0;
      return;
    }
    this.i = paramQQWalletBaseMsgElem.effectsId;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.m);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.setText(QWalletTools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.GoldRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */