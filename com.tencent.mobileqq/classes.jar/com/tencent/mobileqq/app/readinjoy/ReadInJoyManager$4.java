package com.tencent.mobileqq.app.readinjoy;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baip;
import bgmq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class ReadInJoyManager$4
  implements Runnable
{
  public void run()
  {
    if (ReadInJoyManager.a(this.this$0) == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ReadInJoyManager.a(this.this$0).edit();
    localEditor.putInt("readinjoy_push_channel_article_flag", 1);
    localEditor.putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
    localEditor.putLong("readinjoy_push_channel_article_content_channel_id", this.jdField_a_of_type_Long);
    localEditor.putString("readinjoy_push_channel_article_content_channel_name", this.jdField_a_of_type_JavaLangString);
    localEditor.putString("readinjoy_push_channel_article_content_wording", this.b);
    localEditor.putString("readinjoy_push_channel_article_content_article_id_list", baip.a(this.jdField_a_of_type_JavaUtilList, ","));
    bgmq.a(localEditor, true);
    ReadInJoyManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.4
 * JD-Core Version:    0.7.0.1
 */