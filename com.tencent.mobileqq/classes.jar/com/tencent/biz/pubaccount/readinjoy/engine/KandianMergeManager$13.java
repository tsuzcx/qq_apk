package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import bnrf;

class KandianMergeManager$13
  implements Runnable
{
  KandianMergeManager$13(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = bnrf.a(KandianMergeManager.a(this.this$0), true, false);
    if (localSharedPreferences != null) {
      KandianMergeManager.a(this.this$0, localSharedPreferences.getInt("kandian_follow_data_length", -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.13
 * JD-Core Version:    0.7.0.1
 */