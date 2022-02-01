package com.tencent.biz.qqcircle.rank;

import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class QCircleRawFeedItem
{
  private Map<String, String> mBusiTranparentMap;
  private String mCateId;
  private String mExtend;
  private transient FeedBlockData mFeedData;
  private String mFeedId;
  private int mPreIndex;
  private BigDecimal mPreRecommendScore;
  private BigDecimal mReRankScore;
  private String mSubCateId;
  private String mUin;
  
  public Map<String, String> getBusiTranparent()
  {
    return this.mBusiTranparentMap;
  }
  
  public String getCateId()
  {
    return this.mCateId;
  }
  
  public String getExtend()
  {
    return this.mExtend;
  }
  
  public FeedBlockData getFeedData()
  {
    return this.mFeedData;
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public int getPreIndex()
  {
    return this.mPreIndex;
  }
  
  public BigDecimal getPreRecommendScore()
  {
    return this.mPreRecommendScore;
  }
  
  public BigDecimal getReRankScore()
  {
    return this.mReRankScore;
  }
  
  public String getSubCateId()
  {
    return this.mSubCateId;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public void setBusiTranparent(String paramString1, String paramString2)
  {
    if (this.mBusiTranparentMap == null) {
      this.mBusiTranparentMap = new HashMap();
    }
    this.mBusiTranparentMap.put(paramString1, paramString2);
  }
  
  public void setCateId(String paramString)
  {
    this.mCateId = paramString;
  }
  
  public void setExtend(String paramString)
  {
    this.mExtend = paramString;
  }
  
  public void setFeedData(FeedBlockData paramFeedBlockData)
  {
    this.mFeedData = paramFeedBlockData;
  }
  
  public void setFeedId(String paramString)
  {
    this.mFeedId = paramString;
  }
  
  public void setPreIndex(int paramInt)
  {
    this.mPreIndex = paramInt;
  }
  
  public void setPreRecommendScore(BigDecimal paramBigDecimal)
  {
    this.mPreRecommendScore = paramBigDecimal;
  }
  
  public void setReRankScore(BigDecimal paramBigDecimal)
  {
    this.mReRankScore = paramBigDecimal;
  }
  
  public void setSubCateId(String paramString)
  {
    this.mSubCateId = paramString;
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cateId:");
    localStringBuilder.append(getCateId());
    localStringBuilder.append(" subCateId:");
    localStringBuilder.append(getSubCateId());
    localStringBuilder.append("\npreScore:");
    localStringBuilder.append(getPreRecommendScore());
    localStringBuilder.append("\nreRankScore:");
    localStringBuilder.append(getReRankScore());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.QCircleRawFeedItem
 * JD-Core Version:    0.7.0.1
 */