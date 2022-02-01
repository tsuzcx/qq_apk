package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.activity.springfestival.Utils;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class PopBannerData
  implements ITime, Serializable
{
  public static final String TAG = "shua2021_PopBannerData";
  public TimeInfo configTimeInfo = TimeInfo.newEmpty();
  public String id = "";
  public String imgUrl = "";
  public String jumpUrl = "";
  public int peakDelayMs = 0;
  public boolean staggerPeakSwitch = false;
  public TimeInfo taskTimeInfo = TimeInfo.newEmpty();
  public int type = 0;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (PopBannerData)paramObject;
      return this.id.equals(paramObject.id);
    }
    return false;
  }
  
  @NotNull
  public TimeInfo getConfigTime()
  {
    return this.configTimeInfo;
  }
  
  public int getPeakDelayMs()
  {
    return this.peakDelayMs;
  }
  
  @NotNull
  public TimeInfo getTaskTime()
  {
    return this.taskTimeInfo;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.id = paramJSONObject.optString("Id", "");
    boolean bool = false;
    if (paramJSONObject.optInt("SupportStaggerPeak", 0) == 1) {
      bool = true;
    }
    this.staggerPeakSwitch = bool;
    this.configTimeInfo.begin = Utils.a(paramJSONObject.optString("BeginTime"));
    this.configTimeInfo.end = Utils.a(paramJSONObject.optString("EndTime"));
    this.taskTimeInfo.copyFrom(this.configTimeInfo);
    this.imgUrl = paramJSONObject.optString("ImgUrl", this.imgUrl);
    this.jumpUrl = paramJSONObject.optString("JumpUrl", this.jumpUrl);
    this.type = paramJSONObject.optInt("Type", this.type);
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PopBannerData{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append("type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", staggerPeakSwitch=");
    localStringBuilder.append(this.staggerPeakSwitch);
    localStringBuilder.append(", configTimeInfo=");
    localStringBuilder.append(this.configTimeInfo);
    localStringBuilder.append(", taskTimeInfo=");
    localStringBuilder.append(this.taskTimeInfo);
    localStringBuilder.append(", peakDelayMs=");
    localStringBuilder.append(this.peakDelayMs);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PopBannerData{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append("type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", staggerPeakSwitch=");
    localStringBuilder.append(this.staggerPeakSwitch);
    localStringBuilder.append(", configTimeInfo=");
    localStringBuilder.append(this.configTimeInfo);
    localStringBuilder.append(", taskTimeInfo=");
    localStringBuilder.append(this.taskTimeInfo);
    localStringBuilder.append(", peakDelayMs=");
    localStringBuilder.append(this.peakDelayMs);
    localStringBuilder.append(", imgUrl='");
    localStringBuilder.append(this.imgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData
 * JD-Core Version:    0.7.0.1
 */