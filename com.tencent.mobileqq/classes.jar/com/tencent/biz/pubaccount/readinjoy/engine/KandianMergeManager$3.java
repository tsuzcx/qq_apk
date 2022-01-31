package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;

class KandianMergeManager$3
  implements Runnable
{
  KandianMergeManager$3(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    BaseApplicationImpl.getApplication().registerReceiver(this.this$0.a, new IntentFilter("com.tencent.readinjoy.kandianreport"));
    KandianMergeManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.3
 * JD-Core Version:    0.7.0.1
 */