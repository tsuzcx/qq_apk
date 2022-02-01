package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bmhv;
import com.tencent.mobileqq.app.QQAppInterface;
import rpl;

public class KandianOx210MsgInfo$5
  implements Runnable
{
  public KandianOx210MsgInfo$5(rpl paramrpl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bmhv.a(this.a, true, false).edit();
    localEditor.putString("kandian_push_0x210_msg_for_follow_show_in_folder", this.this$0.a());
    localEditor.putLong("kandian_push_0x210_c5_msg_time", this.this$0.d);
    bmhv.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.5
 * JD-Core Version:    0.7.0.1
 */