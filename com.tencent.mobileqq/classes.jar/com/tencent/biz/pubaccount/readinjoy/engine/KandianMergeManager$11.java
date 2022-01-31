package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import bgmq;

class KandianMergeManager$11
  implements Runnable
{
  KandianMergeManager$11(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = bgmq.a(KandianMergeManager.a(this.this$0), true, false);
    if (localSharedPreferences != null) {
      KandianMergeManager.a(this.this$0, localSharedPreferences.getInt("kandian_follow_data_length", -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.11
 * JD-Core Version:    0.7.0.1
 */