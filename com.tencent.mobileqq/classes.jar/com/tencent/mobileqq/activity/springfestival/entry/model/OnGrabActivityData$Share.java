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
    return "Share{bgUrl='" + this.bgUrl + '\'' + ", shareBgUrl='" + this.shareBgUrl + '\'' + ", logoImgUrl='" + this.logoImgUrl + '\'' + ", nameWording='" + this.nameWording + '\'' + ", greetWording='" + this.greetWording + '\'' + ", qrImgUrl='" + this.qrImgUrl + '\'' + ", bottomWording='" + this.bottomWording + '\'' + ", btnImgUrl='" + this.btnImgUrl + '\'' + ", btnPressImgUrl='" + this.btnPressImgUrl + '\'' + ", btnImgApngUrl='" + this.btnImgApngUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Share
 * JD-Core Version:    0.7.0.1
 */