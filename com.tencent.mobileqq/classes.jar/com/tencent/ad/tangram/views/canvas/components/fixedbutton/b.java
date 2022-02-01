package com.tencent.ad.tangram.views.canvas.components.fixedbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "GdtCanvasButtonComponentView";
  private View fixedView = null;
  private a gdtCanvasFixedButtonComponentData;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    super(paramContext, paramWeakReference);
  }
  
  public void doClick()
  {
    View localView = this.fixedView;
    if (localView != null)
    {
      if ((localView instanceof c))
      {
        ((c)localView).doClick();
        return;
      }
      if ((localView instanceof d)) {
        ((d)localView).doClick();
      }
    }
  }
  
  public String getButtonStyle()
  {
    return this.gdtCanvasFixedButtonComponentData.buttonStyle;
  }
  
  public a getData()
  {
    return this.gdtCanvasFixedButtonComponentData;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void init(Context paramContext, a parama, Ad paramAd, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    startLoad();
    if ((parama != null) && (parama.isValid()))
    {
      this.gdtCanvasFixedButtonComponentData = parama;
      if (this.gdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-1"))
      {
        this.fixedView = new c(paramContext, this.gdtCanvasFixedButtonComponentData, paramAd, paramWeakReference);
        paramContext = new RelativeLayout.LayoutParams(-1, -2);
      }
      else
      {
        if (!this.gdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-2")) {
          break label187;
        }
        this.fixedView = new d(paramContext, paramWeakReference, parama, true);
        paramContext = new RelativeLayout.LayoutParams(-1, this.gdtCanvasFixedButtonComponentData.height + this.gdtCanvasFixedButtonComponentData.paddingTop + this.gdtCanvasFixedButtonComponentData.paddingBottom);
        this.fixedView.setBackgroundColor(-1);
      }
      addView(this.fixedView, paramContext);
      this.status = new AdViewStatus(new WeakReference(this.fixedView), new WeakReference(this));
      stopLoad(true);
      return;
      label187:
      AdLog.e("GdtCanvasButtonComponentView", "buttonStyle unknown");
      stopLoad(false);
      return;
    }
    AdLog.e("GdtCanvasButtonComponentView", "init error");
    stopLoad(false);
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    View localView = this.fixedView;
    if (localView != null) {
      ((AdCanvasComponentView)localView).onActivityDestroy();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    View localView = this.fixedView;
    if (localView != null) {
      ((AdCanvasComponentView)localView).onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.fixedbutton.b
 * JD-Core Version:    0.7.0.1
 */