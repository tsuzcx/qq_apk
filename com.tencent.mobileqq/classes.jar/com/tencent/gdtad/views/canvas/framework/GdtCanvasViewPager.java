package com.tencent.gdtad.views.canvas.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.viewpager.GdtVerticalViewPager;
import com.tencent.gdtad.views.viewpager.GdtViewPagerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import qmk;
import qml;
import qmm;
import qmn;

public class GdtCanvasViewPager
  extends GdtVerticalViewPager
  implements GdtCanvasScrollView.OnScrollEventListener
{
  private WeakReference a;
  
  public GdtCanvasViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  private GdtCanvasData a()
  {
    if ((this.a != null) && (this.a.get() != null) && (((GdtCanvasViewListener)this.a.get()).a() != null) && (((GdtCanvasViewListener)this.a.get()).a().isValid())) {
      return ((GdtCanvasViewListener)this.a.get()).a();
    }
    return null;
  }
  
  private GdtCanvasPageView a(GdtCanvasPageData paramGdtCanvasPageData)
  {
    paramGdtCanvasPageData = new GdtCanvasPageView(getContext(), this.a, paramGdtCanvasPageData);
    paramGdtCanvasPageData.setListener(this);
    return paramGdtCanvasPageData;
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (a() != null)
    {
      int i = 0;
      int j = a().getSize();
      while (i < j)
      {
        localArrayList.add(a(a().getPage(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void f()
  {
    List localList = a();
    GdtViewPagerAdapter localGdtViewPagerAdapter = new GdtViewPagerAdapter();
    localGdtViewPagerAdapter.a(localList);
    setAdapter(localGdtViewPagerAdapter);
  }
  
  @TargetApi(9)
  private void g()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
  }
  
  private void h()
  {
    int i = 0;
    while (i < a())
    {
      a(i).d();
      i += 1;
    }
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
      postDelayed(new qmm(this, i), 100L);
    }
  }
  
  public void a(ScrollView paramScrollView)
  {
    if ((paramScrollView instanceof GdtCanvasPageView)) {
      ((GdtCanvasPageView)GdtCanvasPageView.class.cast(paramScrollView)).d();
    }
  }
  
  public void a(WeakReference paramWeakReference)
  {
    this.a = paramWeakReference;
    f();
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
      postDelayed(new qmn(this, i), 100L);
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
    h();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return false;
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        GdtLog.d("GdtCanvasViewPager", "onInterceptTouchEvent", paramMotionEvent);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(paramInt);
    postDelayed(new qmk(this), 200L);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    super.setCurrentItem(paramInt, paramBoolean);
    postDelayed(new qml(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasViewPager
 * JD-Core Version:    0.7.0.1
 */