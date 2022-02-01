package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.activity.springfestival.Utils;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class PendantData
  implements ITime, Serializable
{
  public static final String TAG = "shua2021_PendantData";
  public int clickType = 0;
  public int closeType = 0;
  public TimeInfo configTimeInfo = TimeInfo.newEmpty();
  public String jumpUrl = "";
  public String pendantImgUrl = "";
  public boolean showPendantSwitch = false;
  public TimeInfo taskTimeInfo = TimeInfo.newEmpty();
  public int type = 0;
  
  public static PendantData newEmpty()
  {
    return new PendantData();
  }
  
  @NotNull
  public TimeInfo getConfigTime()
  {
    return this.configTimeInfo;
  }
  
  public int getPeakDelayMs()
  {
    return 0;
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
    this.configTimeInfo.begin = Utils.a(paramJSONObject.optString("BeginTime"));
    this.configTimeInfo.end = Utils.a(paramJSONObject.optString("EndTime"));
    this.taskTimeInfo.copyFrom(this.configTimeInfo);
    this.pendantImgUrl = paramJSONObject.optString("PendantImgUrl", this.pendantImgUrl);
    this.jumpUrl = paramJSONObject.optString("JumpUrl", this.jumpUrl);
    this.type = paramJSONObject.optInt("Type", this.type);
    this.closeType = paramJSONObject.optInt("CloseType", this.closeType);
    this.clickType = paramJSONObject.optInt("ClickType", this.clickType);
    boolean bool = false;
    if (paramJSONObject.optInt("ShowPendantSwitch", 0) == 1) {
      bool = true;
    }
    this.showPendantSwitch = bool;
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PendantData{, configTimeInfo=");
    localStringBuilder.append(this.configTimeInfo);
    localStringBuilder.append(", taskTimeInfo=");
    localStringBuilder.append(this.taskTimeInfo);
    localStringBuilder.append(", type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", closeType='");
    localStringBuilder.append(this.closeType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clickType='");
    localStringBuilder.append(this.clickType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", showPendantSwitch=");
    localStringBuilder.append(this.showPendantSwitch);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PendantData{, configTimeInfo=");
    localStringBuilder.append(this.configTimeInfo);
    localStringBuilder.append(", taskTimeInfo=");
    localStringBuilder.append(this.taskTimeInfo);
    localStringBuilder.append(", type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", closeType='");
    localStringBuilder.append(this.closeType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clickType='");
    localStringBuilder.append(this.clickType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", showPendantSwitch=");
    localStringBuilder.append(this.showPendantSwitch);
    localStringBuilder.append(", pendantImgUrl='");
    localStringBuilder.append(this.pendantImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void validateCloseType(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.closeType > 1) {
        this.closeType = 1;
      }
    }
    else if (this.closeType > 3) {
      this.closeType = 3;
    }
    if (this.closeType < 0) {
      this.closeType = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.PendantData
 * JD-Core Version:    0.7.0.1
 */