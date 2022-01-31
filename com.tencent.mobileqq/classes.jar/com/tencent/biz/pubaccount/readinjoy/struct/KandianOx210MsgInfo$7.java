package com.tencent.biz.pubaccount.readinjoy.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvh;

public class KandianOx210MsgInfo$7
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = bhvh.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_0x210_msg_for_follow_show_in_folder");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    bhvh.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.7
 * JD-Core Version:    0.7.0.1
 */