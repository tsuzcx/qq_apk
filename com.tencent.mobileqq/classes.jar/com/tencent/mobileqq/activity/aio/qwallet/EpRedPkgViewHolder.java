package com.tencent.mobileqq.activity.aio.qwallet;

import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class EpRedPkgViewHolder
  extends BaseViewHolder
{
  public EpRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.a.b.setVisibility(0);
    this.a.b.setTextColor(-8947849);
    this.a.b.setText("QQ企业红包");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.EpRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */