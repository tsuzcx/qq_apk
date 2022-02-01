package com.tencent.mobileqq.activity.aio.core;

import agab;
import agar;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import bhhr;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class FriendChatPie$6$1
  implements Runnable
{
  public FriendChatPie$6$1(agar paramagar) {}
  
  public void run()
  {
    Message localMessage = this.a.a.uiHandler.obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    this.a.a.uiHandler.sendMessage(localMessage);
    bhhr.a(this.a.a.app.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.6.1
 * JD-Core Version:    0.7.0.1
 */