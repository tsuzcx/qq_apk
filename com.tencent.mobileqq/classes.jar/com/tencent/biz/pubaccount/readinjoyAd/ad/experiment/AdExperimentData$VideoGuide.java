package com.tencent.biz.pubaccount.readinjoyAd.ad.experiment;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/experiment/AdExperimentData$VideoGuide;", "", "secondStateTime", "", "thirdStateTime", "(II)V", "getSecondStateTime", "()I", "getThirdStateTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdExperimentData$VideoGuide
{
  private final int a;
  private final int b;
  
  public AdExperimentData$VideoGuide()
  {
    this(0, 0, 3, null);
  }
  
  public AdExperimentData$VideoGuide(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof VideoGuide))
      {
        paramObject = (VideoGuide)paramObject;
        if ((this.a != paramObject.a) || (this.b != paramObject.b)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 31 + this.b;
  }
  
  @NotNull
  public String toString()
  {
    return "VideoGuide(secondStateTime=" + this.a + ", thirdStateTime=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData.VideoGuide
 * JD-Core Version:    0.7.0.1
 */