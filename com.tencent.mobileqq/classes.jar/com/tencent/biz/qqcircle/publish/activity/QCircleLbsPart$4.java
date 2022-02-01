package com.tencent.biz.qqcircle.publish.activity;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiAdapter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.List;

class QCircleLbsPart$4
  implements Observer<List<LbsDataV2.PoiInfo>>
{
  QCircleLbsPart$4(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void a(@Nullable List<LbsDataV2.PoiInfo> paramList)
  {
    QLog.d("[QcirclePublish]QCircleLbsPart", 1, "onChanged... mPoiLiveData:");
    QCircleLbsPart.c(this.a).setVisibility(0);
    QCircleLbsPart.a(this.a).a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.4
 * JD-Core Version:    0.7.0.1
 */