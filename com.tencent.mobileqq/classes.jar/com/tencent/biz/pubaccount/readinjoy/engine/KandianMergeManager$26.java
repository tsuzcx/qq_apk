package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bnrf;

class KandianMergeManager$26
  implements Runnable
{
  KandianMergeManager$26(KandianMergeManager paramKandianMergeManager, String paramString, long paramLong) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bnrf.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putString("kandian_push_msg_xml", this.jdField_a_of_type_JavaLangString).putLong("kandian_push_msg_time", this.jdField_a_of_type_Long);
    bnrf.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.26
 * JD-Core Version:    0.7.0.1
 */