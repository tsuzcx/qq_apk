package com.tencent.biz.qqcircle.polylike;

import android.content.Context;

public class QCirclePolyLikeViewFactory
{
  static QCirclePolyBaseLikeView a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramInt1 |= paramInt2;
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3) {
          return new QCirclePolyLikeViewFactory.1(paramContext, paramInt1);
        }
        return new QCirclePolyLikeMoreView(paramContext, paramInt1);
      }
      return new QCirclePolyLikePayView(paramContext, paramInt1);
    }
    return new QCirclePolyLikeFreeView(paramContext, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeViewFactory
 * JD-Core Version:    0.7.0.1
 */