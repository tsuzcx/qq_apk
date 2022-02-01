package com.tencent.biz.qqcircle.publish.activity;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;

class QCircleLabelPart$8
  implements Observer<ArrayList<LabelInfo>>
{
  QCircleLabelPart$8(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void a(@NonNull ArrayList<LabelInfo> paramArrayList)
  {
    QLog.d("[QcirclePublish]QCircleLabelPart", 1, new Object[] { "onChanged... labelInfos:", paramArrayList.toString() });
    if (QCircleLabelPart.j(this.a) != null) {
      if (paramArrayList.size() > 0)
      {
        if (QCircleLabelPart.j(this.a).getVisibility() != 0) {
          QCircleLabelPart.j(this.a).setVisibility(0);
        }
      }
      else if (QCircleLabelPart.j(this.a).getVisibility() != 8) {
        QCircleLabelPart.j(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.8
 * JD-Core Version:    0.7.0.1
 */