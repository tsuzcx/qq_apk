package com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.statistics.AdTimeStatistics;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

public class c
  extends AdCanvasComponentView
  implements AdImageViewAdapter.Callback
{
  private static final int DOWNLOAD_BUTTON_HEIGHT = 40;
  private static final int DOWNLOAD_BUTTON_WIDTH = 81;
  private static final int LOGO_WIDTH = 56;
  private static final int RIGHT_MARGIN = 20;
  private String TAG = "GdtCanvasFixedButtonComplexStyle";
  private d gdtCanvasAppBtnComponentView;
  private View imageView;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public c(Context paramContext, a parama, Ad paramAd, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    super(paramContext);
    Object localObject2 = new RelativeLayout(paramContext);
    Object localObject1 = new FrameLayout.LayoutParams(-1, AdUIUtils.dp2px(76.0F, paramContext.getResources()));
    ((RelativeLayout)localObject2).setBackgroundColor(Color.parseColor("#FFFFFF"));
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    Object localObject3 = new FrameLayout(paramContext);
    ((FrameLayout)localObject3).setId(1365);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = AdUIUtils.dp2px(9.0F, paramContext.getResources());
    ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new AdImageViewAdapter.Params();
    ((AdImageViewAdapter.Params)localObject1).context = new WeakReference(getContext());
    ((AdImageViewAdapter.Params)localObject1).url = parama.imageUrl;
    ((AdImageViewAdapter.Params)localObject1).callback = new WeakReference(this);
    this.imageView = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject1);
    if (this.imageView == null)
    {
      AdLog.e(this.TAG, "build image failed");
      stopLoad(false);
      return;
    }
    ((FrameLayout)localObject3).addView(this.imageView);
    localObject1 = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(1, ((FrameLayout)localObject3).getId());
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject2).setId(1638);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.gdtCanvasAppBtnComponentView = new d(paramContext, paramWeakReference, parama, true);
    paramWeakReference = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(81.0F, getContext().getResources()), AdUIUtils.dp2px(40.0F, getContext().getResources()));
    ((RelativeLayout)localObject2).addView(this.gdtCanvasAppBtnComponentView, paramWeakReference);
    paramWeakReference = new TextView(paramContext);
    paramWeakReference.setId(2457);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AdUIUtils.dp2px(15.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    paramWeakReference.setMaxWidth(AdUIUtils.dp2px(120.0F, paramContext.getResources()));
    paramWeakReference.setText(paramAd.getAppName());
    paramWeakReference.setMaxLines(1);
    paramWeakReference.setEllipsize(TextUtils.TruncateAt.END);
    paramWeakReference.setTextColor(Color.parseColor("#000000"));
    paramWeakReference.setTextSize(18.0F);
    paramWeakReference.setTypeface(Typeface.DEFAULT_BOLD);
    ((RelativeLayout)localObject1).addView(paramWeakReference, (ViewGroup.LayoutParams)localObject3);
    paramAd = new TextView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AdUIUtils.dp2px(20.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, paramWeakReference.getId());
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, ((RelativeLayout)localObject2).getId());
    paramAd.setMaxLines(1);
    paramAd.setEllipsize(TextUtils.TruncateAt.END);
    paramAd.setTextColor(Color.parseColor("#80000000"));
    paramAd.setTextSize(14.0F);
    ((RelativeLayout)localObject1).addView(paramAd, (ViewGroup.LayoutParams)localObject3);
    paramAd.setText(AdUIUtils.getFileSizeDesc(parama.fileSize));
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setId(1911);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AdUIUtils.dp2px(15.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#CC000000"));
    ((TextView)localObject2).setTextSize(12.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setText(parama.desc);
    parama = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
    parama.setMargins(parama.leftMargin, parama.topMargin, parama.rightMargin + AdUIUtils.dp2px(101.0F, getContext().getResources()), parama.bottomMargin);
    post(new c.1(this, paramAd, paramWeakReference, paramAd.getPaint().measureText(paramAd.getText().toString())));
    this.imageView.post(new c.2(this, paramContext));
  }
  
  private void notifyLoaded(boolean paramBoolean)
  {
    if ((this.canvasViewListener == null) || (this.canvasViewListener.get() == null) || (this.loadTimeStatistics == null)) {
      AdLog.e(this.TAG, "notifyLoaded error");
    }
    long l;
    do
    {
      return;
      l = this.loadTimeStatistics.getTime();
    } while (l < 0L);
    ((AdCanvasViewListener)this.canvasViewListener.get()).onLoaded(getData(), l, paramBoolean);
  }
  
  public void doClick()
  {
    if (this.gdtCanvasAppBtnComponentView != null) {
      this.gdtCanvasAppBtnComponentView.doClick();
    }
  }
  
  public AdCanvasComponentData getData()
  {
    return null;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onActivityDestroy()
  {
    if (this.gdtCanvasAppBtnComponentView != null) {
      this.gdtCanvasAppBtnComponentView.onActivityDestroy();
    }
  }
  
  public void onActivityResume()
  {
    if (this.gdtCanvasAppBtnComponentView != null) {
      this.gdtCanvasAppBtnComponentView.onActivityResume();
    }
  }
  
  public void onStopLoad(boolean paramBoolean)
  {
    stopLoad(paramBoolean);
  }
  
  public void stopLoad(boolean paramBoolean)
  {
    if (this.loadTimeStatistics != null) {
      this.loadTimeStatistics.stop();
    }
    notifyLoaded(paramBoolean);
    this.loadTimeStatistics = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.c
 * JD-Core Version:    0.7.0.1
 */