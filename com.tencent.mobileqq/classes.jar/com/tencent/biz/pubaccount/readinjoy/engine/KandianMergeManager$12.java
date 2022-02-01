package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.readinjoy.ReadInJoyHelper;

class KandianMergeManager$12
  implements Runnable
{
  KandianMergeManager$12(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("kandian_follow_data_length", this.a);
        ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.12
 * JD-Core Version:    0.7.0.1
 */