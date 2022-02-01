package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
{
  protected com.huawei.hms.framework.network.grs.local.model.a a;
  protected List<b> b;
  protected Map<String, String> c = new ConcurrentHashMap(16);
  protected boolean d = false;
  protected boolean e = false;
  protected Set<String> f = new HashSet(16);
  
  private int a(Context paramContext)
  {
    Object localObject = paramContext.getAssets();
    int i = -1;
    for (;;)
    {
      try
      {
        localObject = ((AssetManager)localObject).list("");
        j = i;
        if (localObject != null)
        {
          j = i;
          if (localObject.length > 0)
          {
            int m = localObject.length;
            j = 0;
            i = -1;
            if (j < m)
            {
              localCharSequence = localObject[j];
              k = i;
            }
          }
        }
      }
      catch (IOException paramContext)
      {
        int j;
        CharSequence localCharSequence;
        int k;
        continue;
      }
      try
      {
        if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", localCharSequence))
        {
          int n = g(com.huawei.hms.framework.network.grs.d.c.a(localCharSequence, paramContext));
          k = i;
          if (n == 0)
          {
            Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE sucess.");
            k = 0;
          }
        }
        j += 1;
        i = k;
      }
      catch (IOException paramContext) {}
    }
    break label111;
    return i;
    label111:
    Logger.w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
    j = i;
    return j;
  }
  
  private int a(String paramString, Context paramContext)
  {
    if (f(com.huawei.hms.framework.network.grs.d.c.a(paramString, paramContext)) == 0)
    {
      Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success.");
      return 0;
    }
    return -1;
  }
  
  private Map<String, String> a(List<b> paramList, GrsBaseInfo paramGrsBaseInfo, String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(16);
    localConcurrentHashMap.put("no_route_country", "no-country");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.a().contains(paramGrsBaseInfo.getIssueCountry())) {
        localConcurrentHashMap.put(paramGrsBaseInfo.getIssueCountry(), localb.b());
      }
      if (localb.a().contains(paramGrsBaseInfo.getRegCountry())) {
        localConcurrentHashMap.put(paramGrsBaseInfo.getRegCountry(), localb.b());
      }
      if (localb.a().contains(paramGrsBaseInfo.getSerCountry())) {
        localConcurrentHashMap.put(paramGrsBaseInfo.getSerCountry(), localb.b());
      }
      if (localb.a().contains(paramString))
      {
        Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
        localConcurrentHashMap.put(paramString, localb.b());
      }
    }
    return localConcurrentHashMap;
  }
  
  private int f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (this.e)
    {
      i = b(paramString);
      if (i != 0) {
        return i;
      }
    }
    int i = a(paramString);
    if (i != 0) {
      return i;
    }
    return e(paramString);
  }
  
  private int g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (this.e)
    {
      List localList = this.b;
      if ((localList == null) || (localList.isEmpty()))
      {
        int i = c(paramString);
        if (i != 0) {
          return i;
        }
      }
    }
    return d(paramString);
  }
  
  public abstract int a(String paramString);
  
  int a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((a(paramString, paramContext) != 0) && (paramBoolean)) {
      return -1;
    }
    a(paramContext);
    return 0;
  }
  
  public com.huawei.hms.framework.network.grs.local.model.a a()
  {
    return this.a;
  }
  
  public String a(Context paramContext, com.huawei.hms.framework.network.grs.a.a parama, GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = a(paramContext, parama, paramGrsBaseInfo, paramString1, paramBoolean);
    if (paramContext == null)
    {
      Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", new Object[] { paramString1 });
      return null;
    }
    return (String)paramContext.get(paramString2);
  }
  
  public List<b> a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList(16);
        int i = 0;
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          b localb = new b();
          localb.b(localJSONObject.getString("id"));
          localb.c(localJSONObject.getString("name"));
          localb.a(localJSONObject.getString("description"));
          Object localObject1 = null;
          boolean bool = localJSONObject.has("countriesOrAreas");
          Object localObject2 = "countries";
          if (bool)
          {
            localObject1 = "countriesOrAreas";
          }
          else
          {
            if (!localJSONObject.has("countries")) {
              continue;
            }
            localObject1 = localObject2;
          }
          localObject1 = localJSONObject.getJSONArray((String)localObject1);
          continue;
          Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
          localObject2 = new HashSet(16);
          if (localObject1 != null)
          {
            if (((JSONArray)localObject1).length() != 0) {
              break label271;
            }
            continue;
            if (j < ((JSONArray)localObject1).length())
            {
              ((Set)localObject2).add((String)((JSONArray)localObject1).get(j));
              j += 1;
              continue;
            }
            localb.a((Set)localObject2);
            localArrayList.add(localb);
            i += 1;
            continue;
          }
          paramJSONArray = new ArrayList();
          return paramJSONArray;
        }
        return localArrayList;
      }
      catch (JSONException paramJSONArray)
      {
        Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong.", paramJSONArray);
        return new ArrayList();
      }
      return new ArrayList();
      label271:
      int j = 0;
    }
  }
  
  public Map<String, String> a(Context paramContext, com.huawei.hms.framework.network.grs.a.a parama, GrsBaseInfo paramGrsBaseInfo, String paramString, boolean paramBoolean)
  {
    if (!this.d) {
      return null;
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      Logger.w("AbstractLocalManager", "application data is null.");
      return null;
    }
    localObject = ((com.huawei.hms.framework.network.grs.local.model.a)localObject).a(paramString);
    if (localObject == null)
    {
      Logger.w("AbstractLocalManager", "service not found in local config{%s}", new Object[] { paramString });
      return null;
    }
    parama = f.a(paramContext, parama, ((com.huawei.hms.framework.network.grs.local.model.c)localObject).b(), paramGrsBaseInfo, paramBoolean);
    if (parama == null)
    {
      Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", new Object[] { ((com.huawei.hms.framework.network.grs.local.model.c)localObject).b() });
      return null;
    }
    paramContext = ((com.huawei.hms.framework.network.grs.local.model.c)localObject).a();
    if ((paramContext != null) && (paramContext.size() != 0)) {
      paramContext = a(paramContext, paramGrsBaseInfo, parama);
    } else {
      paramContext = this.c;
    }
    paramContext = ((com.huawei.hms.framework.network.grs.local.model.c)localObject).a((String)paramContext.get(parama));
    if (paramContext == null) {
      return null;
    }
    return paramContext.a();
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo)
  {
    this.c.put("no_route_country", "no-country");
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (localb.a().contains(paramGrsBaseInfo.getIssueCountry())) {
          this.c.put(paramGrsBaseInfo.getIssueCountry(), localb.b());
        }
        if (localb.a().contains(paramGrsBaseInfo.getRegCountry())) {
          this.c.put(paramGrsBaseInfo.getRegCountry(), localb.b());
        }
        if (localb.a().contains(paramGrsBaseInfo.getSerCountry())) {
          this.c.put(paramGrsBaseInfo.getSerCountry(), localb.b());
        }
      }
      this.b = null;
    }
  }
  
  public abstract int b(String paramString);
  
  public Set<String> b()
  {
    return this.f;
  }
  
  protected void b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return;
      }
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        com.huawei.hms.framework.network.grs.local.model.c localc = new com.huawei.hms.framework.network.grs.local.model.c();
        String str1 = localJSONObject.getString("name");
        localc.b(str1);
        if (!this.f.contains(str1))
        {
          this.f.add(str1);
          if (this.e)
          {
            localc.c(localJSONObject.getString("routeBy"));
            Object localObject2 = localJSONObject.getJSONArray("servings");
            int j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              Object localObject3 = (JSONObject)((JSONArray)localObject2).get(j);
              d locald = new d();
              localObject1 = "countryOrAreaGroup";
              if (((JSONObject)localObject3).has("countryOrAreaGroup")) {}
              do
              {
                localObject1 = ((JSONObject)localObject3).getString((String)localObject1);
                break;
                localObject1 = "countryGroup";
              } while (((JSONObject)localObject3).has("countryGroup"));
              Logger.v("AbstractLocalManager", "maybe this service routeBy is unconditional.");
              localObject1 = "no-country";
              locald.a((String)localObject1);
              localObject1 = ((JSONObject)localObject3).getJSONObject("addresses");
              localObject3 = new HashMap(16);
              Iterator localIterator = ((JSONObject)localObject1).keys();
              while (localIterator.hasNext())
              {
                String str2 = (String)localIterator.next();
                ((HashMap)localObject3).put(str2, ((JSONObject)localObject1).getString(str2));
              }
              locald.a((Map)localObject3);
              localc.a(locald.b(), locald);
              j += 1;
            }
            Object localObject1 = null;
            localObject2 = "countryOrAreaGroups";
            if (localJSONObject.has("countryOrAreaGroups")) {}
            for (localObject1 = localObject2;; localObject1 = localObject2)
            {
              localObject1 = a(localJSONObject.getJSONArray((String)localObject1));
              break label371;
              localObject2 = "countryGroups";
              if (!localJSONObject.has("countryGroups")) {
                break;
              }
            }
            Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
            label371:
            localc.a((List)localObject1);
            if (this.a == null) {
              this.a = new com.huawei.hms.framework.network.grs.local.model.a();
            }
            this.a.a(str1, localc);
          }
        }
        i += 1;
      }
    }
  }
  
  public int c(String paramString)
  {
    String str = "countryOrAreaGroups";
    this.b = new ArrayList(16);
    label72:
    do
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = null;
        boolean bool = localJSONObject.has("countryOrAreaGroups");
        if (bool)
        {
          paramString = str;
        }
        else
        {
          if (!localJSONObject.has("countryGroups")) {
            break label72;
          }
          paramString = "countryGroups";
        }
        paramString = localJSONObject.getJSONArray(paramString);
        continue;
        Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
      }
      catch (JSONException paramString)
      {
        Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong.", paramString);
        return -1;
      }
      this.b.addAll(a(paramString));
      return 0;
    } while (paramString != null);
    return -1;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public int d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      b(paramString.getJSONArray("services"));
      return 0;
    }
    catch (JSONException paramString)
    {
      Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check!", paramString);
    }
    return -1;
  }
  
  public abstract int e(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.a
 * JD-Core Version:    0.7.0.1
 */