package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import ppn;

public class KandianOx210MsgInfo$3
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(this.a, true, false).edit();
    localEditor.putString("kandian_push_0x210_msg_sys", this.this$0.a());
    localEditor.putInt("kandian_push_0x210_msg_sys_count", this.this$0.a);
    localEditor.putLong("kandian_push_0x210_c5_msg_time", this.this$0.d);
    bgmq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.3
 * JD-Core Version:    0.7.0.1
 */