package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

public class ChannelCoverInfo
  extends Entity
  implements Cloneable
{
  public static final String FILTER_COLOR = "filterColor";
  public static final String TABLE_NAME = ChannelCoverInfo.class.getSimpleName();
  public String externalExposureBackgroundUrl = "";
  public int filterColor;
  public boolean hasFilterColor;
  public boolean isExternalExposure;
  public boolean isExternalExposurePersist;
  public boolean isReport;
  @notColumn
  public boolean isSelected;
  public long mArticleId = -1L;
  public int mChannelCoverId = -1;
  public String mChannelCoverName = "";
  public String mChannelCoverPicUrl = "";
  public String mChannelCoverSpec = "";
  public int mChannelCoverStyle;
  public String mChannelCoverSummary = "";
  public int mChannelId = -1;
  public String mChannelJumpUrl = "";
  public int mChannelType = -1;
  public int mColumnType = -1;
  public int mFollowType = -1;
  public int mFontColor = -8947849;
  public int mFrameColor = -3355444;
  public String mIconUrl = "";
  public boolean mIsTopic;
  public long mPreUpdateTime = -1L;
  public String mTipsText = "";
  public int mTipsType = -1;
  public long mUpdateTime;
  
  public ChannelCoverInfo clone()
  {
    try
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)super.clone();
      return localChannelCoverInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */