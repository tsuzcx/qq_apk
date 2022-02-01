package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.readinjoy.ReadInJoyHelper;

class KandianMergeManager$23
  implements Runnable
{
  KandianMergeManager$23(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.a);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.23
 * JD-Core Version:    0.7.0.1
 */