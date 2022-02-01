package com.tencent.biz.qqcircle.fragments.troop;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.beans.ResponseBean;

class QCircleTroopAggregationBodyPart$4
  implements Observer<ResponseBean>
{
  QCircleTroopAggregationBodyPart$4(QCircleTroopAggregationBodyPart paramQCircleTroopAggregationBodyPart) {}
  
  public void a(@Nullable ResponseBean paramResponseBean)
  {
    QCircleTroopAggregationBodyPart.f(this.a);
    if ((paramResponseBean != null) && (QCircleTroopAggregationBodyPart.a(this.a) != null))
    {
      QCircleTroopAggregationBodyPart.a(this.a, paramResponseBean);
      if (!QCircleTroopAggregationBodyPart.g(this.a))
      {
        QCircleTroopAggregationBodyPart.b(this.a, paramResponseBean);
        return;
      }
      if (QCircleTroopAggregationBodyPart.a(this.a) != null) {
        QCircleTroopAggregationBodyPart.a(this.a).clearData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationBodyPart.4
 * JD-Core Version:    0.7.0.1
 */