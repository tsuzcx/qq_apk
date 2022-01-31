package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.PointF;
import java.util.Comparator;

class QQAVImageToneCurveFilter$2
  implements Comparator<PointF>
{
  QQAVImageToneCurveFilter$2(QQAVImageToneCurveFilter paramQQAVImageToneCurveFilter) {}
  
  public int compare(PointF paramPointF1, PointF paramPointF2)
  {
    if (paramPointF1.x < paramPointF2.x) {
      return -1;
    }
    if (paramPointF1.x > paramPointF2.x) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter.2
 * JD-Core Version:    0.7.0.1
 */