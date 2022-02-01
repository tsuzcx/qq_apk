package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.io.Serializable;
import org.json.JSONObject;

public class OnGrabActivityData$Share
  implements Serializable
{
  public String bgUrl = "";
  public String bottomWording = "";
  public String btnImgApngUrl = "";
  public String btnImgUrl = "";
  public String btnPressImgUrl = "";
  public String greetWording = "";
  public String logoImgUrl = "";
  public String middleBgUrl = "";
  public String middleShareBgUrl = "";
  public String nameWording = "";
  public String qrImgUrl = "";
  public String shareBgUrl = "";
  
  public OnGrabActivityData$Share(OnGrabActivityData paramOnGrabActivityData) {}
  
  void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.bgUrl = paramJSONObject.optString("BgUrl", this.bgUrl);
    this.shareBgUrl = paramJSONObject.optString("ShareBgUrl", this.shareBgUrl);
    this.logoImgUrl = paramJSONObject.optString("LogoImgUrl", this.logoImgUrl);
    this.nameWording = paramJSONObject.optString("NameWording", this.nameWording);
    this.greetWording = paramJSONObject.optString("GreetWording", this.greetWording);
    this.qrImgUrl = paramJSONObject.optString("QRImgUrl", this.qrImgUrl);
    this.bottomWording = paramJSONObject.optString("BottomWording", this.bottomWording);
    this.middleBgUrl = paramJSONObject.optString("MiddleBgUrl", this.middleBgUrl);
    this.middleShareBgUrl = paramJSONObject.optString("MiddleShareBgUrl", this.middleShareBgUrl);
    this.btnImgUrl = paramJSONObject.optString("BtnImgUrl", this.btnImgUrl);
    this.btnPressImgUrl = paramJSONObject.optString("BtnPressImgUrl", this.btnPressImgUrl);
    this.btnImgApngUrl = paramJSONObject.optString("BtnImgApngUrl", this.btnImgApngUrl);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Share{bgUrl='");
    localStringBuilder.append(this.bgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareBgUrl='");
    localStringBuilder.append(this.shareBgUrl);
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
    localStringBuilder.append(", qrImgUrl='");
    localStringBuilder.append(this.qrImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bottomWording='");
    localStringBuilder.append(this.bottomWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", btnImgUrl='");
    localStringBuilder.append(this.btnImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", btnPressImgUrl='");
    localStringBuilder.append(this.btnPressImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", btnImgApngUrl='");
    localStringBuilder.append(this.btnImgApngUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Share
 * JD-Core Version:    0.7.0.1
 */