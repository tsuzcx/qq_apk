package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import java.util.Comparator;

class VideoArticleModule$6
  implements Comparator<WeiShiVideoArticleInfo>
{
  VideoArticleModule$6(VideoArticleModule paramVideoArticleModule) {}
  
  public int a(WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo1, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo2)
  {
    if (paramWeiShiVideoArticleInfo1.recommendSeq == paramWeiShiVideoArticleInfo2.recommendSeq) {
      return 0;
    }
    if (paramWeiShiVideoArticleInfo1.recommendSeq > paramWeiShiVideoArticleInfo2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.6
 * JD-Core Version:    0.7.0.1
 */