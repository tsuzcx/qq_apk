package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewPagerAdapter;
import com.tencent.biz.qqcircle.publish.preview.helper.PicDragHelperCallback.DragListener;
import com.tencent.biz.qqcircle.publish.preview.helper.ShakeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCirclePublishPicPreviewPart$4
  implements PicDragHelperCallback.DragListener
{
  QCirclePublishPicPreviewPart$4(QCirclePublishPicPreviewPart paramQCirclePublishPicPreviewPart, View paramView) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDragFinish  isInside = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCirclePublishPicPreviewPart", 1, localStringBuilder.toString());
    if (QCirclePublishPicPreviewPart.d(this.b) != null) {
      QCirclePublishPicPreviewPart.d(this.b).a(QCirclePublishPicPreviewPart.e(this.b).a());
    }
    QCirclePublishPicPreviewPart.a(this.b, true);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(15).setSubActionType(27).setThrActionType(2));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      return;
    }
    if (paramBoolean1) {
      ShakeUtil.a(this.a.getContext(), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewPart.4
 * JD-Core Version:    0.7.0.1
 */