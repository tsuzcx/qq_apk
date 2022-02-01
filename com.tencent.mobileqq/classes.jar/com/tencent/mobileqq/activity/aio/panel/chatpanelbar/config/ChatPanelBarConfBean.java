package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ChatPanelBarConfBean
{
  public int a = 0;
  
  public static ChatPanelBarConfBean a(String paramString)
  {
    ChatPanelBarConfBean localChatPanelBarConfBean = new ChatPanelBarConfBean();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPanelBarConfBean", 2, "[parse] config: " + paramString + ", showCmGame: " + localChatPanelBarConfBean.a);
      }
      return localChatPanelBarConfBean;
      try
      {
        localChatPanelBarConfBean.a = new JSONObject(paramString).optInt("cmgame");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ChatPanelBarConfBean", 1, "[parse] parse error: ", localThrowable);
      }
    }
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean
 * JD-Core Version:    0.7.0.1
 */