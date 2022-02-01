package com.huawei.hms.framework.network.grs.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.b.d;
import com.huawei.hms.framework.network.grs.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = "a";
  private static d b;
  
  public static d a(Context paramContext)
  {
    try
    {
      Object localObject = b;
      if (localObject != null) {
        return localObject;
      }
      paramContext = c.a("grs_sdk_server_config.json", paramContext);
      boolean bool = TextUtils.isEmpty(paramContext);
      localObject = null;
      if (bool) {
        return null;
      }
      try
      {
        paramContext = new JSONObject(paramContext);
        JSONObject localJSONObject = paramContext.getJSONObject("grs_server");
        JSONArray localJSONArray = localJSONObject.getJSONArray("grs_base_url");
        paramContext = (Context)localObject;
        if (localJSONArray != null)
        {
          paramContext = (Context)localObject;
          if (localJSONArray.length() > 0)
          {
            localObject = new ArrayList();
            i = 0;
            for (;;)
            {
              paramContext = (Context)localObject;
              if (i >= localJSONArray.length()) {
                break;
              }
              ((List)localObject).add(localJSONArray.get(i).toString());
              i += 1;
            }
          }
        }
        b = new d();
        b.a(paramContext);
        paramContext = localJSONObject.getString("grs_query_endpoint_1.0");
        b.b(paramContext);
        paramContext = localJSONObject.getString("grs_query_endpoint_2.0");
        b.a(paramContext);
        int i = localJSONObject.getInt("grs_query_timeout");
        b.a(i);
      }
      catch (JSONException paramContext)
      {
        Logger.w(a, "getGrsServerBean catch JSONException", paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.a.a
 * JD-Core Version:    0.7.0.1
 */