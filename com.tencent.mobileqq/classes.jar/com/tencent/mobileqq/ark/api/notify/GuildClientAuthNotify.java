package com.tencent.mobileqq.ark.api.notify;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GuildClientAuthNotify
  implements IAppNotifyCallback
{
  private static GuildClientAuthNotify a;
  
  public static List<String> a()
  {
    return Arrays.asList(new String[] { "com.tencent.channel.gameteam" });
  }
  
  private void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new GuildClientAuthNotify.1(this, paramString3, paramString4, paramString1, paramString2, paramQBaseActivity));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("arkId", paramString2);
      label24:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendClientAuthSuccessToArk appName: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" arkId: ");
      localStringBuilder.append(paramString2);
      QLog.i("GuildClientAuthNotify", 1, localStringBuilder.toString());
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread("gpro_bind_app", new GuildClientAuthNotify.2(paramString1, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      break label24;
    }
  }
  
  public static GuildClientAuthNotify b()
  {
    if (a == null) {
      a = new GuildClientAuthNotify();
    }
    return a;
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 == null) {
      return false;
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null)
    {
      QLog.w("GuildClientAuthNotify", 1, "top activity is null");
      return false;
    }
    if (paramString2.equals("gpro_bind_app")) {
      try
      {
        paramString2 = new JSONObject(paramString3);
        paramString3 = paramString2.getString("guild_id");
        String str = paramString2.getString("client_id");
        a(localQBaseActivity, paramString1, paramString2.getString("ark_id"), paramString3, str);
        return true;
      }
      catch (JSONException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("parse json failed");
        paramString2.append(paramString1);
        QLog.e("GuildClientAuthNotify", 1, paramString2.toString());
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify
 * JD-Core Version:    0.7.0.1
 */