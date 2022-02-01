package com.huawei.hms.framework.network.grs.b;

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
  public c(Context paramContext, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a("grs_sdk_global_route_config.json", paramContext, false) == 0) {
      this.d = true;
    }
  }
  
  public int a(String paramString)
  {
    this.a = new com.huawei.hms.framework.network.grs.local.model.a();
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.getJSONObject("application");
      paramString = ((JSONObject)localObject).getString("name");
      long l = ((JSONObject)localObject).getLong("cacheControl");
      localObject = ((JSONObject)localObject).getJSONArray("services");
      this.a.b(paramString);
      this.a.a(l);
      if (localObject != null)
      {
        int i = ((JSONArray)localObject).length();
        if (i == 0) {
          return -1;
        }
        return 0;
      }
      return -1;
    }
    catch (JSONException paramString)
    {
      Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", paramString);
    }
    return -1;
  }
  
  public List<b> a(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList(16);
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          paramJSONArray = (String)localIterator.next();
          b localb = new b();
          localb.b(paramJSONArray);
          JSONObject localJSONObject = paramJSONObject.getJSONObject(paramJSONArray);
          localb.c(localJSONObject.getString("name"));
          localb.a(localJSONObject.getString("description"));
          paramJSONArray = null;
          boolean bool = localJSONObject.has("countriesOrAreas");
          Object localObject = "countries";
          if (bool)
          {
            paramJSONArray = "countriesOrAreas";
          }
          else
          {
            if (!localJSONObject.has("countries")) {
              continue;
            }
            paramJSONArray = (JSONArray)localObject;
          }
          paramJSONArray = localJSONObject.getJSONArray(paramJSONArray);
          continue;
          Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
          localObject = new HashSet(16);
          if (paramJSONArray != null)
          {
            if (paramJSONArray.length() != 0) {
              break label268;
            }
            continue;
            if (i < paramJSONArray.length())
            {
              ((Set)localObject).add((String)paramJSONArray.get(i));
              i += 1;
              continue;
            }
            localb.a((Set)localObject);
            localArrayList.add(localb);
            continue;
          }
          paramJSONArray = new ArrayList();
          return paramJSONArray;
        }
        return localArrayList;
      }
      catch (JSONException paramJSONArray)
      {
        Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong.", paramJSONArray);
        return new ArrayList();
      }
      return new ArrayList();
      label268:
      int i = 0;
    }
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
          break label68;
        }
        paramString = "countryGroups";
      }
      paramString = ((JSONObject)localObject2).getJSONObject(paramString);
      break label314;
      label68:
      Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
      paramString = null;
    }
    catch (JSONException paramString)
    {
      Object localObject2;
      boolean bool;
      label93:
      b localb;
      Object localObject3;
      label208:
      label218:
      Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong.", paramString);
      return -1;
    }
    if (paramString.length() != 0)
    {
      localObject2 = paramString.keys();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        localb = new b();
        localb.b((String)localObject1);
        localObject3 = paramString.getJSONObject((String)localObject1);
        localb.c(((JSONObject)localObject3).getString("name"));
        localb.a(((JSONObject)localObject3).getString("description"));
        bool = ((JSONObject)localObject3).has("countriesOrAreas");
        localObject1 = "countries";
        if (bool) {
          localObject1 = "countriesOrAreas";
        } else {
          if (!((JSONObject)localObject3).has("countries")) {
            break label208;
          }
        }
        localObject1 = ((JSONObject)localObject3).getJSONArray((String)localObject1);
        break label218;
        Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
        localObject1 = null;
        localObject3 = new HashSet(16);
        if (localObject1 != null)
        {
          if (((JSONArray)localObject1).length() != 0) {
            break label320;
          }
          return -1;
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < ((JSONArray)localObject1).length())
      {
        ((Set)localObject3).add((String)((JSONArray)localObject1).get(i));
        i += 1;
      }
      else
      {
        localb.a((Set)localObject3);
        this.b.add(localb);
        break label93;
        return -1;
        return 0;
        label314:
        if (paramString != null) {
          break;
        }
        return -1;
        label320:
        i = 0;
      }
    }
  }
  
  public int e(String paramString)
  {
    Object localObject1 = "countryOrAreaGroup";
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject1 = paramString.getJSONObject("services");
      Iterator localIterator1 = localJSONObject1.keys();
      paramString = (String)localObject1;
      for (;;)
      {
        boolean bool = localIterator1.hasNext();
        int i = 0;
        if (!bool) {
          break;
        }
        String str1 = (String)localIterator1.next();
        com.huawei.hms.framework.network.grs.local.model.c localc = new com.huawei.hms.framework.network.grs.local.model.c();
        localc.b(str1);
        if (!this.f.contains(str1))
        {
          this.f.add(str1);
          if (this.e)
          {
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str1);
            localc.c(localJSONObject2.getString("routeBy"));
            JSONArray localJSONArray = localJSONObject2.getJSONArray("servings");
            while (i < localJSONArray.length())
            {
              Object localObject2 = (JSONObject)localJSONArray.get(i);
              d locald = new d();
              bool = ((JSONObject)localObject2).has(paramString);
              localObject1 = "countryGroup";
              if (bool) {
                localObject1 = paramString;
              } else {
                if (!((JSONObject)localObject2).has("countryGroup")) {
                  break label208;
                }
              }
              localObject1 = ((JSONObject)localObject2).getString((String)localObject1);
              break label219;
              label208:
              Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
              localObject1 = "no-country";
              label219:
              locald.a((String)localObject1);
              localObject1 = ((JSONObject)localObject2).getJSONObject("addresses");
              localObject2 = new HashMap(16);
              Iterator localIterator2 = ((JSONObject)localObject1).keys();
              while (localIterator2.hasNext())
              {
                String str2 = (String)localIterator2.next();
                ((HashMap)localObject2).put(str2, ((JSONObject)localObject1).getString(str2));
              }
              locald.a((Map)localObject2);
              localc.a(locald.b(), locald);
              i += 1;
            }
            bool = localJSONObject2.has("countryOrAreaGroups");
            localObject1 = null;
            if (bool)
            {
              localObject1 = localJSONObject2.getJSONObject("countryOrAreaGroups");
            }
            else
            {
              if (!localJSONObject2.has("countryGroups")) {
                break label377;
              }
              localObject1 = localJSONObject2.getJSONObject("countryGroups");
            }
            localObject1 = a(null, (JSONObject)localObject1);
            break label384;
            label377:
            Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
            label384:
            localc.a((List)localObject1);
            if (this.a == null) {
              this.a = new com.huawei.hms.framework.network.grs.local.model.a();
            }
            this.a.a(str1, localc);
          }
        }
      }
      return 0;
    }
    catch (JSONException paramString)
    {
      Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check!", paramString);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.c
 * JD-Core Version:    0.7.0.1
 */