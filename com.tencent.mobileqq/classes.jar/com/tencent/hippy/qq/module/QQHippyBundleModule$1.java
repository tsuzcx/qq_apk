package com.tencent.hippy.qq.module;

import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.mtt.hippy.modules.Promise;

class QQHippyBundleModule$1
  implements IUpdateListener
{
  QQHippyBundleModule$1(QQHippyBundleModule paramQQHippyBundleModule, Promise paramPromise) {}
  
  public void onUpdateFailed(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramInt2 == 101)
    {
      this.this$0.onJsUpdateCompleted(paramString2, 1, null, this.val$promise);
      return;
    }
    if (paramInt2 == 1)
    {
      this.this$0.onJsUpdateCompleted(paramString2, 0, null, this.val$promise);
      return;
    }
    this.this$0.onJsUpdateCompleted(paramString2, -1, paramString1, this.val$promise);
  }
  
  public void onUpdateSuccess(int paramInt, String paramString)
  {
    this.this$0.onJsUpdateCompleted(paramString, 1, null, this.val$promise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQHippyBundleModule.1
 * JD-Core Version:    0.7.0.1
 */