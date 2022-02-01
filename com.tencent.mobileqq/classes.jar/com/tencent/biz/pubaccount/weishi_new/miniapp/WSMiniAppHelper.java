package com.tencent.biz.pubaccount.weishi_new.miniapp;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedParseUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import java.util.ArrayList;
import java.util.HashMap;

public class WSMiniAppHelper
{
  public static WSMiniAppHelper a()
  {
    return WSMiniAppHelper.SingletonHolder.a();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_ct=");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    if (paramString.contains("?"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&");
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("?");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private ArrayList<stSimpleMetaFeed> a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    Object localObject = (String)paramHashMap.get("feeds");
    paramHashMap = (String)paramHashMap.get("scene");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (TextUtils.isEmpty(paramHashMap)) {
      WeishiUtils.c(paramHashMap);
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("小程序传过来的feed： ");
    paramHashMap.append((String)localObject);
    WSLog.b("WSMiniAppHelper", paramHashMap.toString());
    paramHashMap = new ArrayList();
    localObject = WSFeedParseUtils.a((String)localObject);
    if (localObject != null) {
      paramHashMap.add(localObject);
    }
    return paramHashMap;
  }
  
  public void a(Context paramContext, String paramString)
  {
    WeishiActivityHelper.a(paramContext, paramString, new WSMiniAppHelper.1(this));
  }
  
  public boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    boolean bool1 = false;
    if (paramContext != null)
    {
      if (paramHashMap == null) {
        return false;
      }
      ArrayList localArrayList = a(paramHashMap);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localObject = (stSimpleMetaFeed)localArrayList.get(0);
        if ((((stSimpleMetaFeed)localObject).poster != null) && (TextUtils.equals(((stSimpleMetaFeed)localObject).poster.id, WeishiUtils.d())))
        {
          str1 = "mini_app_personal_main";
          localObject = "homepage_main";
          break label87;
        }
      }
      String str1 = "mini_app_personal_guest";
      Object localObject = "homepage_guest";
      label87:
      String str2 = (String)paramHashMap.get("scenes_from");
      Bundle localBundle = new Bundle();
      if ("share".equals(str2))
      {
        WSInitializeHelper.a().a();
        WSInitializeHelper.a().c();
        localBundle.putString("spid", (String)paramHashMap.get("spid"));
        localBundle.putString("share_collection_id", (String)paramHashMap.get("collection_id"));
        localBundle.putString("share_active_id", (String)paramHashMap.get("active_id"));
        localBundle.putString("scenes_channel_from", (String)paramHashMap.get("share_scenes_from"));
        localBundle.putString("web_test_id", (String)paramHashMap.get("web_test_id"));
        str1 = "share";
        localObject = str1;
      }
      paramHashMap = (String)paramHashMap.get("src_type");
      paramContext = new WSVerticalPageOpenParams(paramContext, str1, (String)localObject).a(localArrayList);
      boolean bool2 = TextUtils.equals(paramHashMap, "web");
      bool1 = true;
      WSVerticalPageFragment.a(paramContext.a(bool2 ^ true).a(localBundle));
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper
 * JD-Core Version:    0.7.0.1
 */