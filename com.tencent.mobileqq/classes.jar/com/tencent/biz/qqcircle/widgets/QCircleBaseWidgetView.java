package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

public abstract class QCircleBaseWidgetView<T>
  extends BaseWidgetView<T>
  implements ReportBean<QCircleReportBean>
{
  private static final String TAG = "QCircleBaseWidgetView";
  private QCircleReportBean mCacheReportBean;
  protected QCircleReportBean mReportBean;
  
  public QCircleBaseWidgetView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleBaseWidgetView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, Integer.valueOf(paramInt));
  }
  
  public QCircleBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private QCircleReportBean compatQFSReportDataBean()
  {
    Object localObject = super.getViewTagData();
    if ((localObject instanceof QCircleReportBean))
    {
      localObject = (QCircleReportBean)localObject;
      this.mCacheReportBean = ((QCircleReportBean)localObject);
      return localObject;
    }
    localObject = this.mCacheReportBean;
    QLog.i("QCircleBaseWidgetView", 1, "getReportBean used mCacheReportBean");
    return localObject;
  }
  
  protected abstract String getLogTag();
  
  protected int getPageId()
  {
    if (this.mReportBean == null) {
      this.mReportBean = getReportBean();
    }
    return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
  }
  
  protected int getParentPageId()
  {
    return QCircleReportBean.getParentPageId(getLogTag(), this.mReportBean);
  }
  
  public QCircleBaseFragment getQCircleBaseFragment()
  {
    return QCirclePluginUtil.f(getContext());
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
  
  public <VM extends BaseViewModel> VM getViewModel(QCircleBaseFragment paramQCircleBaseFragment, Class<VM> paramClass)
  {
    if (getQCircleBaseFragment() != null) {
      return paramQCircleBaseFragment.a(paramClass);
    }
    return null;
  }
  
  public <VM extends BaseViewModel> VM getViewModel(Class<VM> paramClass)
  {
    if (getQCircleBaseFragment() != null) {
      return getQCircleBaseFragment().a(paramClass);
    }
    return null;
  }
  
  public void setCacheReportBean(QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean == null) {
      return;
    }
    this.mCacheReportBean = paramQCircleReportBean;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
 * JD-Core Version:    0.7.0.1
 */