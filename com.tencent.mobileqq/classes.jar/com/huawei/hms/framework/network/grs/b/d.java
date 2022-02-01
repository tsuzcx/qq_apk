package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.local.model.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends a
{
  public d(Context paramContext, boolean paramBoolean)
  {
    this.e = paramBoolean;
    String str = GrsApp.getInstance().getAppConfigName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appConfigName is");
    ((StringBuilder)localObject).append(str);
    Logger.i("LocalManagerV2", ((StringBuilder)localObject).toString());
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "grs_app_global_route_config.json";
    }
    if (a((String)localObject, paramContext, true) == 0) {
      this.d = true;
    }
  }
  
  public int a(String paramString)
  {
    this.a = new com.huawei.hms.framework.network.grs.local.model.a();
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.getJSONArray("applications").getJSONObject(0);
      Object localObject = paramString.getString("name");
      this.a.b((String)localObject);
      localObject = paramString.getJSONArray("services");
      if (localObject != null)
      {
        if (((JSONArray)localObject).length() == 0) {
          return -1;
        }
        if (paramString.has("customservices")) {
          b(paramString.getJSONArray("customservices"));
        }
        return 0;
      }
      return -1;
    }
    catch (JSONException paramString)
    {
      Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", paramString);
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    Object localObject1 = "countryOrAreaGroups";
    this.b = new ArrayList(16);
    try
    {
      localObject2 = new JSONObject(paramString);
      bool = ((JSONObject)localObject2).has("countryOrAreaGroups");
      if (bool)
      {
        paramString = (String)localObject1;
      }
      else
      {
        if (!((JSONObject)localObject2).has("countryGroups")) {
          break label70;
        }
        paramString = "countryGroups";
      }
      paramString = ((JSONObject)localObject2).getJSONArray(paramString);
      break label308;
      label70:
      Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
      paramString = null;
    }
    catch (JSONException paramString)
    {
      Object localObject2;
      boolean bool;
      int i;
      label91:
      Object localObject3;
      label198:
      label208:
      Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", paramString);
      return -1;
    }
    if (paramString.length() != 0)
    {
      i = 0;
      if (i < paramString.length())
      {
        localObject3 = paramString.getJSONObject(i);
        localObject2 = new b();
        ((b)localObject2).b(((JSONObject)localObject3).getString("id"));
        ((b)localObject2).c(((JSONObject)localObject3).getString("name"));
        ((b)localObject2).a(((JSONObject)localObject3).getString("description"));
        bool = ((JSONObject)localObject3).has("countriesOrAreas");
        localObject1 = "countries";
        if (bool) {
          localObject1 = "countriesOrAreas";
        } else {
          if (!((JSONObject)localObject3).has("countries")) {
            break label198;
          }
        }
        localObject1 = ((JSONObject)localObject3).getJSONArray((String)localObject1);
        break label208;
        Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
        localObject1 = null;
        localObject3 = new HashSet(16);
        if (localObject1 != null)
        {
          if (((JSONArray)localObject1).length() != 0) {
            break label314;
          }
          return -1;
        }
      }
    }
    for (;;)
    {
      int j;
      if (j < ((JSONArray)localObject1).length())
      {
        ((Set)localObject3).add((String)((JSONArray)localObject1).get(j));
        j += 1;
      }
      else
      {
        ((b)localObject2).a((Set)localObject3);
        this.b.add(localObject2);
        i += 1;
        break label91;
        return -1;
        return 0;
        label308:
        if (paramString != null) {
          break;
        }
        return -1;
        label314:
        j = 0;
      }
    }
  }
  
  public int e(String paramString)
  {
    return d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.d
 * JD-Core Version:    0.7.0.1
 */