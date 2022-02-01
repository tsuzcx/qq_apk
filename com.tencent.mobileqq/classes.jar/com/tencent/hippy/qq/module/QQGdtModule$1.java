package com.tencent.hippy.qq.module;

import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mtt.hippy.modules.Promise;

class QQGdtModule$1
  implements JumpCallback
{
  QQGdtModule$1(QQGdtModule paramQQGdtModule, Promise paramPromise) {}
  
  public void onJump(int paramInt1, int paramInt2)
  {
    TeleScreen.a().a(paramInt1);
    QQGdtModule.access$000(this.this$0).remove(Integer.valueOf(paramInt1));
    this.val$promise.resolve("{\"openresult\":" + paramInt2 + " }");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQGdtModule.1
 * JD-Core Version:    0.7.0.1
 */