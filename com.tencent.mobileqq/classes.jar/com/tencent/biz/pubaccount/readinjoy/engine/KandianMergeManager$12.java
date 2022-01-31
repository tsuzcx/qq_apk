package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import bhvh;

class KandianMergeManager$12
  implements Runnable
{
  KandianMergeManager$12(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = bhvh.a(KandianMergeManager.a(this.this$0), true, false);
    if (localSharedPreferences != null) {
      KandianMergeManager.a(this.this$0, localSharedPreferences.getInt("kandian_follow_data_length", -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.12
 * JD-Core Version:    0.7.0.1
 */