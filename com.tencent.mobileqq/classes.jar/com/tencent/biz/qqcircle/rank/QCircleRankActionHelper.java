package com.tencent.biz.qqcircle.rank;

import java.util.HashSet;

public class QCircleRankActionHelper
{
  public static final HashSet<Integer> MULTI_ACTION_SET = new QCircleRankActionHelper.2();
  public static final HashSet<Integer> NEGATIVE_ACTION_SET = new QCircleRankActionHelper.3();
  public static final HashSet<Integer> ONE_ACTION_SET = new QCircleRankActionHelper.1();
  
  public static boolean isMultiAction(int paramInt)
  {
    return MULTI_ACTION_SET.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean isNegativeAction(int paramInt)
  {
    return NEGATIVE_ACTION_SET.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean isOneAction(int paramInt)
  {
    return ONE_ACTION_SET.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.QCircleRankActionHelper
 * JD-Core Version:    0.7.0.1
 */