package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter.PicOperationListener;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewPagerAdapter;
import com.tencent.biz.richframework.widget.MultiPicViewPager;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCirclePublishPicPreviewPart$3
  implements QCirclePicPreviewMoveAdapter.PicOperationListener
{
  QCirclePublishPicPreviewPart$3(QCirclePublishPicPreviewPart paramQCirclePublishPicPreviewPart) {}
  
  public void a(int paramInt)
  {
    if (QCirclePublishPicPreviewPart.d(this.a) != null) {
      QCirclePublishPicPreviewPart.d(this.a).a(QCirclePublishPicPreviewPart.e(this.a).a());
    }
    if (QCirclePublishPicPreviewPart.b(this.a) != null)
    {
      QCirclePublishPicPreviewPart localQCirclePublishPicPreviewPart = this.a;
      QCirclePublishPicPreviewPart.a(localQCirclePublishPicPreviewPart, QCirclePublishPicPreviewPart.b(localQCirclePublishPicPreviewPart).getCurrentItem());
    }
    QCirclePublishPicPreviewPart.a(this.a, true);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(15).setSubActionType(27).setThrActionType(3));
  }
  
  public void a(View paramView)
  {
    if (QCirclePublishPicPreviewPart.c(this.a) != null)
    {
      HostUIHelper.openHostEnvironment(QCirclePublishPicPreviewPart.c(this.a));
    }
    else
    {
      QLog.e("QCirclePublishPicPreviewPart", 1, "initData... mTakePhotoHostEnvironmentLifeCycle == null");
      paramView = this.a;
      QCirclePublishPicPreviewPart.a(paramView, new QCirclePublishPicPreviewPart.TakePhotoHostEnvironmentLifeCycle(paramView));
      HostUIHelper.openHostEnvironment(QCirclePublishPicPreviewPart.c(this.a));
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(15).setSubActionType(27).setThrActionType(4));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (QCirclePublishPicPreviewPart.b(this.a) != null) {
      QCirclePublishPicPreviewPart.b(this.a).setCurrentItem(paramInt, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewPart.3
 * JD-Core Version:    0.7.0.1
 */