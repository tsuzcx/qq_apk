package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;

public class QCircleToastUtil
{
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramLong != 10022L) && (paramLong != 10023L) && (paramLong != 10028L)) {
      QCircleToast.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public static void a(long paramLong, String paramString, int paramInt)
  {
    a(paramLong, QCircleToast.b, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleToastUtil
 * JD-Core Version:    0.7.0.1
 */