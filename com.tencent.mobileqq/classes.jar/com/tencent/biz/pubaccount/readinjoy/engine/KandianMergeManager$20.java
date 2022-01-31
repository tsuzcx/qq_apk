package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;

class KandianMergeManager$20
  implements Runnable
{
  KandianMergeManager$20(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.a);
    bgmq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.20
 * JD-Core Version:    0.7.0.1
 */