package com.tencent.gdtad.views.canvas.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTimeStatistics;
import com.tencent.gdtad.views.GdtViewLoadListener;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.viewpager.GdtVerticalViewPager;
import com.tencent.gdtad.views.viewpager.GdtViewPagerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import qjw;
import qjx;
import qjy;
import qjz;

public class GdtCanvasViewPager
  extends GdtVerticalViewPager
  implements GdtViewLoadListener, GdtCanvasScrollView.OnScrollEventListener
{
  protected GdtTimeStatistics a;
  private GdtCanvasData jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  
  public GdtCanvasViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = new GdtTimeStatistics();
    h();
  }
  
  private GdtCanvasPageView a(GdtCanvasPageData paramGdtCanvasPageData)
  {
    paramGdtCanvasPageData = new GdtCanvasPageView(getContext(), new WeakReference(this), paramGdtCanvasPageData);
    paramGdtCanvasPageData.setListener(this);
    return paramGdtCanvasPageData;
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.pages != null))
    {
      int j = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.pages.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a((GdtCanvasPageData)this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.pages.get(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  @TargetApi(9)
  private void h()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
  }
  
  private void i()
  {
    int i = 0;
    while (i < a())
    {
      a(i).d();
      i += 1;
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics == null)) {
      GdtLog.d("GdtCanvasViewPager", "notifyLoaded error");
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
    if (getAdapter() != null) {
      return getAdapter().getCount();
    }
    return 0;
  }
  
  public GdtCanvasPageView a(int paramInt)
  {
    if (!(getAdapter() instanceof GdtViewPagerAdapter)) {
      return null;
    }
    return (GdtCanvasPageView)((GdtViewPagerAdapter)getAdapter()).a(paramInt);
  }
  
  public void a()
  {
    if (getCurrentItem() < a() - 1)
    {
      getCurrentItem();
      int i = getCurrentItem() + 1;
      a(i).scrollTo(0, 0);
      postDelayed(new qjy(this, i), 100L);
    }
  }
  
  public void a(ScrollView paramScrollView)
  {
    if ((paramScrollView instanceof GdtCanvasPageView)) {
      ((GdtCanvasPageView)GdtCanvasPageView.class.cast(paramScrollView)).d();
    }
  }
  
  public void a(GdtCanvasData paramGdtCanvasData)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData = paramGdtCanvasData;
    f();
    paramGdtCanvasData = a();
    GdtViewPagerAdapter localGdtViewPagerAdapter = new GdtViewPagerAdapter();
    localGdtViewPagerAdapter.a(paramGdtCanvasData);
    setAdapter(localGdtViewPagerAdapter);
  }
  
  public void a(GdtCanvasPageView paramGdtCanvasPageView, long paramLong, boolean paramBoolean)
  {
    if ((paramGdtCanvasPageView == null) || (paramGdtCanvasPageView.a() == null) || (!paramGdtCanvasPageView.a().isValid()) || (paramLong < 0L) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid())) {
      GdtLog.d("GdtCanvasViewPager", "onLoad error");
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilSet == null);
      this.jdField_a_of_type_Boolean &= paramBoolean;
      this.jdField_a_of_type_JavaUtilSet.add(paramGdtCanvasPageView.a().id);
    } while (this.jdField_a_of_type_JavaUtilSet.size() != this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.pages.size());
    g();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilSet = null;
  }
  
  public void a(WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
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
    if (getCurrentItem() >= 1)
    {
      getCurrentItem();
      int i = getCurrentItem() - 1;
      a(i).fullScroll(130);
      postDelayed(new qjz(this, i), 100L);
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < a())
    {
      a(i).a();
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < a())
    {
      a(i).b();
      i += 1;
    }
  }
  
  public void e()
  {
    int i = 0;
    while (i < a())
    {
      a(i).c();
      i += 1;
    }
    i();
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.a();
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics != null) {
      this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics.b();
    }
    j();
    this.jdField_a_of_type_ComTencentGdtadStatisticsGdtTimeStatistics = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(paramInt);
    postDelayed(new qjw(this), 200L);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    super.setCurrentItem(paramInt, paramBoolean);
    postDelayed(new qjx(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasViewPager
 * JD-Core Version:    0.7.0.1
 */