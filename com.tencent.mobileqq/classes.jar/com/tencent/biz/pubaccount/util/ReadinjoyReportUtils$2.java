package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.Comparator;

final class ReadinjoyReportUtils$2
  implements Comparator<ArticleInfo>
{
  public int a(ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if (paramArticleInfo1.mRecommendSeq == paramArticleInfo2.mRecommendSeq) {
      return 0;
    }
    if (paramArticleInfo1.mRecommendSeq > paramArticleInfo2.mRecommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.2
 * JD-Core Version:    0.7.0.1
 */