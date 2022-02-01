package com.tencent.biz.qqcircle.fragments.content.stick;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleExpandStickLayout
  extends FrameLayout
{
  private QCircleExpandStickView a;
  
  public QCircleExpandStickLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleExpandStickLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleExpandStickLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new QCircleExpandStickView(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(float paramFloat)
  {
    QCircleExpandStickView localQCircleExpandStickView = this.a;
    boolean bool = true;
    if (localQCircleExpandStickView == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[updateScaleValue] expand stick view not is null.");
      return;
    }
    if ((paramFloat >= 1.1F) || (paramFloat <= 0.9F)) {
      bool = false;
    }
    localQCircleExpandStickView.a(bool);
  }
  
  public void a(Point paramPoint)
  {
    QCircleExpandStickView localQCircleExpandStickView = this.a;
    if (localQCircleExpandStickView == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[handleClickPoint] expand stick view not is null.");
      return;
    }
    localQCircleExpandStickView.a(paramPoint);
  }
  
  public void a(@NonNull QCircleStickConfig paramQCircleStickConfig)
  {
    if (this.a == null)
    {
      QLog.d("Stick-QCircleExpandStickLayout", 1, "[updateStickConfig] expand stick view not is null.");
      return;
    }
    setVisibility(0);
    int i = paramQCircleStickConfig.b();
    int j = paramQCircleStickConfig.c();
    int k = paramQCircleStickConfig.d();
    int m = paramQCircleStickConfig.e();
    Rect localRect1 = new Rect(0, 0, i, j);
    Rect localRect2 = new Rect(0, 0, k, m);
    Rect localRect3 = new Rect(0, 0, i, j);
    this.a.a(QCircleExpandStickView.QCircleLoadStickParam.a().a(paramQCircleStickConfig.g()).a(localRect1).b(localRect2).c(localRect3).a(paramQCircleStickConfig.h()).a(paramQCircleStickConfig.i()).a(paramQCircleStickConfig.f()).b(true));
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    QCircleExpandStickView localQCircleExpandStickView = this.a;
    if (localQCircleExpandStickView == null)
    {
      QLog.w("Stick-QCircleExpandStickLayout", 1, "[setReportBean] report bean not is null.");
      return;
    }
    localQCircleExpandStickView.setReportBean(paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout
 * JD-Core Version:    0.7.0.1
 */