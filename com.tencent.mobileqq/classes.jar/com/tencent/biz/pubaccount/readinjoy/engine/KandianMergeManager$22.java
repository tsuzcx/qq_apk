package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bkbq;

class KandianMergeManager$22
  implements Runnable
{
  KandianMergeManager$22(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bkbq.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.remove("subscribe_push_msg_time");
    localEditor.remove("subscribe_push_msg_uin");
    localEditor.remove("subscribe_push_msg_status");
    localEditor.remove("subscribe_push_msg_xml");
    bkbq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.22
 * JD-Core Version:    0.7.0.1
 */