package com.tencent.mobileqq.activity.qwallet.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QWalletTools$3$1
  implements Runnable
{
  QWalletTools$3$1(QWalletTools.3 param3) {}
  
  public void run()
  {
    try
    {
      RedDotImageView localRedDotImageView = (RedDotImageView)this.this$0.b.get();
      if (localRedDotImageView != null)
      {
        localRedDotImageView.setReddotXOffsetDp(15);
        localRedDotImageView.setReddotYOffsetDp(10);
        localRedDotImageView.setRedDotDrawable(localRedDotImageView.getResources().getDrawable(2130849802));
        localRedDotImageView.a(true);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QWalletTools", 2, localThrowable.getStackTrace());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.3.1
 * JD-Core Version:    0.7.0.1
 */