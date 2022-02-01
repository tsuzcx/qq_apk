package com.tencent.biz.qqcircle.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;

public class QCircleStickUtils
{
  private static float a(Point paramPoint1, Point paramPoint2, Point paramPoint3)
  {
    return (paramPoint2.x - paramPoint1.x) * (paramPoint3.y - paramPoint1.y) - (paramPoint3.x - paramPoint1.x) * (paramPoint2.y - paramPoint1.y);
  }
  
  public static QCircleStickUtils.StickAreaConfig a(QQCircleFeedBase.StKuoliePasterData paramStKuoliePasterData, Rect paramRect1, Rect paramRect2, Rect paramRect3, ImageView.ScaleType paramScaleType)
  {
    paramStKuoliePasterData = QCircleStickUtils.StickAreaConfig.a(paramStKuoliePasterData, paramRect1, paramRect2, paramRect3, paramScaleType);
    if (paramStKuoliePasterData == null)
    {
      QLog.d("Stick-QCircleStickUtils", 1, "[configStickViewBounds] config not is null.");
      return null;
    }
    float f1 = paramStKuoliePasterData.b();
    float f2 = paramStKuoliePasterData.c();
    int i;
    if (paramRect1 == null) {
      i = 0;
    } else {
      i = paramRect1.width();
    }
    int j;
    if (paramRect1 == null) {
      j = 0;
    } else {
      j = paramRect1.height();
    }
    int k;
    if (paramRect2 == null) {
      k = 0;
    } else {
      k = paramRect2.width();
    }
    int m;
    if (paramRect2 == null) {
      m = 0;
    } else {
      m = paramRect2.height();
    }
    int n;
    if (paramRect3 == null) {
      n = 0;
    } else {
      n = paramRect3.width();
    }
    int i1;
    if (paramRect3 == null) {
      i1 = 0;
    } else {
      i1 = paramRect3.height();
    }
    QLog.d("Stick-QCircleStickUtils", 1, new Object[] { "[configStickViewBounds] oWidth: ", Integer.valueOf(i), " | oHeight: ", Integer.valueOf(j), " | dWidth: ", Integer.valueOf(k), " | dHeight: ", Integer.valueOf(m), " | dx:", Float.valueOf(f1), " | dy:", Float.valueOf(f2), " | safeWidth: ", Integer.valueOf(n), " | safeHeight: ", Integer.valueOf(i1) });
    return paramStKuoliePasterData;
  }
  
  public static void a(QCircleGuideBubbleView paramQCircleGuideBubbleView, QCircleStickUtils.QCircleStickDisplayParam paramQCircleStickDisplayParam)
  {
    paramQCircleGuideBubbleView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int n = paramQCircleGuideBubbleView.getMeasuredWidth();
    int i1 = paramQCircleGuideBubbleView.getMeasuredHeight();
    int k = ViewUtils.a(5.0F);
    int m = ViewUtils.a(8.0F);
    int i5 = ViewUtils.a(20.0F);
    Point localPoint = paramQCircleStickDisplayParam.b();
    Rect localRect1 = paramQCircleStickDisplayParam.c();
    Rect localRect2 = paramQCircleStickDisplayParam.d();
    int i3 = paramQCircleStickDisplayParam.e();
    int i6 = localPoint.x;
    int i2 = localPoint.y;
    int i8 = localRect1.width();
    int i4 = localRect1.height();
    float f1 = n * 0.5F;
    int i7 = (int)f1;
    int j = i6 - i7;
    int i;
    float f2;
    if (j < k)
    {
      i = i6 - (k + i7);
      f2 = i;
      float f3 = i5 - f1;
      if (f2 < f3)
      {
        i = (int)f3;
        j = k;
      }
      else
      {
        j = k;
      }
    }
    else
    {
      i = 0;
    }
    k = i8 - (k + n);
    if (j > k)
    {
      i = i6 - (i7 + k);
      f2 = i;
      f1 -= i5;
      j = k;
      if (f2 > f1)
      {
        i = (int)f1;
        j = k;
      }
    }
    if ((localRect2.height() + i1 > i4) && (paramQCircleStickDisplayParam.f()))
    {
      k = i2 + m;
      paramQCircleGuideBubbleView.a(0, i, n);
      i = k;
    }
    else if (i2 < i4 * 0.5F)
    {
      k = i2 + (int)(localRect2.height() * 0.5F) + m;
      paramQCircleGuideBubbleView.a(0, i, n);
      i = k;
    }
    else
    {
      k = m;
      if (i3 > 0) {
        k = m + i3;
      }
      k = i2 - i1 - k;
      paramQCircleGuideBubbleView.a(1, i, n);
      i = k;
    }
    paramQCircleStickDisplayParam = (ViewGroup.MarginLayoutParams)paramQCircleGuideBubbleView.getLayoutParams();
    paramQCircleStickDisplayParam.topMargin = i;
    paramQCircleStickDisplayParam.leftMargin = j;
    QLog.d("Stick-QCircleStickUtils", 1, new Object[] { "[showBubbleView] margin top: ", Integer.valueOf(paramQCircleStickDisplayParam.topMargin), " | margin left: ", Integer.valueOf(paramQCircleStickDisplayParam.leftMargin), " | bubble width: ", Integer.valueOf(n), " | bubble height: ", Integer.valueOf(i1) });
    paramQCircleGuideBubbleView.setLayoutParams(paramQCircleStickDisplayParam);
    paramQCircleGuideBubbleView.setNeedFadeAnim(true);
    paramQCircleGuideBubbleView.a();
  }
  
  public static boolean a(Point paramPoint, QCircleStickUtils.StickArea paramStickArea)
  {
    boolean bool2 = false;
    if (paramPoint != null)
    {
      if (paramStickArea == null) {
        return false;
      }
      if ((paramStickArea.c != null) && (paramStickArea.d != null) && (paramStickArea.e != null) && (paramStickArea.f != null))
      {
        float f1 = a(paramStickArea.c, paramStickArea.d, paramPoint);
        float f2 = a(paramStickArea.e, paramStickArea.f, paramPoint);
        float f3 = a(paramStickArea.d, paramStickArea.e, paramPoint);
        float f4 = a(paramStickArea.f, paramStickArea.c, paramPoint);
        boolean bool1 = bool2;
        if (f1 * f2 >= 0.0F)
        {
          bool1 = bool2;
          if (f3 * f4 >= 0.0F) {
            bool1 = true;
          }
        }
        return bool1;
      }
      QLog.w("Stick-QCircleStickUtils", 1, "[isClickOnStick] stickArea.mStickPointTopLeft == null || stickArea.mStickPointBottomLeft == null || stickArea.mStickPointBottomRight == null || stickArea.mStickPointTopRight == null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleStickUtils
 * JD-Core Version:    0.7.0.1
 */