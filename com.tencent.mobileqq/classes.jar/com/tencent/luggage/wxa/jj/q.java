package com.tencent.luggage.wxa.jj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public enum q
{
  public static void a(@NonNull d paramd, @Nullable String paramString)
  {
    paramd.M = true;
    paramd.N = true;
    if (af.c(paramString))
    {
      o.c("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("bgKeepAlive");
        if (localJSONObject.optInt("music", 1) == 1)
        {
          bool = true;
          paramd.M = bool;
          if (localJSONObject.optInt("location", 1) != 1) {
            break label119;
          }
          bool = true;
          paramd.N = bool;
          return;
        }
      }
      catch (JSONException paramd)
      {
        o.c("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", new Object[] { paramString });
        o.c("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", new Object[] { paramd });
        return;
      }
      boolean bool = false;
      continue;
      label119:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.q
 * JD-Core Version:    0.7.0.1
 */