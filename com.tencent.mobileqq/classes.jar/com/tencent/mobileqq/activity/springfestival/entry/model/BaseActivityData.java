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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (BaseActivityData)paramObject;
      return (this.type == paramObject.type) && (this.id.equals(paramObject.id));
    }
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
    if (paramJSONObject == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_BaseActivityData", 2, paramJSONObject.toString());
    }
    this.id = paramJSONObject.optString("Id", this.id);
    this.promotionId = paramJSONObject.optString("PromotionId", this.promotionId);
    this.type = paramJSONObject.optInt("Type", this.type);
    boolean bool2 = false;
    if (paramJSONObject.optInt("SupportStaggerPeak", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.staggerPeakSwitch = bool1;
    this.configTimeInfo.begin = Utils.a(paramJSONObject.optString("BeginTime"));
    this.configTimeInfo.end = Utils.a(paramJSONObject.optString("EndTime"));
    this.taskTimeInfo.copyFrom(this.configTimeInfo);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("BreathLight");
    this.breathLightData.parseJson(localJSONObject);
    paramJSONObject = paramJSONObject.optJSONObject("Pendant");
    this.pendantData.parseJson(paramJSONObject);
    paramJSONObject = this.pendantData;
    boolean bool1 = bool2;
    if (this.type == 2) {
      bool1 = true;
    }
    paramJSONObject.validateCloseType(bool1);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseActivityData{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", promotionId=");
    localStringBuilder.append(this.promotionId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(Const.a(this.type));
    localStringBuilder.append(", staggerPeakSwitch=");
    localStringBuilder.append(this.staggerPeakSwitch);
    localStringBuilder.append(", peakDelayMs=");
    localStringBuilder.append(this.peakDelayMs);
    localStringBuilder.append(", configTimeInfo=");
    localStringBuilder.append(this.configTimeInfo);
    localStringBuilder.append(", taskTimeInfo=");
    localStringBuilder.append(this.taskTimeInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseActivityData{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", promotionId=");
    localStringBuilder.append(this.promotionId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(Const.a(this.type));
    localStringBuilder.append(", staggerPeakSwitch=");
    localStringBuilder.append(this.staggerPeakSwitch);
    localStringBuilder.append(", peakDelayMs=");
    localStringBuilder.append(this.peakDelayMs);
    localStringBuilder.append(", configTimeInfo=");
    localStringBuilder.append(this.configTimeInfo);
    localStringBuilder.append(", taskTimeInfo=");
    localStringBuilder.append(this.taskTimeInfo);
    localStringBuilder.append(", pendantData=");
    Object localObject2 = this.pendantData;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", breathLightData=");
    localObject2 = this.breathLightData;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void updatePeakDelay(int paramInt)
  {
    Object localObject = this.pendantData;
    if (localObject != null)
    {
      if (((PendantData)localObject).getConfigTime().begin < getTaskTime().begin) {
        this.pendantData.getTaskTime().begin = getTaskTime().begin;
      }
      if (!Const.a(this.pendantData.getTaskTime())) {
        this.pendantData = null;
      }
    }
    localObject = this.breathLightData;
    if (localObject != null)
    {
      if (((BreathLightData)localObject).getConfigTime().begin < getTaskTime().begin) {
        this.breathLightData.getTaskTime().begin = getTaskTime().begin;
      }
      if (!Const.a(this.breathLightData.getTaskTime())) {
        this.breathLightData = null;
      }
    }
  }
  
  public void validate()
  {
    if ((!Const.a(this.pendantData.getConfigTime())) || (this.pendantData.getConfigTime().begin < getConfigTime().begin) || (this.pendantData.getConfigTime().end > getConfigTime().end)) {
      this.pendantData = null;
    }
    if ((Const.a(this.breathLightData.getConfigTime())) && (this.breathLightData.getConfigTime().begin >= getConfigTime().begin) && (this.breathLightData.getConfigTime().end <= getConfigTime().end)) {
      return;
    }
    this.breathLightData = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData
 * JD-Core Version:    0.7.0.1
 */