package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import cooperation.qqcircle.report.QCircleReportBean;

class QCircleCommentItemView$3
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  QCircleCommentItemView$3(QCircleCommentItemView paramQCircleCommentItemView) {}
  
  public void onClick(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(this.a.getReportBean().clone());
    QCircleLauncher.b(this.a.getContext(), localQCircleInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentItemView.3
 * JD-Core Version:    0.7.0.1
 */