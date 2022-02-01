package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.module.base.QDLog;

public class DownloadGlobalStrategy$StrategyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StrategyInfo> CREATOR = new DownloadGlobalStrategy.StrategyInfo.1();
  public boolean allowProxy;
  public boolean enableBackupIP;
  public boolean forceDomain = false;
  public int id;
  private IPInfo mIpInfo;
  private long mIpTimestamp;
  public DownloadResult result;
  public boolean useConfigApn;
  
  public DownloadGlobalStrategy$StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, false);
  }
  
  public DownloadGlobalStrategy$StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.id = paramInt;
    this.allowProxy = paramBoolean1;
    this.useConfigApn = paramBoolean2;
    this.enableBackupIP = paramBoolean3;
    this.forceDomain = paramBoolean4;
    this.mIpTimestamp = System.currentTimeMillis();
    filter();
    initID();
  }
  
  public DownloadGlobalStrategy$StrategyInfo(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.id = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.allowProxy = bool1;
      if (paramParcel.readInt() != 1) {
        break label115;
      }
      bool1 = true;
      label49:
      this.useConfigApn = bool1;
      if (paramParcel.readInt() != 1) {
        break label120;
      }
      bool1 = true;
      label64:
      this.enableBackupIP = bool1;
      if (paramParcel.readInt() != 1) {
        break label125;
      }
    }
    label115:
    label120:
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.forceDomain = bool1;
      this.mIpInfo = ((IPInfo)paramParcel.readParcelable(DownloadGlobalStrategy.access$000().getClassLoader()));
      this.mIpTimestamp = paramParcel.readLong();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label49;
      bool1 = false;
      break label64;
    }
  }
  
  public DownloadGlobalStrategy$StrategyInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(0, paramBoolean1, paramBoolean2, paramBoolean3, false);
  }
  
  public static int compare(StrategyInfo paramStrategyInfo1, StrategyInfo paramStrategyInfo2)
  {
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f1;
    if ((paramStrategyInfo1 != null) && (paramStrategyInfo1.result != null) && (paramStrategyInfo1.result.getProcess().duration > 0L)) {
      if (paramStrategyInfo1.result.getContent().size > 0L) {
        f1 = (float)paramStrategyInfo1.result.getContent().size;
      }
    }
    for (f1 /= (float)paramStrategyInfo1.result.getProcess().duration;; f1 = 0.0F)
    {
      float f2 = f4;
      if (paramStrategyInfo2 != null)
      {
        f2 = f4;
        if (paramStrategyInfo2.result != null)
        {
          f2 = f4;
          if (paramStrategyInfo2.result.getProcess().duration > 0L)
          {
            f2 = f3;
            if (paramStrategyInfo2.result.getContent().size > 0L) {
              f2 = (float)paramStrategyInfo2.result.getContent().size;
            }
            f2 /= (float)paramStrategyInfo2.result.getProcess().duration;
          }
        }
      }
      QDLog.w("DownloadGlobalStrategy", "speed1:" + f1 + " speed2:" + f2);
      return (int)(f1 - f2);
      f1 = 0.0F;
      break;
    }
  }
  
  private void filter()
  {
    if (this.enableBackupIP) {
      this.allowProxy = false;
    }
    if (!this.allowProxy) {
      this.useConfigApn = false;
    }
  }
  
  private void initID()
  {
    if (equalValue(DownloadGlobalStrategy.Strategy_DomainDirect)) {
      this.id = DownloadGlobalStrategy.Strategy_DomainDirect.id;
    }
    do
    {
      return;
      if (equalValue(DownloadGlobalStrategy.Strategy_DomainProxy_CON))
      {
        this.id = DownloadGlobalStrategy.Strategy_DomainProxy_CON.id;
        return;
      }
      if (equalValue(DownloadGlobalStrategy.Strategy_DomainProxy_SYS))
      {
        this.id = DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id;
        return;
      }
      if (equalValue(DownloadGlobalStrategy.Strategy_BACKUPIP))
      {
        this.id = DownloadGlobalStrategy.Strategy_BACKUPIP.id;
        return;
      }
    } while (!equalValue(DownloadGlobalStrategy.Strategy_DOMAIN_FORCE));
    this.id = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id;
  }
  
  public StrategyInfo clone()
  {
    StrategyInfo localStrategyInfo = new StrategyInfo(this.id, this.allowProxy, this.useConfigApn, this.enableBackupIP);
    if (this.id > 0) {
      localStrategyInfo.id = this.id;
    }
    return localStrategyInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equalValue(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
        break;
      }
      paramObject = (StrategyInfo)paramObject;
    } while ((paramObject.forceDomain == this.forceDomain) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.mIpInfo, this.mIpInfo)));
    return false;
    return false;
  }
  
  public boolean equalWith(IPInfo paramIPInfo1, IPInfo paramIPInfo2)
  {
    if (paramIPInfo1 != null) {
      return paramIPInfo1.equals(paramIPInfo2);
    }
    return paramIPInfo2 == null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
        break;
      }
      paramObject = (StrategyInfo)paramObject;
    } while ((paramObject.id == this.id) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.mIpInfo, this.mIpInfo)));
    return false;
    return false;
  }
  
  public IPInfo getIPInfo()
  {
    return this.mIpInfo;
  }
  
  public long getIPValidTime()
  {
    if (this.id == DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id) {
      return 1800000L;
    }
    return 3600000L;
  }
  
  public boolean isIPValid()
  {
    long l1 = getIPValidTime();
    long l2 = System.currentTimeMillis() - this.mIpTimestamp;
    return (l2 >= 0L) && (l2 <= l1);
  }
  
  public void setIPInfo(IPInfo paramIPInfo)
  {
    this.mIpInfo = paramIPInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("(id:").append(this.id).append(";").append(this.allowProxy).append(";").append(this.useConfigApn).append(";").append(this.enableBackupIP).append(";");
    if (this.mIpInfo != null) {}
    for (String str = this.mIpInfo.toString();; str = "N/A") {
      return new String(str + ")");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeInt(this.id);
    if (this.allowProxy)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.useConfigApn) {
        break label94;
      }
      paramInt = 1;
      label38:
      paramParcel.writeInt(paramInt);
      if (!this.enableBackupIP) {
        break label99;
      }
      paramInt = 1;
      label52:
      paramParcel.writeInt(paramInt);
      if (!this.forceDomain) {
        break label104;
      }
    }
    label94:
    label99:
    label104:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(this.mIpInfo, 0);
      paramParcel.writeLong(this.mIpTimestamp);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label38;
      paramInt = 0;
      break label52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo
 * JD-Core Version:    0.7.0.1
 */