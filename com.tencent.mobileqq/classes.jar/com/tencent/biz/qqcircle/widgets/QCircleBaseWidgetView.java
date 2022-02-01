package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import zxl;

public abstract class QCircleBaseWidgetView<T>
  extends BaseWidgetView<T>
  implements zxl<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  public QCircleBaseWidgetView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleBaseWidgetView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCircleBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleBaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QCircleReportBean a()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(a(), this.a.setModuleIdStr(b()));
  }
  
  protected abstract String a();
  
  protected String b()
  {
    if (this.a != null) {
      return this.a.getModuleIdStr();
    }
    return null;
  }
  
  public int d()
  {
    return QCircleReportBean.getPageId(a(), this.a);
  }
  
  public int e()
  {
    return QCircleReportBean.getParentPageId(a(), this.a);
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.a = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
 * JD-Core Version:    0.7.0.1
 */