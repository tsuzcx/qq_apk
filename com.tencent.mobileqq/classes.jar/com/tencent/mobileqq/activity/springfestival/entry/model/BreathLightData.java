package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.activity.springfestival.Utils;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class BreathLightData
  implements ITime, Serializable
{
  public static final String TAG = "shua2021_BreathLightData";
  public TimeInfo configTimeInfo = TimeInfo.newEmpty();
  public TimeInfo taskTimeInfo = TimeInfo.newEmpty();
  public int type = 0;
  
  public static BreathLightData newEmpty()
  {
    return new BreathLightData();
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
    this.type = paramJSONObject.optInt("Type", this.type);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("BreathLightData{, configTimeInfo=").append(this.configTimeInfo).append(", taskTimeInfo=").append(this.taskTimeInfo).append(", type=");
    if (this.type == 0) {}
    for (String str = "yellow";; str = "red") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.BreathLightData
 * JD-Core Version:    0.7.0.1
 */