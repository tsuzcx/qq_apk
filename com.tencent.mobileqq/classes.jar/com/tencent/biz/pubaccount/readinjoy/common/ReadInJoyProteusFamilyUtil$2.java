package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

final class ReadInJoyProteusFamilyUtil$2
  implements Comparator<Pair<Long, BaseArticleInfo>>
{
  public int a(Pair<Long, BaseArticleInfo> paramPair1, Pair<Long, BaseArticleInfo> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.2
 * JD-Core Version:    0.7.0.1
 */