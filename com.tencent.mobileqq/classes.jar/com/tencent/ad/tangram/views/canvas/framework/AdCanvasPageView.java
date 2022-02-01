package com.tencent.ad.tangram.views.canvas.framework;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.c;
import com.tencent.ad.tangram.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.views.canvas.components.layerCard.AdCanvasLayerCardView;
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
    a locala = null;
    parama = null;
    if (paramAdCanvasComponentData != null)
    {
      if (!paramAdCanvasComponentData.isValid()) {
        return null;
      }
      if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.appInfoButton.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.appInfoButton.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.appInfoButton.a)paramAdCanvasComponentData, true);
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.picture.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.picture.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.picture.a)com.tencent.ad.tangram.views.canvas.components.picture.a.class.cast(paramAdCanvasComponentData), null, this.mHandler);
      } else if ((paramAdCanvasComponentData instanceof c)) {
        parama = new d(getContext(), this.canvasViewListener, (c)c.class.cast(paramAdCanvasComponentData), ((c)c.class.cast(paramAdCanvasComponentData)).canShowProgress);
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.pictures.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.pictures.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.pictures.a)com.tencent.ad.tangram.views.canvas.components.pictures.a.class.cast(paramAdCanvasComponentData), this.mHandler);
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a)com.tencent.ad.tangram.views.canvas.components.imagesCarousel.a.class.cast(paramAdCanvasComponentData));
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.appIcon.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.appIcon.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.appIcon.a)com.tencent.ad.tangram.views.canvas.components.appIcon.a.class.cast(paramAdCanvasComponentData));
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.text.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.text.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.text.a)paramAdCanvasComponentData);
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.layerCard.a)) {
        parama = new AdCanvasLayerCardView(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.layerCard.a)paramAdCanvasComponentData, this.mHandler);
      } else if ((paramAdCanvasComponentData instanceof com.tencent.ad.tangram.views.canvas.components.title.a)) {
        parama = new com.tencent.ad.tangram.views.canvas.components.title.b(getContext(), this.canvasViewListener, (com.tencent.ad.tangram.views.canvas.components.title.a)paramAdCanvasComponentData);
      }
      locala = parama;
      if (parama != null)
      {
        parama.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        locala = parama;
      }
    }
    return locala;
  }
  
  private void initView(a parama)
  {
    if (parama != null)
    {
      if (!parama.isValid()) {
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
      while (i < j)
      {
        localObject = getComponentViewFromData(parama.getComponent(i), parama);
        if (localObject != null) {
          this.container.addView((View)localObject);
        }
        i += 1;
      }
    }
  }
  
  public boolean back()
  {
    int i = 0;
    while (i < getCount())
    {
      if (getView(i).back()) {
        return true;
      }
      i += 1;
    }
    return false;
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
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      if (!(getChildAt(0) instanceof ViewGroup)) {
        return null;
      }
      View localView = ((ViewGroup)getChildAt(0)).getChildAt(paramInt);
      if (!(localView instanceof AdCanvasComponentView)) {
        return null;
      }
      return (AdCanvasComponentView)localView;
    }
    return null;
  }
  
  public void onActivityDestroy()
  {
    int i = 0;
    while (i < getCount())
    {
      getView(i).onActivityDestroy();
      i += 1;
    }
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
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
  
  protected void onAttachedToWindow()
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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 2)) && (Math.abs(f1 - this.mDownPosX) > Math.abs(f2 - this.mDownPosY))) {
        return false;
      }
    }
    else
    {
      this.mDownPosX = f1;
      this.mDownPosY = f2;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
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
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    onLocationChanged();
  }
  
  public void setPageViewLayoutParams(int paramInt)
  {
    Object localObject = this.container;
    if (localObject != null) {
      try
      {
        localObject = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt;
        setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPageViewLayoutParams:");
        localStringBuilder.append(localThrowable);
        AdLog.e("GdtCanvasPageView", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.AdCanvasPageView
 * JD-Core Version:    0.7.0.1
 */