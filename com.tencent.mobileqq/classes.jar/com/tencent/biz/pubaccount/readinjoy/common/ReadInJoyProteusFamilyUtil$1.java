package com.tencent.biz.pubaccount.readinjoy.common;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

class ReadInJoyProteusFamilyUtil$1
  implements Comparator<Pair<Long, Pair<View, BaseArticleInfo>>>
{
  ReadInJoyProteusFamilyUtil$1(ReadInJoyProteusFamilyUtil paramReadInJoyProteusFamilyUtil) {}
  
  public int a(Pair<Long, Pair<View, BaseArticleInfo>> paramPair1, Pair<Long, Pair<View, BaseArticleInfo>> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.1
 * JD-Core Version:    0.7.0.1
 */