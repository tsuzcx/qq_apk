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
  public boolean forceDomain;
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
    this.forceDomain = false;
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
    boolean bool2 = false;
    this.forceDomain = false;
    if (paramParcel == null) {
      return;
    }
    this.id = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.allowProxy = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.useConfigApn = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.enableBackupIP = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.forceDomain = bool1;
    this.mIpInfo = ((IPInfo)paramParcel.readParcelable(DownloadGlobalStrategy.access$000().getClassLoader()));
    this.mIpTimestamp = paramParcel.readLong();
  }
  
  public DownloadGlobalStrategy$StrategyInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(0, paramBoolean1, paramBoolean2, paramBoolean3, false);
  }
  
  public static int compare(StrategyInfo paramStrategyInfo1, StrategyInfo paramStrategyInfo2)
  {
    float f4 = 0.0F;
    float f3 = 0.0F;
    if (paramStrategyInfo1 != null)
    {
      DownloadResult localDownloadResult = paramStrategyInfo1.result;
      if ((localDownloadResult != null) && (localDownloadResult.getProcess().duration > 0L))
      {
        if (paramStrategyInfo1.result.getContent().size > 0L) {
          f1 = (float)paramStrategyInfo1.result.getContent().size;
        } else {
          f1 = 0.0F;
        }
        f1 /= (float)paramStrategyInfo1.result.getProcess().duration;
        break label85;
      }
    }
    float f1 = 0.0F;
    label85:
    float f2 = f4;
    if (paramStrategyInfo2 != null)
    {
      paramStrategyInfo1 = paramStrategyInfo2.result;
      f2 = f4;
      if (paramStrategyInfo1 != null)
      {
        f2 = f4;
        if (paramStrategyInfo1.getProcess().duration > 0L)
        {
          f2 = f3;
          if (paramStrategyInfo2.result.getContent().size > 0L) {
            f2 = (float)paramStrategyInfo2.result.getContent().size;
          }
          f2 /= (float)paramStrategyInfo2.result.getProcess().duration;
        }
      }
    }
    paramStrategyInfo1 = new StringBuilder();
    paramStrategyInfo1.append("speed1:");
    paramStrategyInfo1.append(f1);
    paramStrategyInfo1.append(" speed2:");
    paramStrategyInfo1.append(f2);
    QDLog.w("DownloadGlobalStrategy", paramStrategyInfo1.toString());
    return (int)(f1 - f2);
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
    if (equalValue(DownloadGlobalStrategy.Strategy_DomainDirect))
    {
      this.id = DownloadGlobalStrategy.Strategy_DomainDirect.id;
      return;
    }
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
    if (equalValue(DownloadGlobalStrategy.Strategy_DOMAIN_FORCE)) {
      this.id = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id;
    }
  }
  
  public StrategyInfo clone()
  {
    StrategyInfo localStrategyInfo = new StrategyInfo(this.id, this.allowProxy, this.useConfigApn, this.enableBackupIP);
    int i = this.id;
    if (i > 0) {
      localStrategyInfo.id = i;
    }
    return localStrategyInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equalValue(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof StrategyInfo)))
    {
      paramObject = (StrategyInfo)paramObject;
      return (paramObject.forceDomain == this.forceDomain) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.mIpInfo, this.mIpInfo));
    }
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
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof StrategyInfo)))
    {
      paramObject = (StrategyInfo)paramObject;
      return (paramObject.id == this.id) && (paramObject.allowProxy == this.allowProxy) && (paramObject.enableBackupIP == this.enableBackupIP) && (paramObject.useConfigApn == this.useConfigApn) && (equalWith(paramObject.mIpInfo, this.mIpInfo));
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(id:");
    localStringBuilder.append(this.id);
    localStringBuilder.append(";");
    localStringBuilder.append(this.allowProxy);
    localStringBuilder.append(";");
    localStringBuilder.append(this.useConfigApn);
    localStringBuilder.append(";");
    localStringBuilder.append(this.enableBackupIP);
    localStringBuilder.append(";");
    Object localObject = this.mIpInfo;
    if (localObject != null) {
      localObject = ((IPInfo)localObject).toString();
    } else {
      localObject = "N/A";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    return new String(localStringBuilder.toString());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo
 * JD-Core Version:    0.7.0.1
 */