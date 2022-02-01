package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiAdapter;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiAdapter.PoiItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleLbsPart$1
  implements AdapterView.OnItemClickListener
{
  QCircleLbsPart$1(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QCirclePoiAdapter.PoiItemInfo localPoiItemInfo = QCircleLbsPart.a(this.a).a(paramInt);
    if ((localPoiItemInfo != null) && (!localPoiItemInfo.c))
    {
      QCirclePublishReport.a(15, 16, 2, "", "");
      QCircleLbsPart.a(this.a, localPoiItemInfo.a, false);
      QCircleLbsPart.b(this.a).g = localPoiItemInfo.a;
      QCircleLbsPart.b(this.a).l = true;
      QCircleLbsPart.c(this.a).setVisibility(8);
    }
    else
    {
      QCircleLbsPart.d(this.a);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.1
 * JD-Core Version:    0.7.0.1
 */