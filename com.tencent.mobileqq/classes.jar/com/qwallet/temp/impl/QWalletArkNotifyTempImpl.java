package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletTemp.ICallBack;
import com.tencent.mobileqq.ark.api.notify.GdtNotify;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;

public class QWalletArkNotifyTempImpl
  extends GdtNotify
  implements IAppNotifyCallback
{
  private final IQWalletTemp.ICallBack a;
  
  public QWalletArkNotifyTempImpl(IQWalletTemp.ICallBack paramICallBack)
  {
    this.a = paramICallBack;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    return (this.a.a(paramString1, paramString2, paramString3)) || (super.a(paramString1, paramString2, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletArkNotifyTempImpl
 * JD-Core Version:    0.7.0.1
 */