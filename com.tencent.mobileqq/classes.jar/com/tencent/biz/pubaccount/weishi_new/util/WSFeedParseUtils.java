package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

public class WSFeedParseUtils
{
  private static stMetaUgcVideoSeg a(JSONObject paramJSONObject)
  {
    stMetaUgcVideoSeg localstMetaUgcVideoSeg = new stMetaUgcVideoSeg();
    if (paramJSONObject != null)
    {
      localstMetaUgcVideoSeg.file_id = paramJSONObject.optString("file_id");
      localstMetaUgcVideoSeg.file_size = paramJSONObject.optInt("file_size");
      localstMetaUgcVideoSeg.duration = paramJSONObject.optInt("duration");
      localstMetaUgcVideoSeg.width = paramJSONObject.optInt("width");
      localstMetaUgcVideoSeg.height = paramJSONObject.optInt("height");
    }
    return localstMetaUgcVideoSeg;
  }
  
  public static stSimpleMetaFeed a(String paramString)
  {
    try
    {
      paramString = a(new JSONObject(URLDecoder.decode(paramString, "UTF-8")));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFeedParseUtils][parseJson2Feed] parse json error: ");
      localStringBuilder.append(paramString.getMessage());
      WSLog.d("WSFeedParseUtilsLog", localStringBuilder.toString());
    }
    return null;
  }
  
  private static stSimpleMetaFeed a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = paramJSONObject.optString("id");
      localstSimpleMetaFeed.ding_count = paramJSONObject.optInt("dingCount");
      localstSimpleMetaFeed.is_ding = paramJSONObject.optInt("isDing");
      localstSimpleMetaFeed.total_comment_num = paramJSONObject.optInt("commentNum");
      localstSimpleMetaFeed.material_desc = paramJSONObject.optString("materialDesc");
      localstSimpleMetaFeed.material_thumburl = paramJSONObject.optString("materialThumburl");
      localstSimpleMetaFeed.feed_desc = paramJSONObject.optString("feedDesc");
      localstSimpleMetaFeed.video = a(paramJSONObject.optJSONObject("video"));
      localstSimpleMetaFeed.video_url = paramJSONObject.optString("videoUrl");
      ArrayList localArrayList = new ArrayList();
      stMetaUgcImage localstMetaUgcImage = new stMetaUgcImage();
      localstMetaUgcImage.url = paramJSONObject.optString("coverUrl");
      localstMetaUgcImage.height = paramJSONObject.optInt("coverHeight");
      localstMetaUgcImage.width = paramJSONObject.optInt("coverWidth");
      localArrayList.add(localstMetaUgcImage);
      localstSimpleMetaFeed.images = localArrayList;
      localstSimpleMetaFeed.poster_id = paramJSONObject.optString("posterId");
      localstSimpleMetaFeed.poster = a(paramJSONObject.optJSONObject("poster"));
      paramJSONObject = new stFloatingLayerCardStyle();
      paramJSONObject.cardType = 3;
      localstSimpleMetaFeed.floatingLayerCardStyle = paramJSONObject;
      return localstSimpleMetaFeed;
    }
    return null;
  }
  
  private static stSimpleMetaPerson a(JSONObject paramJSONObject)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = new stSimpleMetaPerson();
    if (paramJSONObject != null)
    {
      localstSimpleMetaPerson.id = paramJSONObject.optString("id");
      localstSimpleMetaPerson.type = paramJSONObject.optInt("type");
      localstSimpleMetaPerson.uid = paramJSONObject.optString("uid");
      localstSimpleMetaPerson.nick = paramJSONObject.optString("nick");
      localstSimpleMetaPerson.avatar = paramJSONObject.optString("avatar");
      localstSimpleMetaPerson.followStatus = paramJSONObject.optInt("followStatus");
    }
    return localstSimpleMetaPerson;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedParseUtils
 * JD-Core Version:    0.7.0.1
 */