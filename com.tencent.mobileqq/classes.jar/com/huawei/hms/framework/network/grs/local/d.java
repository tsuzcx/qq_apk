package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends a
{
  public d(Context paramContext)
  {
    if (a("grs_app_global_route_config.json", paramContext) == 0) {
      this.d = true;
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return;
    }
    int i = 0;
    label14:
    JSONObject localJSONObject;
    c localc;
    String str1;
    Object localObject1;
    if (i < paramJSONArray.length())
    {
      localJSONObject = paramJSONArray.getJSONObject(i);
      localc = new c();
      str1 = localJSONObject.getString("name");
      localc.a(str1);
      if (!this.e.contains(str1))
      {
        this.e.add(str1);
        localc.c(localJSONObject.getString("routeBy"));
        JSONArray localJSONArray = localJSONObject.getJSONArray("servings");
        int j = 0;
        while (j < localJSONArray.length())
        {
          Object localObject2 = (JSONObject)localJSONArray.get(j);
          com.huawei.hms.framework.network.grs.local.model.d locald = new com.huawei.hms.framework.network.grs.local.model.d();
          localObject1 = "no-country";
          if (((JSONObject)localObject2).has("countryOrAreaGroup")) {
            localObject1 = ((JSONObject)localObject2).getString("countryOrAreaGroup");
          }
          for (;;)
          {
            locald.a((String)localObject1);
            localObject1 = ((JSONObject)localObject2).getJSONObject("addresses");
            localObject2 = new HashMap(16);
            Iterator localIterator = ((JSONObject)localObject1).keys();
            while (localIterator.hasNext())
            {
              String str2 = (String)localIterator.next();
              ((HashMap)localObject2).put(str2, ((JSONObject)localObject1).getString(str2));
            }
            if (((JSONObject)localObject2).has("countryGroup")) {
              localObject1 = ((JSONObject)localObject2).getString("countryGroup");
            } else {
              Logger.v("LocalManagerV2", "maybe this service routeBy is unconditional.");
            }
          }
          locald.a((Map)localObject2);
          localc.a(locald.a(), locald);
          j += 1;
        }
        if (!localJSONObject.has("countryOrAreaGroups")) {
          break label354;
        }
        localObject1 = a(localJSONObject.getJSONArray("countryOrAreaGroups"), null);
      }
    }
    for (;;)
    {
      localc.a((List)localObject1);
      if (this.a == null) {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
      }
      this.a.a(str1, localc);
      i += 1;
      break label14;
      break;
      label354:
      if (localJSONObject.has("countryGroups"))
      {
        localObject1 = a(localJSONObject.getJSONArray("countryGroups"), null);
      }
      else
      {
        Logger.i("LocalManagerV2", "service use default countryOrAreaGroup");
        localObject1 = null;
      }
    }
  }
  
  public int a(String paramString)
  {
    this.a = new com.huawei.hms.framework.network.grs.local.model.a();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("applications").getJSONObject(0);
        localObject = paramString.getString("name");
        this.a.a((String)localObject);
        localObject = paramString.getJSONArray("services");
        localArrayList = new ArrayList(16);
        if (localObject == null) {
          break label139;
        }
        if (((JSONArray)localObject).length() != 0) {
          break label141;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        ArrayList localArrayList;
        Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", paramString);
        return -1;
      }
      if (i < ((JSONArray)localObject).length())
      {
        localArrayList.add((String)((JSONArray)localObject).get(i));
        i += 1;
      }
      else
      {
        if (paramString.has("customservices")) {
          a(paramString.getJSONArray("customservices"));
        }
        return 0;
        label139:
        return -1;
        label141:
        i = 0;
      }
    }
  }
  
  public List<b> a(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList;
    int i;
    b localb;
    HashSet localHashSet;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList(16);
        i = 0;
        if (i >= paramJSONArray.length()) {
          break;
        }
        paramJSONObject = paramJSONArray.getJSONObject(i);
        localb = new b();
        localb.a(paramJSONObject.getString("id"));
        localb.b(paramJSONObject.getString("name"));
        localb.c(paramJSONObject.getString("description"));
        if (paramJSONObject.has("countriesOrAreas"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("countriesOrAreas");
          localHashSet = new HashSet(16);
          if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
            break label246;
          }
          paramJSONArray = new ArrayList();
          return paramJSONArray;
        }
      }
      catch (JSONException paramJSONArray)
      {
        Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", paramJSONArray);
        return new ArrayList();
      }
      if (paramJSONObject.has("countries"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("countries");
      }
      else
      {
        Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
        paramJSONObject = null;
      }
    }
    for (;;)
    {
      int j;
      if (j < paramJSONObject.length())
      {
        localHashSet.add((String)paramJSONObject.get(j));
        j += 1;
      }
      else
      {
        localb.a(localHashSet);
        localArrayList.add(localb);
        i += 1;
        break;
        return localArrayList;
        label246:
        j = 0;
      }
    }
  }
  
  public int b(String paramString)
  {
    try
    {
      a(new JSONObject(paramString).getJSONArray("services"));
      return 0;
    }
    catch (JSONException paramString)
    {
      Logger.w("LocalManagerV2", "parse 2.0 services failed maybe because of json style.please check!", paramString);
    }
    return -1;
  }
  
  public int c(String paramString)
  {
    this.b = new ArrayList(16);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("countryOrAreaGroups"))
      {
        paramString = paramString.getJSONArray("countryOrAreaGroups");
      }
      else if (paramString.has("countryGroups"))
      {
        paramString = paramString.getJSONArray("countryGroups");
      }
      else
      {
        Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
        paramString = null;
      }
    }
    catch (JSONException paramString)
    {
      int i;
      label81:
      Object localObject;
      b localb;
      HashSet localHashSet;
      Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", paramString);
      return -1;
    }
    if (paramString.length() != 0)
    {
      i = 0;
      if (i < paramString.length())
      {
        localObject = paramString.getJSONObject(i);
        localb = new b();
        localb.a(((JSONObject)localObject).getString("id"));
        localb.b(((JSONObject)localObject).getString("name"));
        localb.c(((JSONObject)localObject).getString("description"));
        if (((JSONObject)localObject).has("countriesOrAreas")) {
          localObject = ((JSONObject)localObject).getJSONArray("countriesOrAreas");
        }
        for (;;)
        {
          localHashSet = new HashSet(16);
          if (localObject == null) {
            break;
          }
          if (((JSONArray)localObject).length() != 0) {
            break label302;
          }
          break;
          if (((JSONObject)localObject).has("countries"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("countries");
          }
          else
          {
            Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
            localObject = null;
          }
        }
      }
    }
    for (;;)
    {
      int j;
      if (j < ((JSONArray)localObject).length())
      {
        localHashSet.add((String)((JSONArray)localObject).get(j));
        j += 1;
      }
      else
      {
        localb.a(localHashSet);
        this.b.add(localb);
        i += 1;
        break label81;
        return 0;
        if (paramString != null) {
          break;
        }
        return -1;
        return -1;
        label302:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.d
 * JD-Core Version:    0.7.0.1
 */