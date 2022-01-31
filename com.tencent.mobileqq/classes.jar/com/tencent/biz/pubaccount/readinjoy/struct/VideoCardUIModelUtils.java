package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class VideoCardUIModelUtils
{
  private static IVideoCardUIModel a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new CommonVideoCardUIModel(paramBaseArticleInfo);
    }
    return new UGCVideoCardUIModel(paramBaseArticleInfo);
  }
  
  public static IVideoCardUIModel a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (a(paramBaseArticleInfo)) {
      return a(1, paramBaseArticleInfo);
    }
    return a(0, paramBaseArticleInfo);
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ReadInJoyBaseAdapter.o((ArticleInfo)paramBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.VideoCardUIModelUtils
 * JD-Core Version:    0.7.0.1
 */