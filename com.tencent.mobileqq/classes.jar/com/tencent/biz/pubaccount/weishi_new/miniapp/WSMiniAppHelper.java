package com.tencent.biz.pubaccount.weishi_new.miniapp;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import org.json.JSONObject;

public class WSMiniAppHelper
{
  private stSimpleMetaFeed a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Gson localGson = new Gson();
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = paramJSONObject.optString("id");
      localstSimpleMetaFeed.ding_count = paramJSONObject.optInt("dingCount");
      localstSimpleMetaFeed.is_ding = paramJSONObject.optInt("isDing");
      localstSimpleMetaFeed.total_comment_num = paramJSONObject.optInt("commentNum");
      localstSimpleMetaFeed.material_desc = paramJSONObject.optString("materialDesc");
      localstSimpleMetaFeed.material_thumburl = paramJSONObject.optString("materialThumburl");
      localstSimpleMetaFeed.feed_desc = paramJSONObject.optString("feedDesc");
      localstSimpleMetaFeed.video = ((stMetaUgcVideoSeg)localGson.fromJson(paramJSONObject.optJSONObject("video").toString(), stMetaUgcVideoSeg.class));
      localstSimpleMetaFeed.video_url = paramJSONObject.optString("videoUrl");
      ArrayList localArrayList = new ArrayList();
      stMetaUgcImage localstMetaUgcImage = new stMetaUgcImage();
      localstMetaUgcImage.url = paramJSONObject.optString("coverUrl");
      localstMetaUgcImage.height = paramJSONObject.optInt("coverHeight");
      localstMetaUgcImage.width = paramJSONObject.optInt("coverWidth");
      localArrayList.add(localstMetaUgcImage);
      localstSimpleMetaFeed.images = localArrayList;
      localstSimpleMetaFeed.poster_id = paramJSONObject.optString("posterId");
      localstSimpleMetaFeed.poster = ((stSimpleMetaPerson)localGson.fromJson(paramJSONObject.optJSONObject("poster").toString(), stSimpleMetaPerson.class));
      paramJSONObject = new stFloatingLayerCardStyle();
      paramJSONObject.cardType = 3;
      localstSimpleMetaFeed.floatingLayerCardStyle = paramJSONObject;
      return localstSimpleMetaFeed;
    }
    return null;
  }
  
  public static WSMiniAppHelper a()
  {
    return WSMiniAppHelper.SingletonHolder.a();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "_ct=" + System.currentTimeMillis();
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&" + str;; paramString = paramString + "?" + str) {
      return paramString;
    }
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
    try
    {
      paramHashMap = URLDecoder.decode((String)localObject, "UTF-8");
      WSLog.b("WSMiniAppHelper", "小程序传过来的feed： " + paramHashMap);
    }
    catch (UnsupportedEncodingException paramHashMap)
    {
      for (;;)
      {
        try
        {
          localObject = new ArrayList();
          paramHashMap = a(new JSONObject(paramHashMap));
          if (paramHashMap != null) {
            ((ArrayList)localObject).add(paramHashMap);
          }
          return localObject;
        }
        catch (Exception paramHashMap)
        {
          paramHashMap.printStackTrace();
          WSLog.d("WSMiniAppHelper", "parse json error: " + paramHashMap.getMessage());
        }
        paramHashMap = paramHashMap;
        paramHashMap.printStackTrace();
        paramHashMap = (HashMap<String, String>)localObject;
      }
    }
    return null;
  }
  
  public void a(Context paramContext, String paramString)
  {
    WeishiActivityHelper.a(paramContext, paramString, new WSMiniAppHelper.1(this));
  }
  
  public boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (paramHashMap == null)) {
      return false;
    }
    ArrayList localArrayList = a(paramHashMap);
    String str3 = "mini_app_personal_guest";
    String str4 = "homepage_guest";
    String str2 = str3;
    String str1 = str4;
    if (localArrayList != null)
    {
      str2 = str3;
      str1 = str4;
      if (localArrayList.size() > 0)
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)localArrayList.get(0);
        str2 = str3;
        str1 = str4;
        if (localstSimpleMetaFeed.poster != null)
        {
          str2 = str3;
          str1 = str4;
          if (TextUtils.equals(localstSimpleMetaFeed.poster.id, WeishiUtils.d()))
          {
            str2 = "mini_app_personal_main";
            str1 = "homepage_main";
          }
        }
      }
    }
    if (!TextUtils.equals((String)paramHashMap.get("src_type"), "web")) {}
    for (boolean bool = true;; bool = false)
    {
      WSVerticalPageFragment.a(paramContext, str2, str1, localArrayList, 0, bool);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper
 * JD-Core Version:    0.7.0.1
 */