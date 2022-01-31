package com.tencent.mobileqq.activity.aio.rebuild;

import aedo;
import aeeg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import baig;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class FriendChatPie$8$1
  implements Runnable
{
  public FriendChatPie$8$1(aeeg paramaeeg) {}
  
  public void run()
  {
    Message localMessage = aedo.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    aedo.b(this.a.a).sendMessage(localMessage);
    baig.a(this.a.a.a.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.8.1
 * JD-Core Version:    0.7.0.1
 */