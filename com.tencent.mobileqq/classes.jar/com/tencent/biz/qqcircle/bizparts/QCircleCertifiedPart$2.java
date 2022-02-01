package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView.ICertifiedListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qqcircle.QQCircleFeedBase.StTabInfo;

class QCircleCertifiedPart$2
  implements QCircleCertifiedDialogView.ICertifiedListener
{
  QCircleCertifiedPart$2(QCircleCertifiedPart paramQCircleCertifiedPart) {}
  
  public void a()
  {
    if (QCircleCertifiedPart.c(this.a) != null)
    {
      QCircleCertifiedPart localQCircleCertifiedPart = this.a;
      QCircleCertifiedPart.a(localQCircleCertifiedPart, QCircleJsUrlConfig.a(QCircleCertifiedPart.c(localQCircleCertifiedPart).a.urlInfo.get(), "authCampanyUrl"));
    }
  }
  
  public void b()
  {
    if (QCircleCertifiedPart.c(this.a) != null)
    {
      QCircleCertifiedPart localQCircleCertifiedPart = this.a;
      QCircleCertifiedPart.a(localQCircleCertifiedPart, QCircleJsUrlConfig.a(QCircleCertifiedPart.c(localQCircleCertifiedPart).a.urlInfo.get(), "authSchoolUrl"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCertifiedPart.2
 * JD-Core Version:    0.7.0.1
 */