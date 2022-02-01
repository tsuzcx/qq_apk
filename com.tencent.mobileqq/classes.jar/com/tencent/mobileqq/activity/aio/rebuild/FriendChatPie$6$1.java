package com.tencent.mobileqq.activity.aio.rebuild;

import ahzy;
import aiao;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import bgsg;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class FriendChatPie$6$1
  implements Runnable
{
  public FriendChatPie$6$1(aiao paramaiao) {}
  
  public void run()
  {
    Message localMessage = ahzy.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    ahzy.b(this.a.a).sendMessage(localMessage);
    bgsg.a(this.a.a.a.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.6.1
 * JD-Core Version:    0.7.0.1
 */