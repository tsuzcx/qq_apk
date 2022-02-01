package com.tencent.biz.qqcircle.publish.activity;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;

class QCircleLbsPart$6
  implements Observer<LbsDataV2.PoiInfo>
{
  QCircleLbsPart$6(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void a(@Nullable LbsDataV2.PoiInfo paramPoiInfo)
  {
    String str;
    if (paramPoiInfo == null) {
      str = "null";
    } else {
      str = paramPoiInfo.poiId;
    }
    QLog.d("[QcirclePublish]QCircleLbsPart", 1, new Object[] { "[onChanged] mDefSelectPoiDataLiveData poiInfo: ", str });
    if ((paramPoiInfo != null) && (paramPoiInfo.poiId != null) && (!paramPoiInfo.poiId.equals("invalide_poi_id")) && (QCircleLbsPart.h(this.a)) && (QCircleLbsPart.a(this.a, paramPoiInfo))) {
      QCircleLbsPart.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.6
 * JD-Core Version:    0.7.0.1
 */