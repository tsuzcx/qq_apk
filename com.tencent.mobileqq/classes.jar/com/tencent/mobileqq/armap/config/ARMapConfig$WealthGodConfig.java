package com.tencent.mobileqq.armap.config;

import ably;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.List;

public class ARMapConfig$WealthGodConfig
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new ably();
  public List actSchedule;
  public String countdownTips;
  public String curfewWarning;
  public long dragRefreshAfterBegin = 1800000L;
  public String endTips;
  public long enterCloseTime;
  public long enterOpenTime;
  public String errorTips;
  public int loadingPageInfoExpireDuration;
  public int locateFrequency;
  public int locatePreCheckGap;
  public String noBeginTips;
  public int pbReqInterval;
  public int pendantDisplayDuration;
  public int pendantPreShowGap;
  public int pendantSwitcher = 1;
  public long permanentLedBeginTime;
  public long permanentLedEndTime;
  public String processTips;
  public String resMd5;
  public String resUrl;
  public int showDailyPendantPercent;
  public int showSpecialLoadingPage;
  public String specialLoadingPageWording;
  public int splashLight = 1;
  public String topBarCloudUrl;
  
  public ARMapConfig$WealthGodConfig() {}
  
  public ARMapConfig$WealthGodConfig(Parcel paramParcel)
  {
    this.enterOpenTime = paramParcel.readLong();
    this.enterCloseTime = paramParcel.readLong();
    this.permanentLedBeginTime = paramParcel.readLong();
    this.permanentLedEndTime = paramParcel.readLong();
    this.splashLight = paramParcel.readInt();
    this.pendantSwitcher = paramParcel.readInt();
    this.showSpecialLoadingPage = paramParcel.readInt();
    this.loadingPageInfoExpireDuration = paramParcel.readInt();
    this.showDailyPendantPercent = paramParcel.readInt();
    this.pendantDisplayDuration = paramParcel.readInt();
    this.pendantPreShowGap = paramParcel.readInt();
    this.locatePreCheckGap = paramParcel.readInt();
    this.locateFrequency = paramParcel.readInt();
    this.pbReqInterval = paramParcel.readInt();
    this.resUrl = paramParcel.readString();
    this.resMd5 = paramParcel.readString();
    this.processTips = paramParcel.readString();
    this.countdownTips = paramParcel.readString();
    this.noBeginTips = paramParcel.readString();
    this.endTips = paramParcel.readString();
    this.errorTips = paramParcel.readString();
    this.curfewWarning = paramParcel.readString();
    this.specialLoadingPageWording = paramParcel.readString();
    this.actSchedule = paramParcel.readArrayList(ARMapConfig.WealthGodActTime.class.getClassLoader());
    this.topBarCloudUrl = paramParcel.readString();
    this.dragRefreshAfterBegin = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WealthGodConfig::");
    localStringBuilder.append("enterOpenTime:").append(this.enterOpenTime).append(",enterCloseTime:").append(this.enterCloseTime).append("splashLight:").append(this.splashLight).append(",pendantSwitcher:").append(this.pendantSwitcher).append(",showSpecialLoadingPage:").append(this.showSpecialLoadingPage).append(",loadingPageInfoExpireDuration:").append(this.loadingPageInfoExpireDuration).append(",showDailyPendantPercent:").append(this.showDailyPendantPercent).append(",pendantDisplayDuration:").append(this.pendantDisplayDuration).append(",pendantPreShowGap:").append(this.pendantPreShowGap).append(",locatePreCheckGap:").append(this.locatePreCheckGap).append(",locateFrequency:").append(this.locateFrequency).append(",pbReqInterval:").append(this.pbReqInterval).append(",enterOpenTime").append(this.enterOpenTime).append(",enterCloseTime").append(this.enterCloseTime).append(",permanentLedBeginTime").append(this.permanentLedBeginTime).append(",permanentLedEndTime").append(this.permanentLedEndTime).append(",resUrl:").append(this.resUrl).append(",resMd5:").append(this.resMd5).append(",processTips:").append(this.processTips).append(",countdownTips:").append(this.countdownTips).append(",noBeginTips:").append(this.noBeginTips).append(",endTips:").append(this.endTips).append(",errorTips:").append(this.errorTips).append(",curfewWarning:").append(this.curfewWarning).append(",specialLoadingPageWording:").append(this.specialLoadingPageWording).append(",actSchedule:").append(this.actSchedule).append(",topBarCloudUrl:").append(this.topBarCloudUrl).append(",dragRefreshAfterBegin:").append(this.dragRefreshAfterBegin);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.enterOpenTime);
    paramParcel.writeLong(this.enterCloseTime);
    paramParcel.writeLong(this.permanentLedBeginTime);
    paramParcel.writeLong(this.permanentLedEndTime);
    paramParcel.writeInt(this.splashLight);
    paramParcel.writeInt(this.pendantSwitcher);
    paramParcel.writeInt(this.showSpecialLoadingPage);
    paramParcel.writeInt(this.loadingPageInfoExpireDuration);
    paramParcel.writeInt(this.showDailyPendantPercent);
    paramParcel.writeInt(this.pendantDisplayDuration);
    paramParcel.writeInt(this.pendantPreShowGap);
    paramParcel.writeInt(this.locatePreCheckGap);
    paramParcel.writeInt(this.locateFrequency);
    paramParcel.writeInt(this.pbReqInterval);
    paramParcel.writeString(this.resUrl);
    paramParcel.writeString(this.resMd5);
    paramParcel.writeString(this.processTips);
    paramParcel.writeString(this.countdownTips);
    paramParcel.writeString(this.noBeginTips);
    paramParcel.writeString(this.endTips);
    paramParcel.writeString(this.errorTips);
    paramParcel.writeString(this.curfewWarning);
    paramParcel.writeString(this.specialLoadingPageWording);
    paramParcel.writeList(this.actSchedule);
    paramParcel.writeString(this.topBarCloudUrl);
    paramParcel.writeLong(this.dragRefreshAfterBegin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig
 * JD-Core Version:    0.7.0.1
 */