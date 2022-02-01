package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.canvas.views.canvas.components.layerCard.AdCanvasLayerCardView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

@Keep
public class AdCanvasPageView
  extends ScrollView
{
  private static final String TAG = "GdtCanvasPageView";
  private WeakReference<AdCanvasViewListener> canvasViewListener;
  private LinearLayout container;
  private a data;
  private float mDownPosX = 0.0F;
  private float mDownPosY = 0.0F;
  private Handler mHandler;
  
  public AdCanvasPageView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext);
    this.canvasViewListener = paramWeakReference;
    setVerticalScrollBarEnabled(false);
    setVerticalFadingEdgeEnabled(false);
    initView(parama);
  }
  
  private AdCanvasComponentView getComponentViewFromData(AdCanvasComponentData paramAdCanvasComponentData, a parama)
  {
    Object localObject = null;
    parama = null;
    a locala = parama;
    if (paramAdCanvasComponentData != null)
    {
      if (!paramAdCanvasComponentData.isValid()) {
        locala = parama;
      }
    }
    else {
      return locala;
    }
    if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.appInfoButton.a)) {
      parama = new com.tencent.ad.tangram.canvas.views.canvas.components.appInfoButton.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.appInfoButton.a)paramAdCanvasComponentData, true);
    }
    for (;;)
    {
      locala = parama;
      if (parama == null) {
        break;
      }
      parama.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      return parama;
      if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.picture.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)com.tencent.ad.tangram.canvas.views.canvas.components.picture.a.class.cast(paramAdCanvasComponentData), null, this.mHandler);
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.button.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.button.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.button.a)com.tencent.ad.tangram.canvas.views.canvas.components.button.a.class.cast(paramAdCanvasComponentData));
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.form.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.form.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.form.a)com.tencent.ad.tangram.canvas.views.canvas.components.form.a.class.cast(paramAdCanvasComponentData));
      }
      else if ((paramAdCanvasComponentData instanceof c))
      {
        parama = new d(getContext(), this.canvasViewListener, (c)c.class.cast(paramAdCanvasComponentData), ((c)c.class.cast(paramAdCanvasComponentData)).canShowProgress);
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a)com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a.class.cast(paramAdCanvasComponentData), this.mHandler);
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.a)com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.a.class.cast(paramAdCanvasComponentData));
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.a)com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.a.class.cast(paramAdCanvasComponentData));
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.text.a))
      {
        parama = new com.tencent.ad.tangram.canvas.views.canvas.components.text.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.text.a)paramAdCanvasComponentData);
      }
      else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.layerCard.a))
      {
        parama = new AdCanvasLayerCardView(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.layerCard.a)paramAdCanvasComponentData, this.mHandler);
      }
      else
      {
        parama = localObject;
        if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.title.a)) {
          parama = new com.tencent.ad.tangram.canvas.views.canvas.components.title.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.title.a)paramAdCanvasComponentData);
        }
      }
    }
  }
  
  private void initView(a parama)
  {
    if ((parama == null) || (!parama.isValid())) {
      return;
    }
    this.data = parama;
    setFillViewport(true);
    setBackgroundColor(parama.backgroundColor);
    this.container = new LinearLayout(getContext());
    addView(this.container);
    this.container.setOrientation(1);
    Object localObject = this.container.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = -2;
    this.container.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mHandler = new AdCanvasPageView.a(this);
    int i = 0;
    int j = parama.getSize();
    label111:
    if (i < j)
    {
      localObject = getComponentViewFromData(parama.getComponent(i), parama);
      if (localObject != null) {
        break label140;
      }
    }
    for (;;)
    {
      i += 1;
      break label111;
      break;
      label140:
      this.container.addView((View)localObject);
    }
  }
  
  public boolean back()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < getCount())
      {
        if (getView(i).back()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public View findArkFormView(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.container == null)) {
      return null;
    }
    LinearLayout localLinearLayout = this.container;
    int i = 0;
    while (i < localLinearLayout.getChildCount())
    {
      View localView = localLinearLayout.getChildAt(i);
      if (((localView instanceof AdCanvasComponentView)) && (paramString.equals(((AdCanvasComponentView)localView).getData().id))) {
        return ((AdCanvasComponentView)localView).getChildAt(0);
      }
      i += 1;
    }
    return null;
  }
  
  public LinearLayout getContainer()
  {
    return this.container;
  }
  
  public int getCount()
  {
    int i = 0;
    if ((getChildAt(0) instanceof ViewGroup)) {
      i = ((ViewGroup)getChildAt(0)).getChildCount();
    }
    return i;
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public Handler getMHandler()
  {
    return this.mHandler;
  }
  
  public AdCanvasComponentView getView(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount()) || (!(getChildAt(0) instanceof ViewGroup))) {
      return null;
    }
    View localView = ((ViewGroup)getChildAt(0)).getChildAt(paramInt);
    if (!(localView instanceof AdCanvasComponentView)) {
      return null;
    }
    return (AdCanvasComponentView)localView;
  }
  
  public void onActivityDestroy()
  {
    int i = 0;
    while (i < getCount())
    {
      getView(i).onActivityDestroy();
      i += 1;
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onActivityPause()
  {
    int i = 0;
    while (i < getCount())
    {
      getView(i).onActivityPause();
      i += 1;
    }
  }
  
  public void onActivityResume()
  {
    int i = 0;
    while (i < getCount())
    {
      getView(i).onActivityResume();
      i += 1;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    setLayoutParams(localLayoutParams);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.mDownPosX = f1;
        this.mDownPosY = f2;
      }
    } while (Math.abs(f1 - this.mDownPosX) <= Math.abs(f2 - this.mDownPosY));
    return false;
  }
  
  public void onLocationChanged()
  {
    int i = 0;
    while (i < getCount())
    {
      getView(i).onLocationChanged();
      i += 1;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    onLocationChanged();
  }
  
  public View resizeArkFormView(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = findArkFormView(paramString);
    int i = AdUIUtils.getPhysicalScreenWidth(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i * paramInt2 / paramInt1);
    AdThreadManager.INSTANCE.post(new AdCanvasPageView.1(this, paramString, localLayoutParams), 0);
    return null;
  }
  
  public int scrollToArkFormView(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.container == null)) {}
    for (;;)
    {
      return 0;
      LinearLayout localLinearLayout = this.container;
      int i = 0;
      while (i < localLinearLayout.getChildCount())
      {
        View localView = localLinearLayout.getChildAt(i);
        if (((localView instanceof AdCanvasComponentView)) && (paramString.equals(((AdCanvasComponentView)localView).getData().id)))
        {
          if (localLinearLayout.getChildAt(i) != null)
          {
            int j = localLinearLayout.getChildAt(i).getTop();
            AdLog.d("GdtCanvasPageView", "form top :" + j);
            smoothScrollTo(0, j);
          }
          return i;
        }
        i += 1;
      }
    }
  }
  
  public void setFormFocusd(String paramString, boolean paramBoolean)
  {
    paramString = findArkFormView(paramString);
    if (paramString != null)
    {
      paramString = paramString.getParent();
      if ((paramString != null) && ((paramString instanceof com.tencent.ad.tangram.canvas.views.canvas.components.form.b))) {
        ((com.tencent.ad.tangram.canvas.views.canvas.components.form.b)paramString).setFocused(paramBoolean);
      }
    }
  }
  
  public void setPageViewLayoutParams(int paramInt)
  {
    if (this.container != null) {}
    try
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.container.getLayoutParams();
      localMarginLayoutParams.topMargin = paramInt;
      setLayoutParams(localMarginLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("GdtCanvasPageView", "setPageViewLayoutParams:" + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasPageView
 * JD-Core Version:    0.7.0.1
 */