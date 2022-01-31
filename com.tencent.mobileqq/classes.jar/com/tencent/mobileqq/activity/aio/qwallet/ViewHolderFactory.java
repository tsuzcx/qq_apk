package com.tencent.mobileqq.activity.aio.qwallet;

import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class ViewHolderFactory
{
  public static int a(int paramInt)
  {
    int i = 5;
    if (paramInt == 6) {
      i = 1;
    }
    while (paramInt == 14) {
      return i;
    }
    if ((paramInt == 13) || (paramInt == 15)) {
      return 2;
    }
    if ((paramInt == 4) || (paramInt == 5)) {
      return 3;
    }
    if (paramInt == 2001) {
      return 4;
    }
    if ((paramInt == 7) || (paramInt == 8) || (paramInt == 11) || (paramInt == 12)) {
      return 6;
    }
    if (paramInt == 2002) {
      return 7;
    }
    return 0;
  }
  
  public static IFBaseViewHolder a(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    switch (paramInt)
    {
    default: 
      return new BaseViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    case 1: 
      return new LockRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    case 5: 
      return new LookRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    case 2: 
      return new VoiceRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    case 3: 
      return new ThemeRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    case 4: 
      return new VipRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    case 6: 
      return new SpecifyRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    }
    return new EpRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.ViewHolderFactory
 * JD-Core Version:    0.7.0.1
 */