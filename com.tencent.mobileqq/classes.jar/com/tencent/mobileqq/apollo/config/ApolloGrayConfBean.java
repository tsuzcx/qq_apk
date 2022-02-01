package com.tencent.mobileqq.apollo.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloGrayConfBean
{
  private Map<String, String> a = new HashMap();
  
  public static ApolloGrayConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length <= 0) {
        return null;
      }
      try
      {
        ApolloGrayConfBean localApolloGrayConfBean = new ApolloGrayConfBean();
        int i = 0;
        while (i < paramArrayOfQConfItem.length)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfQConfItem[i].a) });
          }
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].b);
          if (localJSONObject.has("grayUrlConfig")) {
            localApolloGrayConfBean.a.put("apolloGrayUrlWhite", paramArrayOfQConfItem[i].b);
          } else if (localJSONObject.has("traceConfig")) {
            localApolloGrayConfBean.a.put("apolloTraceConfig", paramArrayOfQConfItem[i].b);
          }
          i += 1;
        }
        return localApolloGrayConfBean;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("[cmshow]ApolloConfig_GrayProcessor", 1, paramArrayOfQConfItem, new Object[0]);
      }
    }
    return null;
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, ApolloGrayConfBean paramApolloGrayConfBean)
  {
    if (paramAppRuntime != null)
    {
      if (paramApolloGrayConfBean == null) {
        return;
      }
      Iterator localIterator = paramApolloGrayConfBean.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramApolloGrayConfBean.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("[cmshow]ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          ApolloConfigUtils.a(paramAppRuntime, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          ApolloConfigUtils.a(paramAppRuntime, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloGrayConfBean
 * JD-Core Version:    0.7.0.1
 */