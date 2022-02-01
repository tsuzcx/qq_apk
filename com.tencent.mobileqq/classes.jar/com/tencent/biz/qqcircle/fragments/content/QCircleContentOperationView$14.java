package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import cooperation.qqcircle.report.QCircleReportBean;

class QCircleContentOperationView$14
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  QCircleContentOperationView$14(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(this.a.getReportBean().clone());
    QCircleLauncher.b(this.a.getContext(), localQCircleInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.14
 * JD-Core Version:    0.7.0.1
 */