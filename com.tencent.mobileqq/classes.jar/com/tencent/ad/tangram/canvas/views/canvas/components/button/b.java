package com.tencent.ad.tangram.canvas.views.canvas.components.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.canvas.views.xijing.AdButtonView;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "GdtCanvasButtonComponentView";
  private a data;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama);
  }
  
  private void doClick(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (this.canvasViewListener.get() != null) {
      ((AdCanvasViewListener)this.canvasViewListener.get()).commonButtonClick(paramString1, paramBoolean, paramString2, paramString3);
    }
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void init(Context paramContext, a parama)
  {
    startLoad();
    if ((parama == null) || (!parama.isValid()) || (getResources() == null))
    {
      AdLog.e("GdtCanvasButtonComponentView", "init error");
      stopLoad(false);
      return;
    }
    this.data = parama;
    Object localObject;
    if (getData().isFixed)
    {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().toBottom + getData().paddingBottom);
      paramContext = new AdButtonView(paramContext, getData().button);
      localObject = new FrameLayout.LayoutParams(getData().width, getData().height);
      ((FrameLayout.LayoutParams)localObject).gravity = (this.data.gravity | 0x10);
      if (this.data.gravity != 17) {
        break label300;
      }
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
    }
    for (;;)
    {
      addView(paramContext, (ViewGroup.LayoutParams)localObject);
      localObject = parama.actionUrl;
      paramContext.setOnClickListener(new b.1(this, parama.linkType, parama.isFixed, (String)localObject, parama.formModId));
      this.status = new AdViewStatus(new WeakReference(paramContext), new WeakReference(this));
      stopLoad(true);
      return;
      setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
      break;
      label300:
      if (this.data.gravity == 3) {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
      } else if (this.data.gravity == 5) {
        ((FrameLayout.LayoutParams)localObject).gravity = 5;
      } else {
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.button.b
 * JD-Core Version:    0.7.0.1
 */