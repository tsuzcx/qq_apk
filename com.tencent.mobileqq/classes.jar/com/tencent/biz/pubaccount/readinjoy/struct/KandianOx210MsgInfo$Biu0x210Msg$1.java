package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.readinjoy.ReadInJoyHelper;

class KandianOx210MsgInfo$Biu0x210Msg$1
  implements Runnable
{
  KandianOx210MsgInfo$Biu0x210Msg$1(KandianOx210MsgInfo.Biu0x210Msg paramBiu0x210Msg, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(this.a, true, false).edit();
    localEditor.putLong("kandian_biu_0x210_seq", this.this$0.jdField_a_of_type_Long);
    localEditor.putLong("kandian_biu_0x210_uin", this.this$0.b);
    localEditor.putInt("kandian_biu_0x210_status", this.this$0.jdField_a_of_type_Int);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1
 * JD-Core Version:    0.7.0.1
 */