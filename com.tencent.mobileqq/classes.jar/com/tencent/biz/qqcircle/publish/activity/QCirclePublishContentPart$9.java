package com.tencent.biz.qqcircle.publish.activity;

import android.text.SpannableStringBuilder;
import java.util.Comparator;

final class QCirclePublishContentPart$9
  implements Comparator
{
  QCirclePublishContentPart$9(SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = this.a.getSpanStart(paramObject1);
    int j = this.a.getSpanStart(paramObject2);
    if (i == j) {
      return 0;
    }
    if (i > j) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.9
 * JD-Core Version:    0.7.0.1
 */