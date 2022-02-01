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
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
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
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    Gson localGson = new Gson();
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
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
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.id)) && (!TextUtils.isEmpty(paramJSONObject.poster_id))) {
      return paramJSONObject;
    }
    WSLog.d("ArkJumpUtils", "[ArkJumpUtils.java][getStSimpleMetaFeed] err, feed is err!");
    return null;
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
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static void a(stSimpleMetaFeed paramstSimpleMetaFeed, Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed);
      WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, "qqchat", "qqchat").a(paramstSimpleMetaFeed).a(true));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[ArkJumpUtils.java][handleArkJump] path:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(", metaJson:");
    ((StringBuilder)localObject1).append(paramString2);
    WSLog.e("ArkJumpUtils", ((StringBuilder)localObject1).toString());
    Object localObject2 = a(paramString2);
    if (localObject2 != null)
    {
      paramString1 = a((JSONObject)localObject2);
      if (paramString1 != null)
      {
        WSInitializeHelper.a().a();
        WSInitializeHelper.a().c();
        paramString2 = ((JSONObject)localObject2).optString("groupNum");
        localObject1 = ((JSONObject)localObject2).optString("jumpType");
        localObject2 = ((JSONObject)localObject2).optString("schema");
        if ((TextUtils.equals((CharSequence)localObject1, "jumpApp")) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith("weishi://")) && (WeishiGuideUtils.a(BaseApplicationImpl.getContext())))
        {
          WeishiScehmeUtil.a(QBaseActivity.sTopActivity, "biz_src_jc_gzh_weishi", (String)localObject2);
          WSArkBeaconReport.a(paramString2, 1000003, paramString1);
          return;
        }
        a(paramString1, QBaseActivity.sTopActivity);
        WSArkBeaconReport.a(paramString2, 1000001, paramString1);
        WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_qq_chat", null);
        return;
      }
    }
    ToastUtil.a().a("请求失败，请稍后再试");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSArkJumpUtils
 * JD-Core Version:    0.7.0.1
 */