package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class ChatSettingForTroop$33
  extends AvatarObserver
{
  ChatSettingForTroop$33(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l != 0L) {
        this.a.a(l);
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.33
 * JD-Core Version:    0.7.0.1
 */