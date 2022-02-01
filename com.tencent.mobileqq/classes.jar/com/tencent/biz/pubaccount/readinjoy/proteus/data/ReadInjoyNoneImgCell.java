package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class ReadInjoyNoneImgCell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Util.a(paramBaseArticleInfo, localJSONObject, true);
    Util.a(paramBaseArticleInfo, localJSONObject);
    Util.d(paramBaseArticleInfo, localJSONObject);
    Util.g(paramBaseArticleInfo, localJSONObject);
    Util.n(paramBaseArticleInfo, localJSONObject);
    Util.i(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    Util.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyNoneImgCell
 * JD-Core Version:    0.7.0.1
 */