package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvy;

class KandianMergeManager$22
  implements Runnable
{
  KandianMergeManager$22(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bhvy.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.a);
    bhvy.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.22
 * JD-Core Version:    0.7.0.1
 */