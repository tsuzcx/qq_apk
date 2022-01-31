package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import com.tencent.mobileqq.app.QQAppInterface;
import ppo;

public class KandianOx210MsgInfo$Biu0x210Msg$1
  implements Runnable
{
  public KandianOx210MsgInfo$Biu0x210Msg$1(ppo paramppo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bgmq.a(this.a, true, false).edit();
    localEditor.putLong("kandian_biu_0x210_seq", this.this$0.jdField_a_of_type_Long);
    localEditor.putLong("kandian_biu_0x210_uin", this.this$0.b);
    localEditor.putInt("kandian_biu_0x210_status", this.this$0.jdField_a_of_type_Int);
    bgmq.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1
 * JD-Core Version:    0.7.0.1
 */