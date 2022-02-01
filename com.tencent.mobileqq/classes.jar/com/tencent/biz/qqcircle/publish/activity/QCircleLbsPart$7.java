package com.tencent.biz.qqcircle.publish.activity;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiAdapter;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QCircleLbsPart$7
  implements Observer<HashMap<String, LocalMediaInfo>>
{
  QCircleLbsPart$7(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void a(@Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    QLog.d("[QcirclePublish]QCircleLbsPart", 1, "onChanged... localMediaInfoHashMap");
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (QCircleLbsPart.j(this.a)))
    {
      QCircleLbsPart.a(this.a, true);
      QCircleLbsPart.b(this.a).a(paramHashMap, true);
      return;
    }
    QCircleLbsPart.a(this.a).a();
    QCircleLbsPart.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.7
 * JD-Core Version:    0.7.0.1
 */