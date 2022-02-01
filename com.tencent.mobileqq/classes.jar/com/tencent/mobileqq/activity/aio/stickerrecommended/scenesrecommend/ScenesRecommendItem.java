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
    return localScenesRecConfigItem.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return null;
    }
    return localScenesRecConfigItem.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public String b()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.b;
  }
  
  public String c()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.c;
  }
  
  public String d()
  {
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = this.a;
    if (localScenesRecConfigItem == null) {
      return "";
    }
    return localScenesRecConfigItem.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem
 * JD-Core Version:    0.7.0.1
 */