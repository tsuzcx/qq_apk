package com.tencent.gdtad.views.canvas.framework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasMutiVideoManager;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentView;
import java.lang.ref.WeakReference;

public class GdtCanvasPageView
  extends GdtCanvasScrollView
{
  private GdtCanvasMutiVideoManager jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager = new GdtCanvasMutiVideoManager();
  private GdtCanvasPageData jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtCanvasPageView(Context paramContext, WeakReference paramWeakReference, GdtCanvasPageData paramGdtCanvasPageData)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    a(paramGdtCanvasPageData);
  }
  
  private GdtCanvasComponentView a(GdtCanvasComponentData paramGdtCanvasComponentData)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramGdtCanvasComponentData != null)
    {
      if (!paramGdtCanvasComponentData.isValid()) {
        localObject2 = localObject1;
      }
    }
    else {
      return localObject2;
    }
    if ((paramGdtCanvasComponentData instanceof GdtCanvasPictureComponentData)) {
      localObject1 = new GdtCanvasPictureComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasPictureComponentData)GdtCanvasPictureComponentData.class.cast(paramGdtCanvasComponentData));
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((GdtCanvasComponentView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      return localObject1;
      if ((paramGdtCanvasComponentData instanceof GdtCanvasButtonComponentData))
      {
        localObject1 = new GdtCanvasButtonComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasButtonComponentData)GdtCanvasButtonComponentData.class.cast(paramGdtCanvasComponentData));
      }
      else if ((paramGdtCanvasComponentData instanceof GdtCanvasVideoComponentData))
      {
        localObject1 = new GdtCanvasVideoComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasVideoComponentData)GdtCanvasVideoComponentData.class.cast(paramGdtCanvasComponentData), this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager, this);
      }
      else
      {
        localObject1 = localObject3;
        if ((paramGdtCanvasComponentData instanceof GdtCanvasFormComponentData)) {
          localObject1 = new GdtCanvasFormComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasFormComponentData)GdtCanvasFormComponentData.class.cast(paramGdtCanvasComponentData));
        }
      }
    }
  }
  
  private void a(GdtCanvasPageData paramGdtCanvasPageData)
  {
    if ((paramGdtCanvasPageData == null) || (!paramGdtCanvasPageData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData = paramGdtCanvasPageData;
    setFillViewport(true);
    setBackgroundColor(paramGdtCanvasPageData.backgroundColor);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    Object localObject = localLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = -2;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i = 0;
    int j = paramGdtCanvasPageData.getSize();
    label89:
    if (i < j)
    {
      localObject = a(paramGdtCanvasPageData.getComponent(i));
      if (localObject != null) {
        break label117;
      }
    }
    for (;;)
    {
      i += 1;
      break label89;
      break;
      label117:
      localLinearLayout.addView((View)localObject);
    }
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
  
  public void a()
  {
    int i = 0;
    while (i < a())
    {
      a(i).d();
      i += 1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView
 * JD-Core Version:    0.7.0.1
 */