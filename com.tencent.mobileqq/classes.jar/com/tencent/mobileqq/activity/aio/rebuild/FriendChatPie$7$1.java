package com.tencent.mobileqq.activity.aio.rebuild;

import aeom;
import aepc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import bbkb;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class FriendChatPie$7$1
  implements Runnable
{
  public FriendChatPie$7$1(aepc paramaepc) {}
  
  public void run()
  {
    Message localMessage = aeom.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    aeom.b(this.a.a).sendMessage(localMessage);
    bbkb.a(this.a.a.a.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.7.1
 * JD-Core Version:    0.7.0.1
 */