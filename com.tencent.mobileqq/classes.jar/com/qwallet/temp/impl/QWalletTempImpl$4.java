package com.qwallet.temp.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.lang.ref.WeakReference;

class QWalletTempImpl$4
  implements Runnable
{
  QWalletTempImpl$4(QWalletTempImpl paramQWalletTempImpl, WeakReference paramWeakReference1, WeakReference paramWeakReference2, BaseQQAppInterface paramBaseQQAppInterface, int paramInt) {}
  
  public void run()
  {
    Object localObject = (AppInterface)this.a.get();
    RedDotImageView localRedDotImageView = (RedDotImageView)this.b.get();
    if ((localObject != null) && (localRedDotImageView != null))
    {
      localObject = (IQWalletRedService)this.c.getRuntimeService(IQWalletRedService.class);
      IQWalletRedService.ShowInfo localShowInfo = ((IQWalletRedService)localObject).getShowInfo("2001");
      if ((localShowInfo.a) && (QWalletTempImpl.access$000(this.this$0, localShowInfo.d, this.d)))
      {
        ((IQWalletRedService)localObject).doShowReport("2001");
        localRedDotImageView.post(new QWalletTempImpl.4.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletTempImpl.4
 * JD-Core Version:    0.7.0.1
 */