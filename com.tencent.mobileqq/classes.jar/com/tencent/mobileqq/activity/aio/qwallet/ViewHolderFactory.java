package com.tencent.mobileqq.activity.aio.qwallet;

import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.qphone.base.util.QLog;

public class ViewHolderFactory
{
  public static int a(int paramInt)
  {
    int i = 5;
    QLog.i("ViewHolderFactory", 2, "CFT-debug messageType = " + paramInt);
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
    if (paramInt == 18) {
      return 8;
    }
    if (paramInt == 19) {
      return 9;
    }
    if ((paramInt == 21) || (paramInt == 24) || (paramInt == 25) || (paramInt == 27)) {
      return 10;
    }
    if ((paramInt == 22) || (paramInt == 26)) {
      return 11;
    }
    if (paramInt == 23) {
      return 12;
    }
    if (paramInt == 28) {
      return 14;
    }
    return 0;
  }
  
  public static IFBaseViewHolder a(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      return new BaseViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 1: 
      return new LockRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 5: 
      return new LookRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 2: 
      return new VoiceRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 3: 
      return new ThemeRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 4: 
      return new VipRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 6: 
      return new SpecifyRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 7: 
      return new EpRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 8: 
      return new KSongRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 9: 
      return new EmojiRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 10: 
      return new SolitaireRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 11: 
      return new DrawRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 12: 
      return new GoldRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    }
    return new KuaKuaRedPkgViewHolder(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.ViewHolderFactory
 * JD-Core Version:    0.7.0.1
 */