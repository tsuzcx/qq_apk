package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvy;
import com.tencent.mobileqq.app.QQAppInterface;
import qbg;

public class KandianOx210MsgInfo$9
  implements Runnable
{
  public KandianOx210MsgInfo$9(qbg paramqbg, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bhvy.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_0x210_msg_sys");
    localEditor.remove("kandian_push_0x210_msg_sys_count");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    bhvy.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.9
 * JD-Core Version:    0.7.0.1
 */