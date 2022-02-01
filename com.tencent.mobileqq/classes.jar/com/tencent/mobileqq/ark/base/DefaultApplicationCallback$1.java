package com.tencent.mobileqq.ark.base;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

final class DefaultApplicationCallback$1
  implements Runnable
{
  DefaultApplicationCallback$1(String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication == null) {
      return;
    }
    QQToast.a(localBaseApplication, this.a, 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.DefaultApplicationCallback.1
 * JD-Core Version:    0.7.0.1
 */