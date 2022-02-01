package com.tencent.biz.qqcircle.publish.activity;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.model.DynamicArrayList;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;

class QCircleMediaPart$1
  implements Observer<DynamicArrayList<String>>
{
  QCircleMediaPart$1(QCircleMediaPart paramQCircleMediaPart) {}
  
  public void a(@Nullable DynamicArrayList<String> paramDynamicArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[QcirclePublish]QCircleMediaPart", 1, new Object[] { "onChanged... list:", paramDynamicArrayList });
    }
    if (paramDynamicArrayList != null) {}
    try
    {
      if (paramDynamicArrayList.size() == 0)
      {
        QCircleMediaPart.a(this.a).setVisibility(8);
        QCircleMediaPart.b(this.a).setVisibility(8);
        QCircleMediaPart.c(this.a).setVisibility(8);
        QCircleMediaPart.d(this.a).setVisibility(8);
        QCircleMediaPart.e(this.a).setVisibility(8);
        QCircleMediaPart.f(this.a).setVisibility(0);
        QCircleMediaPart.g(this.a).setVisibility(0);
        return;
      }
    }
    catch (Exception paramDynamicArrayList)
    {
      QLog.e("[QcirclePublish]QCircleMediaPart", 1, paramDynamicArrayList, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleMediaPart.1
 * JD-Core Version:    0.7.0.1
 */