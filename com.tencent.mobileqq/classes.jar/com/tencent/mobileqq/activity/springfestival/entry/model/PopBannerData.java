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
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (PopBannerData)paramObject;
    return this.id.equals(paramObject.id);
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
    boolean bool = true;
    if (paramJSONObject == null) {
      return;
    }
    this.id = paramJSONObject.optString("Id", "");
    if (paramJSONObject.optInt("SupportStaggerPeak", 0) == 1) {}
    for (;;)
    {
      this.staggerPeakSwitch = bool;
      this.configTimeInfo.begin = Utils.a(paramJSONObject.optString("BeginTime"));
      this.configTimeInfo.end = Utils.a(paramJSONObject.optString("EndTime"));
      this.taskTimeInfo.copyFrom(this.configTimeInfo);
      this.imgUrl = paramJSONObject.optString("ImgUrl", this.imgUrl);
      this.jumpUrl = paramJSONObject.optString("JumpUrl", this.jumpUrl);
      this.type = paramJSONObject.optInt("Type", this.type);
      return;
      bool = false;
    }
  }
  
  public String toSimpleString()
  {
    return "PopBannerData{id='" + this.id + '\'' + "type='" + this.type + '\'' + ", staggerPeakSwitch=" + this.staggerPeakSwitch + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", peakDelayMs=" + this.peakDelayMs + '}';
  }
  
  public String toString()
  {
    return "PopBannerData{id='" + this.id + '\'' + "type='" + this.type + '\'' + ", staggerPeakSwitch=" + this.staggerPeakSwitch + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", peakDelayMs=" + this.peakDelayMs + ", imgUrl='" + this.imgUrl + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData
 * JD-Core Version:    0.7.0.1
 */