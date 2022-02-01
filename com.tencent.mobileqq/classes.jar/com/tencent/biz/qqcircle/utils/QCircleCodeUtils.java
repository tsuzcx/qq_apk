package com.tencent.biz.qqcircle.utils;

import java.math.BigDecimal;

public class QCircleCodeUtils
{
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return BigDecimal.valueOf(paramFloat1).equals(BigDecimal.valueOf(paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCodeUtils
 * JD-Core Version:    0.7.0.1
 */