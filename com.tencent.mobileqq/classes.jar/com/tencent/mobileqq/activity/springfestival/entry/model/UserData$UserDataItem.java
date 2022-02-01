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
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (UserDataItem)paramObject;
    return this.activityId.equals(paramObject.activityId);
  }
  
  public String toString()
  {
    return "UserDataItem{activityId='" + this.activityId + '\'' + ", startGrabTs=" + this.startGrabTs + ", lastReqGrabTs=" + this.lastReqGrabTs + ", leftCountDownDuration=" + this.leftCountDownDuration + ", isHit=" + this.isHit + ", hasClickCloseBtn=" + this.hasClickCloseBtn + ", pendantCloseType=" + this.pendantCloseType + ", hasDisplayBreathLight=" + this.hasDisplayBreathLight + ", isAbnormalQuit=" + this.isAbnormalQuit + ", hasReportedAbnormalQuit=" + this.hasReportedAbnormalQuit + ", totalGrabCountForShare=" + this.totalGrabCountForShare + ", maxComboCountForShare=" + this.maxComboCountForShare + ", totalHitCountForShare=" + this.totalHitCountForShare + ", brushStartTsForReport=" + this.brushStartTsForReport + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.UserData.UserDataItem
 * JD-Core Version:    0.7.0.1
 */