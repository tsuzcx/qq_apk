package com.qwallet.temp.impl;

import android.content.res.Resources;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QWalletTempImpl$4$1
  implements Runnable
{
  QWalletTempImpl$4$1(QWalletTempImpl.4 param4) {}
  
  public void run()
  {
    try
    {
      RedDotImageView localRedDotImageView = (RedDotImageView)this.a.b.get();
      if (localRedDotImageView != null)
      {
        localRedDotImageView.setReddotXOffsetDp(15);
        localRedDotImageView.setReddotYOffsetDp(10);
        localRedDotImageView.setRedDotDrawable(localRedDotImageView.getResources().getDrawable(2130852589));
        localRedDotImageView.a(true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QWalletTempImpl", 2, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletTempImpl.4.1
 * JD-Core Version:    0.7.0.1
 */