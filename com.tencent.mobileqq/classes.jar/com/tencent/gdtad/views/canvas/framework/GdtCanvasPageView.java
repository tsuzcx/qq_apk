package com.tencent.gdtad.views.canvas.framework;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentData;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentView;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentView;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentView;
import java.lang.ref.WeakReference;
import yxs;
import yze;
import zad;
import zag;

public class GdtCanvasPageView
  extends ScrollView
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private GdtCanvasPageData jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageData;
  private WeakReference<zag> jdField_a_of_type_JavaLangRefWeakReference;
  private zad jdField_a_of_type_Zad = new zad();
  
  public GdtCanvasPageView(Context paramContext, WeakReference<zag> paramWeakReference, GdtCanvasPageData paramGdtCanvasPageData)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    setVerticalScrollBarEnabled(false);
    setVerticalFadingEdgeEnabled(false);
    a(paramGdtCanvasPageData);
  }
  
  private GdtCanvasComponentView a(GdtCanvasComponentData paramGdtCanvasComponentData, GdtCanvasPageData paramGdtCanvasPageData)
  {
    Object localObject = null;
    paramGdtCanvasPageData = null;
    GdtCanvasPageData localGdtCanvasPageData = paramGdtCanvasPageData;
    if (paramGdtCanvasComponentData != null)
    {
      if (!paramGdtCanvasComponentData.isValid()) {
        localGdtCanvasPageData = paramGdtCanvasPageData;
      }
    }
    else {
      return localGdtCanvasPageData;
    }
    if ((paramGdtCanvasComponentData instanceof GdtCanvasPictureComponentData)) {
      paramGdtCanvasPageData = new GdtCanvasPictureComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasPictureComponentData)GdtCanvasPictureComponentData.class.cast(paramGdtCanvasComponentData));
    }
    for (;;)
    {
      localGdtCanvasPageData = paramGdtCanvasPageData;
      if (paramGdtCanvasPageData == null) {
        break;
      }
      paramGdtCanvasPageData.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      return paramGdtCanvasPageData;
      if ((paramGdtCanvasComponentData instanceof GdtCanvasButtonComponentData))
      {
        paramGdtCanvasPageData = new GdtCanvasButtonComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasButtonComponentData)GdtCanvasButtonComponentData.class.cast(paramGdtCanvasComponentData));
      }
      else if ((paramGdtCanvasComponentData instanceof GdtCanvasVideoComponentData))
      {
        paramGdtCanvasPageData = new GdtCanvasVideoComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasVideoComponentData)GdtCanvasVideoComponentData.class.cast(paramGdtCanvasComponentData), this.jdField_a_of_type_Zad, this);
      }
      else if ((paramGdtCanvasComponentData instanceof GdtCanvasFormComponentData))
      {
        paramGdtCanvasPageData = new GdtCanvasFormComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasFormComponentData)GdtCanvasFormComponentData.class.cast(paramGdtCanvasComponentData));
      }
      else if ((paramGdtCanvasComponentData instanceof GdtCanvasAppBtnComponentData))
      {
        paramGdtCanvasPageData = new GdtCanvasAppBtnComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasAppBtnComponentData)GdtCanvasAppBtnComponentData.class.cast(paramGdtCanvasComponentData), ((GdtCanvasAppBtnComponentData)GdtCanvasAppBtnComponentData.class.cast(paramGdtCanvasComponentData)).canShowProgress);
      }
      else
      {
        paramGdtCanvasPageData = localObject;
        if ((paramGdtCanvasComponentData instanceof GdtCanvasMultiPictureComponentData)) {
          paramGdtCanvasPageData = new GdtCanvasMultiPictureComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasMultiPictureComponentData)GdtCanvasMultiPictureComponentData.class.cast(paramGdtCanvasComponentData));
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = -2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i = 0;
    int j = paramGdtCanvasPageData.getSize();
    label99:
    if (i < j)
    {
      localObject = a(paramGdtCanvasPageData.getComponent(i), paramGdtCanvasPageData);
      if (localObject != null) {
        break label128;
      }
    }
    for (;;)
    {
      i += 1;
      break label99;
      break;
      label128:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
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
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {}
    for (;;)
    {
      return 0;
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      int i = 0;
      while (i < localLinearLayout.getChildCount())
      {
        View localView = localLinearLayout.getChildAt(i);
        if (((localView instanceof GdtCanvasComponentView)) && (paramString.equals(((GdtCanvasComponentView)localView).a().id)))
        {
          if (localLinearLayout.getChildAt(i) != null)
          {
            int j = localLinearLayout.getChildAt(i).getTop();
            yxs.a("GdtCanvasPageView", "form top :" + j);
            smoothScrollTo(0, j);
          }
          return i;
        }
        i += 1;
      }
    }
  }
  
  public View a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return null;
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int i = 0;
    while (i < localLinearLayout.getChildCount())
    {
      View localView = localLinearLayout.getChildAt(i);
      if (((localView instanceof GdtCanvasComponentView)) && (paramString.equals(((GdtCanvasComponentView)localView).a().id))) {
        return ((GdtCanvasComponentView)localView).getChildAt(0);
      }
      i += 1;
    }
    return null;
  }
  
  public View a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = a(paramString);
    int i = yze.c(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i * paramInt2 / paramInt1);
    AdThreadManager.INSTANCE.post(new GdtCanvasPageView.1(this, paramString, localLayoutParams), 0);
    return null;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
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
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setFormFocusd(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = paramString.getParent();
      if ((paramString != null) && ((paramString instanceof GdtCanvasFormComponentView))) {
        ((GdtCanvasFormComponentView)paramString).setFocused(paramBoolean);
      }
    }
  }
  
  public void setPageViewLayoutParams(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {}
    try
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localMarginLayoutParams.topMargin = paramInt;
      setLayoutParams(localMarginLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      yxs.d("GdtCanvasPageView", "setPageViewLayoutParams:" + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView
 * JD-Core Version:    0.7.0.1
 */