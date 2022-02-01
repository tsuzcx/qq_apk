package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import pha;

public class ArticleExposureInfo
  extends Entity
  implements Comparable<ArticleExposureInfo>
{
  public static final String TABLE_NAME = ArticleExposureInfo.class.getSimpleName();
  public long algorithmID;
  public long articleID;
  public long channelID;
  public long exposureTime;
  public int feedsType;
  public String rowkey;
  public String title;
  
  public static ArticleExposureInfo createExposureInfoFromArticle(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return null;
    }
    ArticleExposureInfo localArticleExposureInfo = new ArticleExposureInfo();
    localArticleExposureInfo.rowkey = paramBaseArticleInfo.innerUniqueID;
    localArticleExposureInfo.algorithmID = paramBaseArticleInfo.mAlgorithmID;
    localArticleExposureInfo.articleID = paramBaseArticleInfo.mArticleID;
    localArticleExposureInfo.exposureTime = NetConnInfoCenter.getServerTimeMillis();
    localArticleExposureInfo.feedsType = pha.a(paramBaseArticleInfo);
    localArticleExposureInfo.channelID = paramBaseArticleInfo.mChannelID;
    localArticleExposureInfo.title = paramBaseArticleInfo.mTitle;
    return localArticleExposureInfo;
  }
  
  public int compareTo(ArticleExposureInfo paramArticleExposureInfo)
  {
    if (paramArticleExposureInfo == null) {}
    do
    {
      return 1;
      if (this.exposureTime > paramArticleExposureInfo.exposureTime) {
        return -1;
      }
    } while (this.exposureTime < paramArticleExposureInfo.exposureTime);
    return 0;
  }
  
  public String toString()
  {
    return "ArticleExposureInfo{channelID=" + this.channelID + ", exposureTime=" + this.exposureTime + ", rowkey='" + this.rowkey + '\'' + ", articleID='" + this.articleID + '\'' + ", feedsType=" + this.feedsType + ", algorithmID=" + this.algorithmID + ", title=" + this.title + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo
 * JD-Core Version:    0.7.0.1
 */