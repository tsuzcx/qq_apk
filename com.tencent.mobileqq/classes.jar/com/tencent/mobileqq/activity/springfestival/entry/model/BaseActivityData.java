package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.activity.springfestival.Const;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public abstract class BaseActivityData
  implements ITime, Serializable
{
  public static final String TAG = "shua2021_BaseActivityData";
  @Nullable
  public BreathLightData breathLightData = BreathLightData.newEmpty();
  public TimeInfo configTimeInfo = TimeInfo.newEmpty();
  public String id = "";
  public int peakDelayMs = 0;
  @Nullable
  public PendantData pendantData = PendantData.newEmpty();
  public String promotionId = "";
  public boolean staggerPeakSwitch = false;
  public TimeInfo taskTimeInfo = TimeInfo.newEmpty();
  public int type = 0;
  
  public TimeInfo calcForbidRefreshTimeInfo(long paramLong1, long paramLong2)
  {
    TimeInfo localTimeInfo = TimeInfo.newEmpty();
    localTimeInfo.copyFrom(this.configTimeInfo);
    if ((paramLong1 > 0L) && (paramLong1 < localTimeInfo.begin)) {
      localTimeInfo.begin -= paramLong1;
    }
    if (paramLong2 > 0L) {
      localTimeInfo.end += paramLong2;
    }
    return localTimeInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (BaseActivityData)paramObject;
    } while ((this.type == paramObject.type) && (this.id.equals(paramObject.id)));
    return false;
  }
  
  public TimeInfo getConfigTime()
  {
    return this.configTimeInfo;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  @NotNull
  public abstract MiniAppEntryData getMiniEntryData();
  
  public int getPeakDelayMs()
  {
    return this.peakDelayMs;
  }
  
  public int getTaskAboutToOverDuration()
  {
    return 0;
  }
  
  public TimeInfo getTaskTime()
  {
    return this.taskTimeInfo;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_BaseActivityData", 2, paramJSONObject.toString());
    }
    this.id = paramJSONObject.optString("Id", this.id);
    this.promotionId = paramJSONObject.optString("PromotionId", this.promotionId);
    this.type = paramJSONObject.optInt("Type", this.type);
    if (paramJSONObject.optInt("SupportStaggerPeak", 0) == 1)
    {
      bool1 = true;
      this.staggerPeakSwitch = bool1;
      this.configTimeInfo.begin = Utils.a(paramJSONObject.optString("BeginTime"));
      this.configTimeInfo.end = Utils.a(paramJSONObject.optString("EndTime"));
      this.taskTimeInfo.copyFrom(this.configTimeInfo);
      JSONObject localJSONObject = paramJSONObject.optJSONObject("BreathLight");
      this.breathLightData.parseJson(localJSONObject);
      paramJSONObject = paramJSONObject.optJSONObject("Pendant");
      this.pendantData.parseJson(paramJSONObject);
      paramJSONObject = this.pendantData;
      if (this.type != 2) {
        break label184;
      }
    }
    label184:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramJSONObject.validateCloseType(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean schedulePendantNBreathLight()
  {
    return true;
  }
  
  public boolean scheduleTaskAfterPeak()
  {
    return true;
  }
  
  public String toSimpleString()
  {
    return "BaseActivityData{id='" + this.id + '\'' + ", promotionId=" + this.promotionId + ", type=" + Const.a(this.type) + ", staggerPeakSwitch=" + this.staggerPeakSwitch + ", peakDelayMs=" + this.peakDelayMs + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + '}';
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("BaseActivityData{id='").append(this.id).append('\'').append(", promotionId=").append(this.promotionId).append(", type=").append(Const.a(this.type)).append(", staggerPeakSwitch=").append(this.staggerPeakSwitch).append(", peakDelayMs=").append(this.peakDelayMs).append(", configTimeInfo=").append(this.configTimeInfo).append(", taskTimeInfo=").append(this.taskTimeInfo).append(", pendantData=");
    if (this.pendantData == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append(localObject).append(", breathLightData=");
      if (this.breathLightData != null) {
        break label158;
      }
    }
    label158:
    for (Object localObject = "null";; localObject = this.breathLightData)
    {
      return localObject + '}';
      localObject = this.pendantData;
      break;
    }
  }
  
  public void updatePeakDelay(int paramInt)
  {
    if (this.pendantData != null)
    {
      if (this.pendantData.getConfigTime().begin < getTaskTime().begin) {
        this.pendantData.getTaskTime().begin = getTaskTime().begin;
      }
      if (!Const.a(this.pendantData.getTaskTime())) {
        this.pendantData = null;
      }
    }
    if (this.breathLightData != null)
    {
      if (this.breathLightData.getConfigTime().begin < getTaskTime().begin) {
        this.breathLightData.getTaskTime().begin = getTaskTime().begin;
      }
      if (!Const.a(this.breathLightData.getTaskTime())) {
        this.breathLightData = null;
      }
    }
  }
  
  public void validate()
  {
    if ((Const.a(this.pendantData.getConfigTime())) && (this.pendantData.getConfigTime().begin >= getConfigTime().begin) && (this.pendantData.getConfigTime().end <= getConfigTime().end)) {}
    while ((Const.a(this.breathLightData.getConfigTime())) && (this.breathLightData.getConfigTime().begin >= getConfigTime().begin) && (this.breathLightData.getConfigTime().end <= getConfigTime().end))
    {
      return;
      this.pendantData = null;
    }
    this.breathLightData = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData
 * JD-Core Version:    0.7.0.1
 */