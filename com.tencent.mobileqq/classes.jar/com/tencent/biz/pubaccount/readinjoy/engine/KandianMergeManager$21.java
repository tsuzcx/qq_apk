package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bjxj;

class KandianMergeManager$21
  implements Runnable
{
  KandianMergeManager$21(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bjxj.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.a);
    bjxj.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.21
 * JD-Core Version:    0.7.0.1
 */