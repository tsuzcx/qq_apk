package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.graphics.PointF;
import java.util.Comparator;

class QQAVImageBeautySkinCurveAndComposeFilter$1
  implements Comparator<PointF>
{
  QQAVImageBeautySkinCurveAndComposeFilter$1(QQAVImageBeautySkinCurveAndComposeFilter paramQQAVImageBeautySkinCurveAndComposeFilter) {}
  
  public int compare(PointF paramPointF1, PointF paramPointF2)
  {
    if (paramPointF1.x > paramPointF2.x) {
      return 1;
    }
    if (paramPointF1.x == paramPointF2.x) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautySkinCurveAndComposeFilter.1
 * JD-Core Version:    0.7.0.1
 */