package com.tencent.gdtad.views.canvas.framework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTimeStatistics;
import com.tencent.gdtad.views.GdtViewLoadListener;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasMutiVideoManager;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GdtCanvasPageView
  extends GdtCanvasScrollView
  implements GdtViewLoadListener
{
  protected GdtTimeStatistics a;
  private GdtCanvasMutiVideoManager jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager = new GdtCanvasMutiVideoManager();
  private GdtCanvasPageData jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  
  public GdtCanvasPageView(Context paramContext, WeakReference paramWeakReference, GdtCanvasPageData paramGdtCanvasPageData)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    a(paramGdtCanvasPageData);
  }
  
  private GdtCanvasComponentView a(GdtCanvasComponentData paramGdtCanvasComponentData)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (!paramGdtCanvasComponentData.isValid())
    {
      paramGdtCanvasComponentData = (GdtCanvasComponentData)localObject1;
      return paramGdtCanvasComponentData;
    }
    if ((paramGdtCanvasComponentData instanceof GdtCanvasPictureComponentData)) {
      localObject1 = new GdtCanvasPictureComponentView(getContext(), new WeakReference(this), (GdtCanvasPictureComponentData)GdtCanvasPictureComponentData.class.cast(paramGdtCanvasComponentData));
    }
    for (;;)
    {
      paramGdtCanvasComponentData = (GdtCanvasComponentData)localObject1;
      if (localObject1 == null) {
        break;
      }
      ((GdtCanvasComponentView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      return localObject1;
      if ((paramGdtCanvasComponentData instanceof GdtCanvasButtonComponentData))
      {
        localObject1 = new GdtCanvasButtonComponentView(getContext(), new WeakReference(this), (GdtCanvasButtonComponentData)GdtCanvasButtonComponentData.class.cast(paramGdtCanvasComponentData));
      }
      else
      {
        localObject1 = localObject2;
        if ((paramGdtCanvasComponentData instanceof GdtCanvasVideoComponentData)) {
          localObject1 = new GdtCanvasVideoComponentView(getContext(), new WeakReference(this), (GdtCanvasVideoComponentData)GdtCanvasVideoComponentData.class.cast(paramGdtCanvasComponentData), this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager, this);
        }
      }
    }
  }
  
  private void a(GdtCanvasPageData paramGdtCanvasPageData)
  {
    if ((paramGdtCanvasPageData == null) || (!paramGdtCanvasPageData.isValid())) {}
    LinearLayout localLinearLayout;
    Object localObject;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData = paramGdtCanvasPageData;
      e();
      setFillViewport(true);
      setBackgroundColor(paramGdtCanvasPageData.backgroundColor);
      localLinearLayout = new LinearLayout(getContext());
      addView(localLinearLayout);
      localLinearLayout.setOrientation(1);
      localObject = localLinearLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    } while (paramGdtCanvasPageData.components == null);
    int j = paramGdtCanvasPageData.components.size();
    int i = 0;
    label105:
    if (i < j)
    {
      localObject = a((GdtCanvasComponentData)paramGdtCanvasPageData.components.get(i));
      if (localObject != null) {
        break label141;
      }
    }
    for (;;)
    {
      i += 1;
      break label105;
      break;
      label141:
      localLinearLayout.addView((View)localObject);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics == null)) {
      GdtLog.d(jdField_a_of_type_JavaLangString, "notifyLoaded error");
    }
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    } while (l < 0L);
    ((GdtViewLoadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this, l, this.jdField_a_of_type_Boolean);
  }
  
  public int a()
  {
    int i = 0;
    if ((getChildAt(0) instanceof ViewGroup)) {
      i = ((ViewGroup)getChildAt(0)).getChildCount();
    }
    return i;
  }
  
  public GdtCanvasComponentView a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a()) || (!(getChildAt(0) instanceof ViewGroup))) {
      return null;
    }
    View localView = ((ViewGroup)getChildAt(0)).getChildAt(paramInt);
    if (!(localView instanceof GdtCanvasComponentView)) {
      return null;
    }
    return (GdtCanvasComponentView)localView;
  }
  
  public GdtCanvasPageData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData;
  }
  
  public void a()
  {
    int i = 0;
    while (i < a())
    {
      a(i).d();
      i += 1;
    }
  }
  
  public void a(GdtCanvasComponentView paramGdtCanvasComponentView, long paramLong, boolean paramBoolean)
  {
    if ((paramGdtCanvasComponentView == null) || (paramGdtCanvasComponentView.a() == null) || (!paramGdtCanvasComponentView.a().isValid()) || (paramLong < 0L) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData.isValid())) {
      GdtLog.d(jdField_a_of_type_JavaLangString, "onLoad error");
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilSet == null);
      this.jdField_a_of_type_Boolean &= paramBoolean;
      this.jdField_a_of_type_JavaUtilSet.add(paramGdtCanvasComponentView.a().id);
    } while (this.jdField_a_of_type_JavaUtilSet.size() != this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData.components.size());
    f();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilSet = null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < a())
      {
        if (a(i).a()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < a())
    {
      a(i).e();
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < a())
    {
      a(i).f();
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < a())
    {
      a(i).c();
      i += 1;
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.b();
    }
    g();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    setLayoutParams(localLayoutParams);
  }
  
  public void setListener(GdtCanvasScrollView.OnScrollEventListener paramOnScrollEventListener)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener = paramOnScrollEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView
 * JD-Core Version:    0.7.0.1
 */