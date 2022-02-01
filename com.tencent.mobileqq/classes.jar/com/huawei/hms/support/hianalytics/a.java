package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class a
{
  protected static Map<String, String> getMapForBi(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return localHashMap;
      }
      Object localObject = paramString.split("\\.");
      if (localObject.length >= 2)
      {
        paramString = localObject[0];
        localObject = localObject[1];
        localHashMap.put("service", paramString);
        localHashMap.put("apiName", localObject);
        localHashMap.put("package", paramContext.getPackageName());
        localHashMap.put("baseVersion", "5.2.0.300");
        localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.a
 * JD-Core Version:    0.7.0.1
 */