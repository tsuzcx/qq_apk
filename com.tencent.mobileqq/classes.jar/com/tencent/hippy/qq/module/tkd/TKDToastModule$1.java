package com.tencent.hippy.qq.module.tkd;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.modules.Promise;

class TKDToastModule$1
  implements Runnable
{
  TKDToastModule$1(TKDToastModule paramTKDToastModule, String paramString, int paramInt, Promise paramPromise) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication(), this.val$message, this.val$duration).a();
    this.val$promise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDToastModule.1
 * JD-Core Version:    0.7.0.1
 */