package com.tencent.mobileqq.activity.history.link;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class TroopLinkElement
  extends Entity
  implements Serializable
{
  private static final String TAG = "TroopLinkElement";
  private static final long serialVersionUID = 1L;
  public String iconUrl;
  public String msgSeq;
  public String nickname;
  public String timeSecond;
  public String title;
  public String uin;
  public String url;
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static TroopLinkElement mergeFromJson(String paramString, JSONObject paramJSONObject)
  {
    TroopLinkElement localTroopLinkElement = new TroopLinkElement();
    Object localObject = paramJSONObject.optString("raw_url", "");
    try
    {
      localTroopLinkElement.url = URLUtil.guessUrl((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopLinkElement", 2, new Object[] { "rawUrl:", localObject, " url:", localTroopLinkElement.url });
      }
      localTroopLinkElement.msgSeq = String.valueOf(paramJSONObject.optLong("seq", 0L));
      localTroopLinkElement.timeSecond = String.valueOf(paramJSONObject.optLong("time", 0L));
    }
    catch (Throwable localThrowable)
    {
      try
      {
        new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L);
        localTroopLinkElement.title = paramJSONObject.optString("title", "");
        localTroopLinkElement.uin = String.valueOf(paramJSONObject.optLong("uin", 0L));
        localObject = localTroopLinkElement.getQQAppInterface();
        if (localObject != null)
        {
          localTroopLinkElement.nickname = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString, localTroopLinkElement.uin);
          localTroopLinkElement.iconUrl = paramJSONObject.optString("thumbnail", "");
          if (TextUtils.isEmpty(localTroopLinkElement.title)) {
            localTroopLinkElement.title = localTroopLinkElement.url;
          }
          return localTroopLinkElement;
          localThrowable = localThrowable;
          QLog.e("TroopLinkElement", 1, localThrowable, new Object[0]);
          localTroopLinkElement.url = ((String)localObject);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TroopLinkElement", 1, "mergeFromJson: failed. ", localException);
          localTroopLinkElement.timeSecond = String.valueOf(System.currentTimeMillis() / 1000L);
          continue;
          localTroopLinkElement.nickname = localTroopLinkElement.uin;
        }
      }
    }
  }
  
  public static TroopLinkElement mock()
  {
    TroopLinkElement localTroopLinkElement = new TroopLinkElement();
    localTroopLinkElement.title = UUID.randomUUID().toString();
    localTroopLinkElement.nickname = "zhuoxu";
    localTroopLinkElement.timeSecond = "1565655656";
    localTroopLinkElement.uin = "2463624242";
    localTroopLinkElement.iconUrl = "https://t.cn/Aip1JkfR";
    localTroopLinkElement.msgSeq = "400";
    return localTroopLinkElement;
  }
  
  public String description()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.title).append('\n');
    localStringBuilder.append(this.uin).append('\n');
    localStringBuilder.append(this.nickname).append('\n');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return description();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.TroopLinkElement
 * JD-Core Version:    0.7.0.1
 */