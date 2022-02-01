package com.tencent.biz.qqcircle.publish.activity;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;

class QCircleLbsPart$5
  implements Observer<LbsDataV2.PoiInfo>
{
  QCircleLbsPart$5(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void a(@NonNull LbsDataV2.PoiInfo paramPoiInfo)
  {
    QLog.d("[QcirclePublish]QCircleLbsPart", 1, new Object[] { "onChanged... poiInfo:", paramPoiInfo.toString() });
    QCircleLbsPart.a(this.a, paramPoiInfo, false);
    QCircleLbsPart.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.5
 * JD-Core Version:    0.7.0.1
 */