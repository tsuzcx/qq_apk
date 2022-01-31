package com.tencent.biz.pubaccount.readinjoy.struct;

import java.io.Serializable;

public class LebaKDCellInfo
  implements Serializable
{
  public long articleID;
  public String extraInfo;
  public int templateID;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" articleID:").append(this.articleID);
    localStringBuilder.append(" templateID:").append(this.templateID);
    localStringBuilder.append(" extraInfo:").append(this.extraInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo
 * JD-Core Version:    0.7.0.1
 */