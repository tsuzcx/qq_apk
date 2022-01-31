package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bjxj;
import com.tencent.mobileqq.app.QQAppInterface;
import qlc;

public class KandianOx210MsgInfo$9
  implements Runnable
{
  public KandianOx210MsgInfo$9(qlc paramqlc, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bjxj.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_0x210_msg_sys");
    localEditor.remove("kandian_push_0x210_msg_sys_count");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    bjxj.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.9
 * JD-Core Version:    0.7.0.1
 */