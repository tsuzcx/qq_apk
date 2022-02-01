package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkAppSchemeCenter
{
  private static HashMap<String, ArkAppSchemeCenter.IRegScheme> a = new HashMap();
  
  static
  {
    a.put("qq", new ArkAppSchemeCenter.QQSchemeHandler());
    a.put("tel", new ArkAppSchemeCenter.TelSchemeHandler());
    a.put("app", new ArkAppSchemeCenter.AppSchemeHandler());
    a.put("mqzone", new ArkAppSchemeCenter.QzoneSchemeHandler());
    a.put("miniapp", new ArkAppSchemeCenter.MiniAppSchemeHandler());
  }
  
  public static List<Object> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = a((JSONArray)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get(str);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = a((JSONArray)localObject2);
      }
      for (;;)
      {
        localHashMap.put(str, localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
    }
    return localHashMap;
  }
  
  public static boolean a(String paramString)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
    {
      int i = 2059;
      try
      {
        int j = Integer.parseInt((String)URLUtil.b(paramString.substring(paramString.indexOf("?") + 1)).get("scene"));
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          EntryModel localEntryModel;
          Activity localActivity;
          Object localObject;
          QLog.e("ArkApp", 1, "Ark parse miniapp scene failed.", localException);
        }
      }
      localEntryModel = b();
      localActivity = ArkAppQQModule.a();
      localObject = localActivity;
      if (localActivity == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)localObject, paramString, i, localEntryModel, null);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "";
    }
    for (;;)
    {
      QLog.e("ArkApp", 2, "navigate url: " + paramString1);
      Object localObject = paramString1.split(":");
      if (localObject.length <= 1) {
        return false;
      }
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString1))
      {
        ArkQQAPIIPCModule.a(paramString1);
        return true;
      }
      localObject = localObject[0];
      ArkAppSchemeCenter.IRegScheme localIRegScheme = (ArkAppSchemeCenter.IRegScheme)a.get(localObject);
      if (localIRegScheme == null) {
        return false;
      }
      localObject = paramString1.substring(((String)localObject).length() + 1);
      paramString1 = (String)localObject;
      if (((String)localObject).startsWith("//")) {
        paramString1 = ((String)localObject).substring(2);
      }
      localIRegScheme.a(paramString1, paramString2, paramJSONObject, paramLong, paramString3);
      return true;
    }
  }
  
  private static EntryModel b()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if ((localObject instanceof TroopChatPie)) {
          return ((BaseChatPie)localObject).a();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter
 * JD-Core Version:    0.7.0.1
 */