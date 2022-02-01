package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.io.Serializable;

public class UserData$UserDataItem
  implements Serializable
{
  public static final long LEFT_COUNT_DOWN_DURATION_DEFAULT = -1L;
  public String activityId = "";
  public long brushStartTsForReport = -1L;
  public boolean hasClickCloseBtn = false;
  public boolean hasDisplayBreathLight = false;
  public boolean hasReportedAbnormalQuit = false;
  public boolean isAbnormalQuit = false;
  public boolean isHit = false;
  public long lastReqGrabTs = 0L;
  public long leftCountDownDuration = -1L;
  public int maxComboCountForShare = 0;
  public int pendantCloseType = -1;
  public long startGrabTs = 0L;
  public int totalGrabCountForShare = 0;
  public int totalHitCountForShare = 0;
  
  public UserData$UserDataItem(String paramString)
  {
    this.activityId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (UserDataItem)paramObject;
      return this.activityId.equals(paramObject.activityId);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserDataItem{activityId='");
    localStringBuilder.append(this.activityId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startGrabTs=");
    localStringBuilder.append(this.startGrabTs);
    localStringBuilder.append(", lastReqGrabTs=");
    localStringBuilder.append(this.lastReqGrabTs);
    localStringBuilder.append(", leftCountDownDuration=");
    localStringBuilder.append(this.leftCountDownDuration);
    localStringBuilder.append(", isHit=");
    localStringBuilder.append(this.isHit);
    localStringBuilder.append(", hasClickCloseBtn=");
    localStringBuilder.append(this.hasClickCloseBtn);
    localStringBuilder.append(", pendantCloseType=");
    localStringBuilder.append(this.pendantCloseType);
    localStringBuilder.append(", hasDisplayBreathLight=");
    localStringBuilder.append(this.hasDisplayBreathLight);
    localStringBuilder.append(", isAbnormalQuit=");
    localStringBuilder.append(this.isAbnormalQuit);
    localStringBuilder.append(", hasReportedAbnormalQuit=");
    localStringBuilder.append(this.hasReportedAbnormalQuit);
    localStringBuilder.append(", totalGrabCountForShare=");
    localStringBuilder.append(this.totalGrabCountForShare);
    localStringBuilder.append(", maxComboCountForShare=");
    localStringBuilder.append(this.maxComboCountForShare);
    localStringBuilder.append(", totalHitCountForShare=");
    localStringBuilder.append(this.totalHitCountForShare);
    localStringBuilder.append(", brushStartTsForReport=");
    localStringBuilder.append(this.brushStartTsForReport);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.UserData.UserDataItem
 * JD-Core Version:    0.7.0.1
 */