package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import obz;

class KandianMergeManager$24
  implements Runnable
{
  KandianMergeManager$24(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.remove("kandian_push_msg_xml").remove("kandian_push_msg_time");
    bgmq.a(localEditor, true);
    obz.a("kandian_lock_screen_push_info", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.24
 * JD-Core Version:    0.7.0.1
 */