package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bmhv;
import com.tencent.mobileqq.app.QQAppInterface;
import rpl;

public class KandianOx210MsgInfo$9
  implements Runnable
{
  public KandianOx210MsgInfo$9(rpl paramrpl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bmhv.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_0x210_msg_sys");
    localEditor.remove("kandian_push_0x210_msg_sys_count");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    bmhv.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.9
 * JD-Core Version:    0.7.0.1
 */