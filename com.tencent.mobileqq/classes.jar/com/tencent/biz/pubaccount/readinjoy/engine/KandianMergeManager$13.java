package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import cooperation.readinjoy.ReadInJoyHelper;

class KandianMergeManager$13
  implements Runnable
{
  KandianMergeManager$13(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), true, false);
    if (localSharedPreferences != null) {
      KandianMergeManager.a(this.this$0, localSharedPreferences.getInt("kandian_follow_data_length", -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.13
 * JD-Core Version:    0.7.0.1
 */