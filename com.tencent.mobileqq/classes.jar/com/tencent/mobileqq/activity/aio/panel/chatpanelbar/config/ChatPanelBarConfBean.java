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
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localChatPanelBarConfBean.a = new JSONObject(paramString).optInt("cmgame");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ChatPanelBarConfBean", 1, "[parse] parse error: ", localThrowable);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[parse] config: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", showCmGame: ");
      localStringBuilder.append(localChatPanelBarConfBean.a);
      QLog.d("ChatPanelBarConfBean", 2, localStringBuilder.toString());
    }
    return localChatPanelBarConfBean;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean
 * JD-Core Version:    0.7.0.1
 */