package com.tencent.gdtad.views.canvas.framework;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtTimeStatistics;
import com.tencent.gdtad.views.GdtViewLoadListener;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import java.lang.ref.WeakReference;
import qjv;

public class GdtCanvasView
  extends FrameLayout
  implements GdtViewLoadListener
{
  private GdtTimeStatistics jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
  private GdtCanvasData jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData;
  private GdtCanvasViewPager jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtCanvasView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public GdtCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public GdtCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private Activity a()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong < 0L) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid())) {
      GdtLog.d("GdtCanvasView", "reportLoadTime error");
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    GdtAd localGdtAd = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.ad;
    if (paramBoolean) {}
    for (int i = 3;; i = 4)
    {
      GdtActionReporter.a(GdtActionReporter.a(localGdtAd, i, paramLong));
      return;
    }
  }
  
  private void d()
  {
    inflate(getContext(), 2130969006, this);
    findViewById(2131362850).setOnClickListener(new qjv(this));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid()))
    {
      GdtLog.d("GdtCanvasView", "reportStayTime error");
      return;
    }
    GdtActionReporter.a(GdtActionReporter.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.ad, 7, this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a()));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.c();
    e();
    a(this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a(), false);
  }
  
  public void a(GdtCanvasViewPager paramGdtCanvasViewPager, long paramLong, boolean paramBoolean)
  {
    a(paramLong, paramBoolean);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.a()) {
      return true;
    }
    if (a() != null)
    {
      a().finish();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.e();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.d();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.b();
  }
  
  public void setData(GdtCanvasData paramGdtCanvasData)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData = paramGdtCanvasData;
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager = ((GdtCanvasViewPager)findViewById(2131363096));
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.a(new WeakReference(this));
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.a(paramGdtCanvasData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasView
 * JD-Core Version:    0.7.0.1
 */