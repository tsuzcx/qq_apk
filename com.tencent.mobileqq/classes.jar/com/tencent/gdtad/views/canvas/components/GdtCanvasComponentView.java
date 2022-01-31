package com.tencent.gdtad.views.canvas.components;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTimeStatistics;
import com.tencent.gdtad.views.GdtViewLoadListener;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.GdtViewStatus.Listener;
import java.lang.ref.WeakReference;

public abstract class GdtCanvasComponentView
  extends FrameLayout
  implements GdtViewStatus.Listener
{
  protected GdtTimeStatistics a;
  public GdtViewStatus a;
  public GdtCanvasComponentData a;
  private WeakReference a;
  
  public GdtCanvasComponentView(Context paramContext, WeakReference paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics == null)) {
      GdtLog.d("GdtCanvasComponentView", "notifyLoaded error");
    }
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    } while (l < 0L);
    ((GdtViewLoadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this, l, paramBoolean);
  }
  
  public abstract GdtViewStatus a();
  
  public abstract GdtCanvasComponentData a();
  
  public void a()
  {
    if (a() == null) {
      return;
    }
    GdtLog.b("GdtCanvasComponentView", a().id + ": onViewResume");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.b();
    }
    b(paramBoolean);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = null;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (a() == null) {
      return;
    }
    GdtLog.b("GdtCanvasComponentView", a().id + ": onViewPause");
  }
  
  public void c()
  {
    if (a() != null) {
      a().d();
    }
  }
  
  public void d()
  {
    if (a() != null) {
      a().a();
    }
  }
  
  public void e()
  {
    if (a() != null) {
      a().c();
    }
  }
  
  public void f()
  {
    if (a() != null) {
      a().b();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView
 * JD-Core Version:    0.7.0.1
 */