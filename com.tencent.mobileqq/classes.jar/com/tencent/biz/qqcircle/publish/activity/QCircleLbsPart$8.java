package com.tencent.biz.qqcircle.publish.activity;

import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiViewModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class QCircleLbsPart$8
  implements QQPermissionCallback
{
  QCircleLbsPart$8(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w("[QcirclePublish]QCircleLbsPart", 1, "jumpToPoiFragment... deny");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QCircleLbsPart.b(this.a).a(this.a.j());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.8
 * JD-Core Version:    0.7.0.1
 */