package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.Comparator;

class RIJArticleInfoRepo$12
  implements Comparator<ArticleInfo>
{
  RIJArticleInfoRepo$12(RIJArticleInfoRepo paramRIJArticleInfoRepo) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.12
 * JD-Core Version:    0.7.0.1
 */