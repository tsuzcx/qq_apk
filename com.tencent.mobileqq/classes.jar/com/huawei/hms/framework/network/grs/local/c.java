package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
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

public class c
  extends a
{
  public c(Context paramContext)
  {
    if (a("grs_sdk_global_route_config.json", paramContext) == 0) {
      this.d = true;
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
        localObject = new JSONObject(paramString).getJSONObject("application");
        paramString = ((JSONObject)localObject).getString("name");
        long l = ((JSONObject)localObject).getLong("cacheControl");
        localObject = ((JSONObject)localObject).getJSONArray("services");
        this.a.a(paramString);
        this.a.a(l);
        paramString = new ArrayList(16);
        if (localObject == null) {
          break label138;
        }
        if (((JSONArray)localObject).length() != 0) {
          break label140;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", paramString);
        return -1;
      }
      if (i < ((JSONArray)localObject).length())
      {
        paramString.add((String)((JSONArray)localObject).get(i));
        i += 1;
      }
      else
      {
        return 0;
        label138:
        return -1;
        label140:
        i = 0;
      }
    }
  }
  
  public List<b> a(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList;
    b localb;
    HashSet localHashSet;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList(16);
        Iterator localIterator = paramJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        paramJSONArray = (String)localIterator.next();
        localb = new b();
        localb.a(paramJSONArray);
        paramJSONArray = paramJSONObject.getJSONObject(paramJSONArray);
        localb.b(paramJSONArray.getString("name"));
        localb.c(paramJSONArray.getString("description"));
        if (paramJSONArray.has("countriesOrAreas"))
        {
          paramJSONArray = paramJSONArray.getJSONArray("countriesOrAreas");
          localHashSet = new HashSet(16);
          if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {
            break label250;
          }
          paramJSONArray = new ArrayList();
          return paramJSONArray;
        }
      }
      catch (JSONException paramJSONArray)
      {
        Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong.", paramJSONArray);
        return new ArrayList();
      }
      if (paramJSONArray.has("countries"))
      {
        paramJSONArray = paramJSONArray.getJSONArray("countries");
      }
      else
      {
        Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
        paramJSONArray = null;
      }
    }
    for (;;)
    {
      int i;
      if (i < paramJSONArray.length())
      {
        localHashSet.add((String)paramJSONArray.get(i));
        i += 1;
      }
      else
      {
        localb.a(localHashSet);
        localArrayList.add(localb);
        break;
        return localArrayList;
        label250:
        i = 0;
      }
    }
  }
  
  public int b(String paramString)
  {
    String str1;
    com.huawei.hms.framework.network.grs.local.model.c localc;
    JSONObject localJSONObject2;
    for (;;)
    {
      int i;
      Object localObject;
      d locald;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString).getJSONObject("services");
        Iterator localIterator1 = localJSONObject1.keys();
        if (!localIterator1.hasNext()) {
          break label402;
        }
        str1 = (String)localIterator1.next();
        localc = new com.huawei.hms.framework.network.grs.local.model.c();
        localc.a(str1);
        if (this.e.contains(str1)) {
          continue;
        }
        this.e.add(str1);
        localJSONObject2 = localJSONObject1.getJSONObject(str1);
        localc.c(localJSONObject2.getString("routeBy"));
        JSONArray localJSONArray = localJSONObject2.getJSONArray("servings");
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject = (JSONObject)localJSONArray.get(i);
        locald = new d();
        paramString = "no-country";
        if (((JSONObject)localObject).has("countryOrAreaGroup"))
        {
          paramString = ((JSONObject)localObject).getString("countryOrAreaGroup");
          locald.a(paramString);
          paramString = ((JSONObject)localObject).getJSONObject("addresses");
          localObject = new HashMap(16);
          Iterator localIterator2 = paramString.keys();
          if (!localIterator2.hasNext()) {
            break label277;
          }
          String str2 = (String)localIterator2.next();
          ((HashMap)localObject).put(str2, paramString.getString(str2));
          continue;
        }
        if (!((JSONObject)localObject).has("countryGroup")) {
          break label267;
        }
      }
      catch (JSONException paramString)
      {
        Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check!", paramString);
        return -1;
      }
      paramString = ((JSONObject)localObject).getString("countryGroup");
      continue;
      label267:
      Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
      continue;
      label277:
      locald.a((Map)localObject);
      localc.a(locald.a(), locald);
      i += 1;
    }
    paramString = null;
    if (localJSONObject2.has("countryOrAreaGroups")) {
      paramString = a(null, localJSONObject2.getJSONObject("countryOrAreaGroups"));
    }
    for (;;)
    {
      localc.a(paramString);
      if (this.a == null) {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
      }
      this.a.a(str1, localc);
      break;
      if (localJSONObject2.has("countryGroups")) {
        paramString = a(null, localJSONObject2.getJSONObject("countryGroups"));
      } else {
        Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
      }
    }
    label402:
    return 0;
  }
  
  public int c(String paramString)
  {
    this.b = new ArrayList(16);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("countryOrAreaGroups"))
      {
        paramString = paramString.getJSONObject("countryOrAreaGroups");
      }
      else if (paramString.has("countryGroups"))
      {
        paramString = paramString.getJSONObject("countryGroups");
      }
      else
      {
        Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
        paramString = null;
      }
    }
    catch (JSONException paramString)
    {
      Iterator localIterator;
      label85:
      Object localObject;
      b localb;
      HashSet localHashSet;
      Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong.", paramString);
      return -1;
    }
    if (paramString.length() != 0)
    {
      localIterator = paramString.keys();
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localb = new b();
        localb.a((String)localObject);
        localObject = paramString.getJSONObject((String)localObject);
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
            break label295;
          }
          break;
          if (((JSONObject)localObject).has("countries"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("countries");
          }
          else
          {
            Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
            localObject = null;
          }
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < ((JSONArray)localObject).length())
      {
        localHashSet.add((String)((JSONArray)localObject).get(i));
        i += 1;
      }
      else
      {
        localb.a(localHashSet);
        this.b.add(localb);
        break label85;
        return 0;
        if (paramString != null) {
          break;
        }
        return -1;
        return -1;
        label295:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.c
 * JD-Core Version:    0.7.0.1
 */