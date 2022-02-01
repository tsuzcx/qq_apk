package com.tencent.biz.qqcircle.fragments.message.presenter;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import cooperation.qqcircle.report.QCircleReportBean;

class QCircleBaseMessagePresenter$2
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  QCircleBaseMessagePresenter$2(QCircleBaseMessagePresenter paramQCircleBaseMessagePresenter) {}
  
  public void onClick(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(this.a.d().clone());
    QCircleLauncher.b(this.a.h.getContext(), localQCircleInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter.2
 * JD-Core Version:    0.7.0.1
 */