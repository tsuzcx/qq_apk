package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvy;

public class KandianOx210MsgInfo$6
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = bhvy.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_0x210_msg_for_follow");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    bhvy.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.6
 * JD-Core Version:    0.7.0.1
 */