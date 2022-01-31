package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bjxj;
import mqq.app.AppRuntime;
import qlc;

public class KandianOx210MsgInfo$8
  implements Runnable
{
  public KandianOx210MsgInfo$8(qlc paramqlc, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = bjxj.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_ox210_msg");
    localEditor.remove("kandian_push_ox210_c5_msg_count");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    bjxj.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.8
 * JD-Core Version:    0.7.0.1
 */