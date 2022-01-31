package com.tencent.mobileqq.activity.aio.rebuild;

import agps;
import agqi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import bdne;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class FriendChatPie$7$1
  implements Runnable
{
  public FriendChatPie$7$1(agqi paramagqi) {}
  
  public void run()
  {
    Message localMessage = agps.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    agps.b(this.a.a).sendMessage(localMessage);
    bdne.a(this.a.a.a.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.7.1
 * JD-Core Version:    0.7.0.1
 */