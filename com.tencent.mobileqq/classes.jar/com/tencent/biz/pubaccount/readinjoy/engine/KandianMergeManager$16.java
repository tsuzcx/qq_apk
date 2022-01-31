package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class KandianMergeManager$16
  implements Runnable
{
  KandianMergeManager$16(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putString("kandian_red_touch_pnt_article_id", KandianMergeManager.a(this.this$0)).putLong("kandian_push_msg_time", NetConnInfoCenter.getServerTime());
    bgmq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.16
 * JD-Core Version:    0.7.0.1
 */