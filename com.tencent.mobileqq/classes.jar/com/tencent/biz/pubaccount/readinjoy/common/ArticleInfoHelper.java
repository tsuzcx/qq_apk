package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;

public class ArticleInfoHelper
{
  public static long a(BaseArticleInfo paramBaseArticleInfo)
  {
    long l1;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {
      l1 = 0L;
    }
    long l2;
    do
    {
      return l1;
      if (paramBaseArticleInfo.mSocialFeedInfo.a == null) {
        break;
      }
      l2 = paramBaseArticleInfo.mSocialFeedInfo.a.a;
      l1 = l2;
    } while (l2 != 0L);
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        return l1;
      }
      catch (NumberFormatException paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return l2;
      }
      l2 = 0L;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {}
    while ((!paramArticleInfo.mSocialFeedInfo.a()) || (RIJItemViewType.f(paramArticleInfo)) || (b(paramArticleInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a()))
    {
      if (RIJItemViewType.f((ArticleInfo)paramBaseArticleInfo)) {
        return true;
      }
      if (!b(paramBaseArticleInfo)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo) == ReadInJoyUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper
 * JD-Core Version:    0.7.0.1
 */