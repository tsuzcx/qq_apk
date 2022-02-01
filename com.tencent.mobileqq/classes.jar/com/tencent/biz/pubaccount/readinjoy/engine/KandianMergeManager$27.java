package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils;
import cooperation.readinjoy.ReadInJoyHelper;

class KandianMergeManager$27
  implements Runnable
{
  KandianMergeManager$27(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.remove("kandian_push_msg_xml").remove("kandian_push_msg_time");
    ReadInJoyHelper.a(localEditor, true);
    RIJSPUtils.a("kandian_lock_screen_push_info", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.27
 * JD-Core Version:    0.7.0.1
 */