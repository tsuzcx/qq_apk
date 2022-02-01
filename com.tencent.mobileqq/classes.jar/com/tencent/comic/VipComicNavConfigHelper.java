package com.tencent.comic;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipComicNavConfigHelper
{
  public static volatile boolean a = g();
  private static final ArrayList<String> b = new ArrayList(5);
  private static final Map<String, String> c;
  private static Map<String, VipComicNavConfigHelper.TabItemData> d;
  
  static
  {
    b.add("index");
    b.add("fav");
    b.add("category");
    b.add("more");
    b.add("group");
    c = new HashMap(5);
    c.put("NavConfig", "index");
    c.put("FavNavConfig", "fav");
    c.put("CateNavConfig", "category");
    c.put("MoreNavConfig", "more");
    c.put("GroupNavConfig", "group");
  }
  
  public static String a(String paramString)
  {
    if (a) {
      return new File(e(), paramString).getAbsolutePath();
    }
    return null;
  }
  
  public static List<VipComicNavConfigHelper.TabItemData> a()
  {
    Object localObject = b();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipComicNavConfigHelper.TabItemData localTabItemData = (VipComicNavConfigHelper.TabItemData)((Iterator)localObject).next();
        if (localTabItemData.a >= 0) {
          localArrayList.add(localTabItemData);
        }
      }
      Collections.sort(localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (g()) {
      i();
    } else {
      ((IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(100L, "vipComic_nav_config.json", "helper");
    }
    if (!h()) {
      ((IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(100L, "vipComic_nav_tabIcon.zip", "helper");
    }
  }
  
  public static Map<String, VipComicNavConfigHelper.TabItemData> b()
  {
    if (d == null) {
      i();
    }
    return d;
  }
  
  public static File c()
  {
    return new File(AppHelper.a().getFilesDir(), "comic_config/");
  }
  
  public static File d()
  {
    return new File(c(), "vipComic_nav_config.json");
  }
  
  public static File e()
  {
    return new File(c(), "tab_icons/");
  }
  
  public static JSONObject f()
  {
    String str = FileUtils.readFileContent(new File(c(), "vipComic_nav_config.json"));
    if (!TextUtils.isEmpty(str)) {
      return new JSONObject(str);
    }
    return null;
  }
  
  public static boolean g()
  {
    return d().exists();
  }
  
  public static boolean h()
  {
    a = k();
    return a;
  }
  
  public static void i()
  {
    try
    {
      JSONObject localJSONObject1 = f();
      if (localJSONObject1 != null)
      {
        if (d != null) {
          d.clear();
        }
        d = new HashMap();
        Iterator localIterator = localJSONObject1.keys();
        label242:
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = localJSONObject1.optJSONArray(str);
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            int i = ((JSONArray)localObject).length() - 1;
            for (;;)
            {
              if (i < 0) {
                break label242;
              }
              JSONObject localJSONObject2 = ((JSONArray)localObject).optJSONObject(i);
              if ((localJSONObject2 != null) && (SwiftWebViewUtils.a(localJSONObject2, str)))
              {
                localObject = new VipComicNavConfigHelper.TabItemData();
                ((VipComicNavConfigHelper.TabItemData)localObject).b = localJSONObject2.optString("tabKey");
                if ((TextUtils.isEmpty(((VipComicNavConfigHelper.TabItemData)localObject).b)) && (c.containsKey(str))) {
                  ((VipComicNavConfigHelper.TabItemData)localObject).b = ((String)c.get(str));
                }
                ((VipComicNavConfigHelper.TabItemData)localObject).a = localJSONObject2.optInt("sequence");
                ((VipComicNavConfigHelper.TabItemData)localObject).c = localJSONObject2.optString("tabName");
                ((VipComicNavConfigHelper.TabItemData)localObject).d = localJSONObject2.optString("tabUrl");
                ((VipComicNavConfigHelper.TabItemData)localObject).e = localJSONObject2.optString("tabIcon");
                d.put(str, localObject);
                break;
              }
              i -= 1;
            }
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("VipComicNavConfigHelper", 1, localJSONException, new Object[0]);
    }
  }
  
  private static boolean k()
  {
    Object localObject1 = b();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      Object localObject2 = e().list();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject2 = Arrays.asList((Object[])localObject2);
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (!((List)localObject2).contains(((VipComicNavConfigHelper.TabItemData)((Iterator)localObject1).next()).e)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicNavConfigHelper
 * JD-Core Version:    0.7.0.1
 */