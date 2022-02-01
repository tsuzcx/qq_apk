package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.io.Serializable;
import org.json.JSONObject;

public class OnGrabActivityData$Award
  implements Serializable
{
  public String greetWording = "";
  public String id = "";
  public String logoImgUrl = "";
  public String nameWording = "";
  
  public OnGrabActivityData$Award(OnGrabActivityData paramOnGrabActivityData) {}
  
  void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.id = paramJSONObject.optString("Id", this.id);
    this.logoImgUrl = paramJSONObject.optString("LogoImgUrl", this.logoImgUrl);
    this.nameWording = paramJSONObject.optString("NameWording", this.nameWording);
    this.greetWording = paramJSONObject.optString("GreetWording", this.greetWording);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Award{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", logoImgUrl='");
    localStringBuilder.append(this.logoImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nameWording='");
    localStringBuilder.append(this.nameWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", greetWording='");
    localStringBuilder.append(this.greetWording);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Award
 * JD-Core Version:    0.7.0.1
 */