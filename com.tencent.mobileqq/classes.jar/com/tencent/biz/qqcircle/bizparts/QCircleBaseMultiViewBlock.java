package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.part.utils.RFWViewUtils;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import cooperation.qqcircle.report.QCircleReportBean;

public abstract class QCircleBaseMultiViewBlock<E>
  extends MultiViewBlock<E>
  implements ReportBean<QCircleReportBean>
{
  private static final String TAG = "QCircleBaseMultiViewBlock";
  protected QCircleReportBean mReportBean;
  
  public QCircleBaseMultiViewBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private QCircleReportBean compatQFSReportDataBean()
  {
    Object localObject = getViewTagData();
    if (!(localObject instanceof QCircleReportBean)) {
      return null;
    }
    return (QCircleReportBean)localObject;
  }
  
  private Object getViewTagData()
  {
    if (getParentRecyclerView() == null) {
      return null;
    }
    return RFWViewUtils.a(BasePartFragment.E, this.mRecyclerView);
  }
  
  protected abstract String getLogTag();
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId("QCircleBaseMultiViewBlock", this.mReportBean);
  }
  
  protected int getParentPageId()
  {
    return QCircleReportBean.getParentPageId("QCircleBaseMultiViewBlock", this.mReportBean);
  }
  
  public QCircleExtraTypeInfo getQCircleExtraTypeInfo()
  {
    if ((getExtraTypeInfo() instanceof QCircleExtraTypeInfo)) {
      return (QCircleExtraTypeInfo)getExtraTypeInfo();
    }
    return null;
  }
  
  public QCircleReportBean getReportBean()
  {
    QCircleReportBean localQCircleReportBean = compatQFSReportDataBean();
    if (localQCircleReportBean != null)
    {
      this.mReportBean = localQCircleReportBean;
      return this.mReportBean;
    }
    if (this.mReportBean == null) {
      this.mReportBean = new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleBaseMultiViewBlock
 * JD-Core Version:    0.7.0.1
 */