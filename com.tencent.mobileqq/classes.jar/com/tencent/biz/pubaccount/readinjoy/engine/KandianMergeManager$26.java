package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvy;
import onh;

class KandianMergeManager$26
  implements Runnable
{
  KandianMergeManager$26(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bhvy.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.remove("kandian_push_msg_xml").remove("kandian_push_msg_time");
    bhvy.a(localEditor, true);
    onh.a("kandian_lock_screen_push_info", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.26
 * JD-Core Version:    0.7.0.1
 */