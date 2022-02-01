package com.tencent.biz.pubaccount.readinjoy.srtUtils;

import com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater.LongContentInfoUpdater;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class ShortWithLongContentUtil
{
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    LongContentInfoUpdater localLongContentInfoUpdater = LongContentInfoUpdater.a(paramBaseArticleInfo);
    if (localLongContentInfoUpdater == null) {
      return;
    }
    localLongContentInfoUpdater.a(paramBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.ShortWithLongContentUtil
 * JD-Core Version:    0.7.0.1
 */