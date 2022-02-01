package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.io.Serializable;
import org.json.JSONObject;

public class PreviewEntryData
  implements Serializable
{
  public static final String TAG = "shua2021_PreviewEntryData";
  public String bgUrl = "";
  public String greetImgUrl = "";
  public String leftCloudUrl = "";
  public String logoImgUrl = "";
  public String nameImgUrl = "";
  public String rightCloudUrl = "";
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.logoImgUrl = paramJSONObject.optString("LogoImgUrl", this.logoImgUrl);
    this.nameImgUrl = paramJSONObject.optString("NameImgUrl", this.nameImgUrl);
    this.greetImgUrl = paramJSONObject.optString("GreetImgUrl", this.greetImgUrl);
    this.bgUrl = paramJSONObject.optString("BgUrl", this.bgUrl);
    this.leftCloudUrl = paramJSONObject.optString("LeftCloudImgUrl", this.leftCloudUrl);
    this.rightCloudUrl = paramJSONObject.optString("RightCloudImgUrl", this.rightCloudUrl);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreviewEntryData{logoImgUrl='");
    localStringBuilder.append(this.logoImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nameImgUrl='");
    localStringBuilder.append(this.nameImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", greetImgUrl='");
    localStringBuilder.append(this.greetImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bgUrl='");
    localStringBuilder.append(this.bgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftCloudUrl='");
    localStringBuilder.append(this.leftCloudUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rightCloudUrl='");
    localStringBuilder.append(this.rightCloudUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.PreviewEntryData
 * JD-Core Version:    0.7.0.1
 */