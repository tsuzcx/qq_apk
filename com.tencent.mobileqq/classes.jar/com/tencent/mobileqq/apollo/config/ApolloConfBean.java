package com.tencent.mobileqq.apollo.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloConfBean
{
  private Map<String, String> a = new HashMap();
  
  public static ApolloConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      try
      {
        ApolloConfBean localApolloConfBean = new ApolloConfBean();
        int i = 0;
        while (i < paramArrayOfQConfItem.length)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfQConfItem[i].a) });
          }
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].b);
          if (localJSONObject.has("apolloSwitch")) {
            localApolloConfBean.a.put("apolloConfig", paramArrayOfQConfItem[i].b);
          } else if (localJSONObject.has("preDownLoadRes")) {
            localApolloConfBean.a.put("apolloPreDownload", paramArrayOfQConfItem[i].b);
          }
          i += 1;
        }
        return localApolloConfBean;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("[cmshow]ApolloConfig_GlobalProcessor", 1, paramArrayOfQConfItem, new Object[0]);
        return null;
      }
    }
    QLog.e("[cmshow]ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
    return null;
  }
  
  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    return paramString2;
  }
  
  public static void a()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_config_script", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.d("[cmshow]ApolloConfig_GlobalProcessor", 1, new Object[] { "rollbackConfig scriptConfig:", localObject });
        ApolloConfigUtils.a(new JSONObject((String)localObject), "base_script", false);
        localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
        if (localObject != null)
        {
          ((IApolloManagerService)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all")).setConfigInitDone(true);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloConfig_GlobalProcessor", 1, "rollbackConfig e:", localException);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, ApolloConfBean paramApolloConfBean)
  {
    if ((paramAppRuntime != null) && (paramApolloConfBean != null) && (paramApolloConfBean.a.size() != 0))
    {
      Iterator localIterator = paramApolloConfBean.a.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramApolloConfBean.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(",content:");
          QLog.d("[cmshow]ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", localStringBuilder.toString(), str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          ApolloConfigUtils.a(str2, paramAppRuntime, paramBoolean);
          if (paramBoolean) {
            ((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).initCmShowBaseScript(false);
          }
          i = 1;
        }
        else if ("apolloPreDownload".equals(str1))
        {
          ApolloConfigUtils.b(paramAppRuntime, str2);
        }
      }
      if (i != 0) {
        ApolloGrayConfProcessor.a();
      }
      return;
    }
    QLog.e("[cmshow]ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
    if (!paramBoolean) {
      ApolloConfProcessor.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloConfBean
 * JD-Core Version:    0.7.0.1
 */