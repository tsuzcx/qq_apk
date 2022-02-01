package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.readinjoy.ReadInJoyHelper;

class KandianMergeManager$22
  implements Runnable
{
  KandianMergeManager$22(KandianMergeManager paramKandianMergeManager, long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putLong("subscribe_push_msg_time", this.jdField_a_of_type_Long);
    localEditor.putString("subscribe_push_msg_uin", this.jdField_a_of_type_JavaLangString);
    localEditor.putInt("subscribe_push_msg_status", this.jdField_a_of_type_Int);
    localEditor.putString("subscribe_push_msg_xml", this.jdField_b_of_type_JavaLangString);
    localEditor.putInt("subscribe_push_msg_msgtype", this.jdField_b_of_type_Int);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.22
 * JD-Core Version:    0.7.0.1
 */