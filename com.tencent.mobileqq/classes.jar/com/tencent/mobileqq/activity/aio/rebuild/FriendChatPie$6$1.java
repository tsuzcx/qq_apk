package com.tencent.mobileqq.activity.aio.rebuild;

import aijm;
import aikc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import bhsi;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class FriendChatPie$6$1
  implements Runnable
{
  public FriendChatPie$6$1(aikc paramaikc) {}
  
  public void run()
  {
    Message localMessage = aijm.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    aijm.b(this.a.a).sendMessage(localMessage);
    bhsi.a(this.a.a.a.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.6.1
 * JD-Core Version:    0.7.0.1
 */