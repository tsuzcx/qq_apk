package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import java.util.List;
import org.json.JSONObject;

public class ScenesRecommendItem
{
  private ScenesRecommendItem.ScenesRecConfigItem a;
  
  public ScenesRecommendItem(ScenesRecommendItem.ScenesRecConfigItem paramScenesRecConfigItem)
  {
    this.a = paramScenesRecConfigItem;
  }
  
  public String a()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.b;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public String b()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.d;
  }
  
  public String c()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.e;
  }
  
  public String d()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.f;
  }
  
  public List<String> e()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return null;
    }
    return localScenesRecConfigItem.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem
 * JD-Core Version:    0.7.0.1
 */