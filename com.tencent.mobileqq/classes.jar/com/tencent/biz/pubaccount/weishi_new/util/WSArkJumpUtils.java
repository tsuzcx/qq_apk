package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSArkBeaconReport;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class WSArkJumpUtils
{
  private static stSimpleMetaFeed a(String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = null;
    try
    {
      paramString = new JSONObject(paramString);
      Gson localGson = new Gson();
      localstSimpleMetaFeed = new stSimpleMetaFeed();
      if (paramString != null)
      {
        localstSimpleMetaFeed.id = paramString.optString("id");
        localstSimpleMetaFeed.ding_count = paramString.optInt("dingCount");
        localstSimpleMetaFeed.is_ding = paramString.optInt("isDing");
        localstSimpleMetaFeed.total_comment_num = paramString.optInt("commentNum");
        localstSimpleMetaFeed.material_desc = paramString.optString("materialDesc");
        localstSimpleMetaFeed.material_thumburl = paramString.optString("materialThumburl");
        localstSimpleMetaFeed.feed_desc = paramString.optString("feedDesc");
        localstSimpleMetaFeed.video = ((stMetaUgcVideoSeg)localGson.fromJson(paramString.optJSONObject("video").toString(), stMetaUgcVideoSeg.class));
        localstSimpleMetaFeed.video_url = paramString.optString("videoUrl");
        ArrayList localArrayList = new ArrayList();
        stMetaUgcImage localstMetaUgcImage = new stMetaUgcImage();
        localstMetaUgcImage.url = paramString.optString("coverUrl");
        localstMetaUgcImage.height = paramString.optInt("coverHeight");
        localstMetaUgcImage.width = paramString.optInt("coverWidth");
        localArrayList.add(localstMetaUgcImage);
        localstSimpleMetaFeed.images = localArrayList;
        localstSimpleMetaFeed.poster_id = paramString.optString("posterId");
        localstSimpleMetaFeed.poster = ((stSimpleMetaPerson)localGson.fromJson(paramString.optJSONObject("poster").toString(), stSimpleMetaPerson.class));
        paramString = new stFloatingLayerCardStyle();
        paramString.cardType = 3;
        localstSimpleMetaFeed.floatingLayerCardStyle = paramString;
      }
      return localstSimpleMetaFeed;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localstSimpleMetaFeed;
      }
    }
  }
  
  @Nullable
  private static stSimpleMetaFeed a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("feed");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      WSLog.d("ArkJumpUtils", "[ArkJumpUtils.java][getStSimpleMetaFeed] err, strFeed is null!");
      return null;
    }
    paramJSONObject = a(paramJSONObject);
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramJSONObject.id)) || (TextUtils.isEmpty(paramJSONObject.poster_id)))
    {
      WSLog.d("ArkJumpUtils", "[ArkJumpUtils.java][getStSimpleMetaFeed] err, feed is err!");
      return null;
    }
    return paramJSONObject;
  }
  
  private static ArrayList<stSimpleMetaFeed> a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramstSimpleMetaFeed != null) {
      localArrayList.add(paramstSimpleMetaFeed);
    }
    return localArrayList;
  }
  
  private static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static void a(stSimpleMetaFeed paramstSimpleMetaFeed, Context paramContext)
  {
    if ((paramContext == null) || (paramstSimpleMetaFeed == null)) {
      return;
    }
    WSVerticalPageFragment.a(paramContext, "qqchat", "qqchat", a(paramstSimpleMetaFeed), 0, true);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    WSLog.e("ArkJumpUtils", "[ArkJumpUtils.java][handleArkJump] path:" + paramString1 + ", metaJson:" + paramString2);
    Object localObject = a(paramString2);
    if (localObject != null)
    {
      paramString1 = a((JSONObject)localObject);
      if (paramString1 != null) {}
    }
    else
    {
      ToastUtil.a().a("请求失败，请稍后再试");
      return;
    }
    WSInitializeHelper.a().a();
    paramString2 = ((JSONObject)localObject).optString("groupNum");
    String str = ((JSONObject)localObject).optString("jumpType");
    localObject = ((JSONObject)localObject).optString("schema");
    if ((TextUtils.equals(str, "jumpApp")) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("weishi://")) && (WeishiGuideUtils.a(BaseApplicationImpl.getContext())))
    {
      WeishiScehmeUtil.a(QBaseActivity.sTopActivity, "biz_src_jc_gzh_weishi", (String)localObject);
      WSArkBeaconReport.a(paramString2, 1000003, paramString1);
      return;
    }
    a(paramString1, QBaseActivity.sTopActivity);
    WSArkBeaconReport.a(paramString2, 1000001, paramString1);
    WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_qq_chat");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSArkJumpUtils
 * JD-Core Version:    0.7.0.1
 */