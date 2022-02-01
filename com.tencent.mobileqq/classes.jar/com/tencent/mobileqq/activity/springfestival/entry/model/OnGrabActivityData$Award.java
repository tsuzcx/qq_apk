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
    return "Award{id='" + this.id + '\'' + ", logoImgUrl='" + this.logoImgUrl + '\'' + ", nameWording='" + this.nameWording + '\'' + ", greetWording='" + this.greetWording + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Award
 * JD-Core Version:    0.7.0.1
 */