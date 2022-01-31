package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;

class KandianMergeManager$23
  implements Runnable
{
  KandianMergeManager$23(KandianMergeManager paramKandianMergeManager, String paramString, long paramLong) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putString("kandian_push_msg_xml", this.jdField_a_of_type_JavaLangString).putLong("kandian_push_msg_time", this.jdField_a_of_type_Long);
    bgmq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.23
 * JD-Core Version:    0.7.0.1
 */