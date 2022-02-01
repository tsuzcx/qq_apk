package com.tencent.biz.qqcircle.publish.view;

import com.tencent.biz.qqcircle.widgets.multitouchimg.OnScaleEndListener;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCirclePicPreviewImage$1
  implements OnScaleEndListener
{
  QCirclePicPreviewImage$1(QCirclePicPreviewImage paramQCirclePicPreviewImage) {}
  
  public void a(float paramFloat)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(15).setSubActionType(27).setThrActionType(5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.QCirclePicPreviewImage.1
 * JD-Core Version:    0.7.0.1
 */