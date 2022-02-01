package com.tencent.hippy.qq.module;

import android.os.Bundle;
import com.tencent.mtt.hippy.modules.Promise;
import mqq.observer.BusinessObserver;

class QQDataModule$1
  implements BusinessObserver
{
  QQDataModule$1(QQDataModule paramQQDataModule, String paramString, Promise paramPromise) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.onUniAgent(this.val$cmd, paramBoolean, paramBundle, this.val$promise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDataModule.1
 * JD-Core Version:    0.7.0.1
 */