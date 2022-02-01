package com.tencent.biz.pubaccount.readinjoy.struct;

import rfq;

public class TabChannelCoverInfo
  extends ChannelCoverInfo
{
  public static int TYPE_CHANNEL_MY_CONFIG = 700;
  public static int TYPE_CHANNEL_RECOMMEND_CONFIG = 701;
  public long bid;
  public int boldFont;
  public long channelConfigType;
  public int dynamicSort;
  public long endTimestamp;
  public int fontsColor;
  public int frameColor;
  public int onlyCover;
  public String proxy;
  public int reason;
  public rfq redPoint;
  public String redPointJson;
  public long sectionId;
  public int seq;
  public int showCover;
  public int showIcon;
  public long startTimestamp;
  public String webUrl;
  
  public TabChannelCoverInfo() {}
  
  public TabChannelCoverInfo(int paramInt, String paramString)
  {
    this.mChannelCoverId = paramInt;
    this.mChannelCoverName = paramString;
    this.reason = 1;
  }
  
  public TabChannelCoverInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.mChannelCoverId = paramInt1;
    this.mChannelCoverName = paramString;
    this.reason = paramInt2;
  }
  
  public TabChannelCoverInfo(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.mChannelCoverId = paramInt1;
    this.mChannelCoverName = paramString1;
    this.reason = paramInt2;
    this.mChannelCoverIcon = paramString2;
  }
  
  public TabChannelCoverInfo clone()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)super.clone();
    if (this.redPoint != null)
    {
      localTabChannelCoverInfo.redPoint = new rfq();
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = this.redPoint.jdField_a_of_type_Boolean;
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Long = this.redPoint.jdField_b_of_type_Long;
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Long = this.redPoint.jdField_a_of_type_Long;
      localTabChannelCoverInfo.redPoint.jdField_c_of_type_Long = this.redPoint.jdField_c_of_type_Long;
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Int = this.redPoint.jdField_a_of_type_Int;
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString = this.redPoint.jdField_a_of_type_JavaLangString;
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Int = this.redPoint.jdField_b_of_type_Int;
      localTabChannelCoverInfo.redPoint.jdField_c_of_type_Int = this.redPoint.jdField_c_of_type_Int;
    }
    return localTabChannelCoverInfo;
  }
  
  public String shortLogString()
  {
    return "TabChannelCoverInfo {channelConfigType = " + this.channelConfigType + "mChannelCoverId = " + this.mChannelCoverId + ", mChannelCoverName = " + this.mChannelCoverName + ", reason = " + this.reason + ", seq = " + this.seq + "}";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TabChannelCoverInfo{redPoint=");
    if (this.redPoint != null) {}
    for (String str = this.redPoint.toString();; str = "") {
      return str + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", reason=" + this.reason + ", bold_font=" + this.boldFont + ", show_icon=" + this.showIcon + ", show_cover=" + this.showCover + ", frame_color=" + this.frameColor + ", fonts_color=" + this.fontsColor + ", web_url='" + this.webUrl + '\'' + ", proxy='" + this.proxy + '\'' + ", channelConfigType=" + this.channelConfigType + ", seq=" + this.seq + ", mChannelId=" + this.mChannelId + ", mChannelCoverId=" + this.mChannelCoverId + ", mChannelCoverName='" + this.mChannelCoverName + '\'' + ", mChannelCoverStyle=" + this.mChannelCoverStyle + ", mChannelCoverSummary='" + this.mChannelCoverSummary + '\'' + ", mChannelCoverPicUrl='" + this.mChannelCoverPicUrl + '\'' + ", mChannelJumpUrl='" + this.mChannelJumpUrl + '\'' + ", mArticleId=" + this.mArticleId + ", mChannelType=" + this.mChannelType + ", mChannelCoverSpec='" + this.mChannelCoverSpec + '\'' + ", mFollowType=" + this.mFollowType + ", mColumnType=" + this.mColumnType + ", mTipsType=" + this.mTipsType + ", mTipsText='" + this.mTipsText + '\'' + ", mPreUpdateTime=" + this.mPreUpdateTime + ", mUpdateTime=" + this.mUpdateTime + ", isReport=" + this.isReport + ", mIconUrl='" + this.mIconUrl + '\'' + ", mFontColor=" + this.mFontColor + ", mFrameColor=" + this.mFrameColor + ", isExternalExposure=" + this.isExternalExposure + ", externalExposureBackgroundUrl='" + this.externalExposureBackgroundUrl + '\'' + ", isExternalExposurePersist=" + this.isExternalExposurePersist + ", hasFilterColor=" + this.hasFilterColor + ", filterColor=" + this.filterColor + ", mIsTopic=" + this.mIsTopic + ", isSelected=" + this.isSelected + ", sectionId=" + this.sectionId + ", bid=" + this.bid + ", mChannelCoverIcon=" + this.mChannelCoverIcon + ", mChannelVersion=" + this.mChannelVersion + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */