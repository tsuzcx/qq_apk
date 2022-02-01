package com.tencent.biz.pubaccount.readinjoy.webarticle.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/data/BaseInfo;", "", "()V", "process", "", "json", "Lorg/json/JSONObject;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class BaseInfo
{
  public static final BaseInfo.Companion Companion = new BaseInfo.Companion(null);
  @NotNull
  public static final String TYPE_IMAGE = "img_url";
  @NotNull
  public static final String TYPE_TEXT = "cnt_article";
  
  public abstract void process(@NotNull JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.data.BaseInfo
 * JD-Core Version:    0.7.0.1
 */