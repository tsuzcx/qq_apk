package com.tencent.biz.qqcircle.fragments.troop;

import com.tencent.biz.qqcircle.beans.QCircleAggregationBean;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

class QCircleTroopAggregationBodyPart$3
  implements MultiViewBlock.OnLoadDataDelegate
{
  QCircleTroopAggregationBodyPart$3(QCircleTroopAggregationBodyPart paramQCircleTroopAggregationBodyPart) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    QCircleTroopAggregationBodyPart.c(this.a);
    if ((QCircleTroopAggregationBodyPart.d(this.a) != null) && (QCircleTroopAggregationBodyPart.e(this.a) != null)) {
      QCircleTroopAggregationBodyPart.e(this.a).a(QCircleTroopAggregationBodyPart.d(this.a).getTroopUin(), paramLoadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationBodyPart.3
 * JD-Core Version:    0.7.0.1
 */