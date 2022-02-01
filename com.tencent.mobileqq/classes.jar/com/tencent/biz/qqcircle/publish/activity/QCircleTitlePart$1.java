package com.tencent.biz.qqcircle.publish.activity;

import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

class QCircleTitlePart$1
  implements Observer<Boolean>
{
  QCircleTitlePart$1(QCircleTitlePart paramQCircleTitlePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (QCircleTitlePart.a(this.a) != null) {
      QCircleTitlePart.a(this.a).setEnabled(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleTitlePart.1
 * JD-Core Version:    0.7.0.1
 */