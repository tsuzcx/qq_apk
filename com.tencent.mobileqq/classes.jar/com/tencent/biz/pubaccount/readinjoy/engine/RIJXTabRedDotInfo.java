package com.tencent.biz.pubaccount.readinjoy.engine;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "Ljava/io/Serializable;", "", "algorithmIds", "", "strategyIds", "folderStatus", "articleIds", "arrivedTime", "", "channelId", "", "priorityChannelId", "exposureTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V", "getAlgorithmIds", "()Ljava/lang/String;", "getArrivedTime", "()J", "getArticleIds", "getChannelId", "()I", "getExposureTime", "setExposureTime", "(J)V", "getFolderStatus", "getPriorityChannelId", "getStrategyIds", "compareTo", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabRedDotInfo
  implements Serializable, Comparable<RIJXTabRedDotInfo>
{
  public static final RIJXTabRedDotInfo.Companion Companion = new RIJXTabRedDotInfo.Companion(null);
  public static final long INVALID_TIME = -1L;
  @NotNull
  private final String algorithmIds;
  private final long arrivedTime;
  @NotNull
  private final String articleIds;
  private final int channelId;
  private long exposureTime;
  @NotNull
  private final String folderStatus;
  private final int priorityChannelId;
  @NotNull
  private final String strategyIds;
  
  public RIJXTabRedDotInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.algorithmIds = paramString1;
    this.strategyIds = paramString2;
    this.folderStatus = paramString3;
    this.articleIds = paramString4;
    this.arrivedTime = paramLong1;
    this.channelId = paramInt1;
    this.priorityChannelId = paramInt2;
    this.exposureTime = paramLong2;
  }
  
  public int compareTo(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "other");
    return (int)(this.arrivedTime - paramRIJXTabRedDotInfo.arrivedTime);
  }
  
  @NotNull
  public final String component1()
  {
    return this.algorithmIds;
  }
  
  @NotNull
  public final String component2()
  {
    return this.strategyIds;
  }
  
  @NotNull
  public final String component3()
  {
    return this.folderStatus;
  }
  
  @NotNull
  public final String component4()
  {
    return this.articleIds;
  }
  
  public final long component5()
  {
    return this.arrivedTime;
  }
  
  public final int component6()
  {
    return this.channelId;
  }
  
  public final int component7()
  {
    return this.priorityChannelId;
  }
  
  public final long component8()
  {
    return this.exposureTime;
  }
  
  @NotNull
  public final RIJXTabRedDotInfo copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "algorithmIds");
    Intrinsics.checkParameterIsNotNull(paramString2, "strategyIds");
    Intrinsics.checkParameterIsNotNull(paramString3, "folderStatus");
    Intrinsics.checkParameterIsNotNull(paramString4, "articleIds");
    return new RIJXTabRedDotInfo(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramInt2, paramLong2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof RIJXTabRedDotInfo))
      {
        paramObject = (RIJXTabRedDotInfo)paramObject;
        if ((!Intrinsics.areEqual(this.algorithmIds, paramObject.algorithmIds)) || (!Intrinsics.areEqual(this.strategyIds, paramObject.strategyIds)) || (!Intrinsics.areEqual(this.folderStatus, paramObject.folderStatus)) || (!Intrinsics.areEqual(this.articleIds, paramObject.articleIds)) || (this.arrivedTime != paramObject.arrivedTime) || (this.channelId != paramObject.channelId) || (this.priorityChannelId != paramObject.priorityChannelId) || (this.exposureTime != paramObject.exposureTime)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final String getAlgorithmIds()
  {
    return this.algorithmIds;
  }
  
  public final long getArrivedTime()
  {
    return this.arrivedTime;
  }
  
  @NotNull
  public final String getArticleIds()
  {
    return this.articleIds;
  }
  
  public final int getChannelId()
  {
    return this.channelId;
  }
  
  public final long getExposureTime()
  {
    return this.exposureTime;
  }
  
  @NotNull
  public final String getFolderStatus()
  {
    return this.folderStatus;
  }
  
  public final int getPriorityChannelId()
  {
    return this.priorityChannelId;
  }
  
  @NotNull
  public final String getStrategyIds()
  {
    return this.strategyIds;
  }
  
  public int hashCode()
  {
    int m = 0;
    String str = this.algorithmIds;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.strategyIds;
      if (str == null) {
        break label161;
      }
      j = str.hashCode();
      label37:
      str = this.folderStatus;
      if (str == null) {
        break label166;
      }
    }
    label161:
    label166:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.articleIds;
      if (str != null) {
        m = str.hashCode();
      }
      long l = this.arrivedTime;
      int n = (int)(l ^ l >>> 32);
      int i1 = this.channelId;
      int i2 = this.priorityChannelId;
      l = this.exposureTime;
      return (((((k + (j + i * 31) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + (int)(l ^ l >>> 32);
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  public final void setExposureTime(long paramLong)
  {
    this.exposureTime = paramLong;
  }
  
  @NotNull
  public String toString()
  {
    return "RIJXTabRedDotInfo(algorithmIds=" + this.algorithmIds + ", strategyIds=" + this.strategyIds + ", folderStatus=" + this.folderStatus + ", articleIds=" + this.articleIds + ", arrivedTime=" + this.arrivedTime + ", channelId=" + this.channelId + ", priorityChannelId=" + this.priorityChannelId + ", exposureTime=" + this.exposureTime + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabRedDotInfo
 * JD-Core Version:    0.7.0.1
 */