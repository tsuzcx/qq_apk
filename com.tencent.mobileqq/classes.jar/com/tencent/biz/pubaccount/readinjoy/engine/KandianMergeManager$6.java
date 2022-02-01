package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class KandianMergeManager$6
  implements Runnable
{
  KandianMergeManager$6(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    BaseApplicationImpl.getApplication().unregisterReceiver(this.this$0.a);
    if (KandianMergeManager.a(this.this$0) != null) {
      KandianMergeManager.a(this.this$0).getApplication().getApplicationContext().unregisterReceiver(KandianMergeManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.6
 * JD-Core Version:    0.7.0.1
 */