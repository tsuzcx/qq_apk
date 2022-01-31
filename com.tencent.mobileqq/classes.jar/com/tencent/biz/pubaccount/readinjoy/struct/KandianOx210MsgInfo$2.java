package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import com.tencent.mobileqq.app.QQAppInterface;
import ppn;

public class KandianOx210MsgInfo$2
  implements Runnable
{
  public KandianOx210MsgInfo$2(ppn paramppn, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(this.a, true, false).edit();
    localEditor.putString("kandian_0x210_c5_normal_item_body", this.this$0.a());
    localEditor.putInt("kandian_0x210_c5_normal_item_msg_count", this.this$0.a);
    localEditor.putLong("kandian_0x210_c5_normal_item_msg_time", this.this$0.d);
    bgmq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.2
 * JD-Core Version:    0.7.0.1
 */