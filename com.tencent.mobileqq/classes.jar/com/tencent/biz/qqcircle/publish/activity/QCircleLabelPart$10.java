package com.tencent.biz.qqcircle.publish.activity;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QCircleLabelPart$10
  implements Observer<HashMap<String, LocalMediaInfo>>
{
  QCircleLabelPart$10(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void a(@Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[QcirclePublish]QCircleLabelPart", 1, new Object[] { "onChanged... localMediaInfoHashMap:", paramHashMap });
    }
    QCircleLabelPart.a(this.a).a(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.10
 * JD-Core Version:    0.7.0.1
 */