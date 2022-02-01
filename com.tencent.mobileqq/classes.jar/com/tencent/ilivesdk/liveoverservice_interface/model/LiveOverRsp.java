package com.tencent.ilivesdk.liveoverservice_interface.model;

import java.util.Objects;

public class LiveOverRsp
{
  public String anchorNickname;
  public long anchorUin;
  public String headLogoUrl;
  public int liveTimeSecond;
  public long mOrderAmount;
  public long mOrderCount;
  public int watchCount;
  
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
      paramObject = (LiveOverRsp)paramObject;
      return (this.anchorUin == paramObject.anchorUin) && (this.watchCount == paramObject.watchCount) && (this.liveTimeSecond == paramObject.liveTimeSecond) && (Objects.equals(this.anchorNickname, paramObject.anchorNickname)) && (Objects.equals(this.headLogoUrl, paramObject.headLogoUrl));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Long.valueOf(this.anchorUin), this.anchorNickname, this.headLogoUrl, Integer.valueOf(this.watchCount), Integer.valueOf(this.liveTimeSecond) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiveOverRsp{anchorUin=");
    localStringBuilder.append(this.anchorUin);
    localStringBuilder.append(", anchorNickname='");
    localStringBuilder.append(this.anchorNickname);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headLogoUrl='");
    localStringBuilder.append(this.headLogoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", watchCount=");
    localStringBuilder.append(this.watchCount);
    localStringBuilder.append(", liveTime=");
    localStringBuilder.append(this.liveTimeSecond);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.liveoverservice_interface.model.LiveOverRsp
 * JD-Core Version:    0.7.0.1
 */