package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public abstract class BaseChatPanelBarConfProcessor
  extends IQConfigProcessor<ChatPanelBarConfBean>
{
  public static ChatPanelBarConfBean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatPanelBarConfProcessor", 2, "[loadConfig] load C2C config.");
    }
    return (ChatPanelBarConfBean)QConfigManager.a().a(707);
  }
  
  public static ChatPanelBarConfBean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatPanelBarConfProcessor", 2, "[loadConfig] load Group config.");
    }
    return (ChatPanelBarConfBean)QConfigManager.a().a(708);
  }
  
  abstract int a();
  
  @NonNull
  public ChatPanelBarConfBean a(int paramInt)
  {
    return new ChatPanelBarConfBean();
  }
  
  @Nullable
  public ChatPanelBarConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      ChatPanelBarConfBean localChatPanelBarConfBean = ChatPanelBarConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("BaseChatPanelBarConfProcessor", 2, localStringBuilder.toString());
      }
      if (a() == 707)
      {
        ChatPanelDisplayManager.a.put(Integer.valueOf(2131362340), Boolean.valueOf(localChatPanelBarConfBean.a()));
        return localChatPanelBarConfBean;
      }
      if (a() == 708) {
        ChatPanelDisplayManager.b.put(Integer.valueOf(2131362340), Boolean.valueOf(localChatPanelBarConfBean.a()));
      }
      return localChatPanelBarConfBean;
    }
    return new ChatPanelBarConfBean();
  }
  
  public void a(ChatPanelBarConfBean paramChatPanelBarConfBean) {}
  
  public Class<ChatPanelBarConfBean> clazz()
  {
    return ChatPanelBarConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor
 * JD-Core Version:    0.7.0.1
 */