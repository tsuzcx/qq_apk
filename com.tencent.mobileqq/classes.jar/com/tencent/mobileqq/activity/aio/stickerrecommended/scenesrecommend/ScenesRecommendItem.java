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
    if (this.a == null) {
      return "";
    }
    return this.a.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public String b()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.b;
  }
  
  public String c()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.c;
  }
  
  public String d()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem
 * JD-Core Version:    0.7.0.1
 */