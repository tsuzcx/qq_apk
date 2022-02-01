package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyWechatSimpleVideoCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Util.c(paramBaseArticleInfo, localJSONObject);
    Util.ae(paramBaseArticleInfo, localJSONObject);
    Util.a(paramBaseArticleInfo, localJSONObject, false);
    Util.n(paramBaseArticleInfo, localJSONObject);
    Util.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_wechat_simple_video_cell");
    localJSONObject.put("video_id", paramBaseArticleInfo.getVideoVid());
    localJSONObject.put("busi_type", paramBaseArticleInfo.busiType);
    if (paramBaseArticleInfo.getVideoCoverURL() != null) {}
    for (String str = paramBaseArticleInfo.getVideoCoverURL().getPath();; str = "")
    {
      localJSONObject.put("video_cover_image_url", str);
      localJSONObject.put("dt_pgid", "14");
      Util.aq(paramBaseArticleInfo, localJSONObject);
      Util.G(paramBaseArticleInfo, localJSONObject);
      Util.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyWechatSimpleVideoCell
 * JD-Core Version:    0.7.0.1
 */