package com.tencent.biz.qqcircle.publish.activity;

import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;

class QCirclePublishSharePart$1
  implements Observer<Boolean>
{
  QCirclePublishSharePart$1(QCirclePublishSharePart paramQCirclePublishSharePart) {}
  
  public void a(@NonNull Boolean paramBoolean)
  {
    QCirclePublishSharePart.a(this.a).setChecked(paramBoolean.booleanValue());
    QCirclePluginConfig.a().d(paramBoolean.booleanValue());
    int i;
    if (paramBoolean.booleanValue()) {
      i = 6;
    } else {
      i = 7;
    }
    QCirclePublishReport.a(15, i, 0, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishSharePart.1
 * JD-Core Version:    0.7.0.1
 */