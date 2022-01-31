package com.tencent.gdtad.views.canvas.framework;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.gdtad.statistics.GdtTimeStatistics;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import qra;

public class GdtCanvasView
  extends FrameLayout
  implements GdtCanvasViewListener
{
  protected GdtTimeStatistics a;
  private GdtCanvasData jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData;
  private GdtCanvasViewPager jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private GdtTimeStatistics jdField_b_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  public GdtCanvasView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
    e();
  }
  
  public GdtCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
    e();
  }
  
  public GdtCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
    e();
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
      GdtLog.d("GdtCanvasView", "reportLoadTimeForAction error");
    }
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    GdtAd localGdtAd;
    if (a() != null)
    {
      localGdtAd = a().ad;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = localGdtAd;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (int i = 3;; i = 4)
    {
      localParams.jdField_a_of_type_Int = i;
      localParams.jdField_a_of_type_Long = paramLong;
      GdtActionReporter.a(localParams);
      return;
      localGdtAd = null;
      break;
    }
  }
  
  private void e()
  {
    d();
    inflate(getContext(), 2130969007, this);
    findViewById(2131362873).setOnClickListener(new qra(this));
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid()))
    {
      GdtLog.d("GdtCanvasView", "reportStayTimeForAction error");
      return;
    }
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    if (a() != null) {}
    for (GdtAd localGdtAd = a().ad;; localGdtAd = null)
    {
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = localGdtAd;
      localParams.jdField_a_of_type_Int = 7;
      localParams.jdField_a_of_type_Long = this.jdField_b_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
      GdtActionReporter.a(localParams);
      return;
    }
  }
  
  protected long a()
  {
    long l = -2147483648L;
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null)
    {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.b();
      l = this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    }
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = null;
    return l;
  }
  
  public GdtCanvasData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.c();
    f();
    a(this.jdField_b_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a(), false);
  }
  
  public void a(GdtCanvasComponentData paramGdtCanvasComponentData, long paramLong, boolean paramBoolean)
  {
    if ((paramGdtCanvasComponentData == null) || (!paramGdtCanvasComponentData.isValid())) {
      GdtLog.d("GdtCanvasView", "onLoaded error");
    }
    label191:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Boolean) || (!paramBoolean) || (a() == null) || (!a().isValid())) {}
      for (;;)
      {
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilSet == null)) {
          break label191;
        }
        this.c &= paramBoolean;
        this.jdField_a_of_type_JavaUtilSet.add(paramGdtCanvasComponentData.id);
        if (this.jdField_a_of_type_JavaUtilSet.size() != a().getSizeOfComponents()) {
          break;
        }
        a(a(), this.c);
        return;
        Object localObject = a().getPage(0);
        if ((localObject != null) && (((GdtCanvasPageData)localObject).isValid()))
        {
          localObject = ((GdtCanvasPageData)localObject).getComponent(0);
          if ((localObject != null) && (((GdtCanvasComponentData)localObject).isValid()) && (TextUtils.equals(paramGdtCanvasComponentData.id, ((GdtCanvasComponentData)localObject).id)))
          {
            GdtCanvasDMPReportUtil.a(a());
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
    }
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
    this.jdField_b_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.d();
    this.jdField_b_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.b();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    }
  }
  
  public void setData(GdtCanvasData paramGdtCanvasData)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData = paramGdtCanvasData;
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager = ((GdtCanvasViewPager)findViewById(2131363118));
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasViewPager.a(new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasView
 * JD-Core Version:    0.7.0.1
 */