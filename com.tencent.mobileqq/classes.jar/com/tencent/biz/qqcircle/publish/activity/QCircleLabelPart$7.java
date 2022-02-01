package com.tencent.biz.qqcircle.publish.activity;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

class QCircleLabelPart$7
  implements Observer<String>
{
  QCircleLabelPart$7(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QCircleLabelPart.e(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.7
 * JD-Core Version:    0.7.0.1
 */