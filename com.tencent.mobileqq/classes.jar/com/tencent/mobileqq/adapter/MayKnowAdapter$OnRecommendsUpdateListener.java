package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.List;

public abstract interface MayKnowAdapter$OnRecommendsUpdateListener
  extends MayKnowAdapter.OnRecommendsCanceledListener
{
  public abstract void a(String paramString);
  
  public abstract void a(List<MayKnowRecommend> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsUpdateListener
 * JD-Core Version:    0.7.0.1
 */