package com.tencent.ad.tangram.canvas.views.canvas.components.picture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasPageView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b
  extends AdCanvasComponentView
  implements AdImageViewAdapter.Callback
{
  private static final String TAG = "GdtCanvasPictureComponentView";
  private com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b containerHelper;
  private a data;
  private Boolean hasImageLoad = Boolean.valueOf(false);
  private com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b helper;
  private Handler imageLoadHandler;
  private View imageView;
  private volatile boolean needNoticeToLoadImage;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, View.OnTouchListener paramOnTouchListener)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama, paramOnTouchListener);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, View.OnTouchListener paramOnTouchListener, Handler paramHandler)
  {
    super(paramContext, paramWeakReference);
    this.imageLoadHandler = paramHandler;
    init(paramContext, parama, paramOnTouchListener);
  }
  
  private void firstLoadExp(Context paramContext, a parama)
  {
    AdImageViewAdapter.Params localParams = new AdImageViewAdapter.Params();
    localParams.context = new WeakReference(paramContext);
    localParams.callback = new WeakReference(this);
    localParams.url = parama.url;
    localParams.gaussianUrl = parama.gaussianUrl;
    localParams.isHitImageExp = true;
    this.needNoticeToLoadImage = true;
    if (parama.isLoadFirst)
    {
      this.hasImageLoad = Boolean.valueOf(true);
      this.imageView = AdImageViewBuilder.buildImageView(localParams);
      AdLog.d("GdtCanvasPictureComponentView", "load image, the image url is " + localParams.url);
    }
    for (;;)
    {
      if (this.imageView == null)
      {
        AdLog.e("GdtCanvasPictureComponentView", "build image failed");
        stopLoad(false);
      }
      return;
      localParams.isOnlyLoadGaussianUrl = true;
      this.imageView = AdImageViewBuilder.buildImageView(localParams);
      AdLog.d("GdtCanvasPictureComponentView", "load guassian image, the image url is " + parama.url);
    }
  }
  
  private void init(Context paramContext, a parama, View.OnTouchListener paramOnTouchListener)
  {
    startLoad();
    if ((parama == null) || (!parama.isValid()))
    {
      stopLoad(false);
      return;
    }
    this.data = parama;
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    Object localObject = new RelativeLayout(paramContext);
    if (parama.isHotAreaValild())
    {
      ArrayList localArrayList = parama.hotAreaList;
      int i = 0;
      while (i < localArrayList.size())
      {
        Button localButton = new Button(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((c)localArrayList.get(i)).width, ((c)localArrayList.get(i)).height);
        localLayoutParams.topMargin = ((c)localArrayList.get(i)).y;
        localLayoutParams.leftMargin = ((c)localArrayList.get(i)).x;
        localButton.setLayoutParams(localLayoutParams);
        localButton.setBackgroundColor(0);
        ((RelativeLayout)localObject).addView(localButton);
        localButton.setOnClickListener(new b.a(this, ((c)localArrayList.get(i)).linkType, ((c)localArrayList.get(i)).formModId, ((c)localArrayList.get(i)).url));
        i += 1;
      }
    }
    addView((View)localObject);
    localLinearLayout.setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
    if (parama.hitLoadImageExp) {
      firstLoadExp(paramContext, parama);
    }
    while ((this.imageView == null) || (!(this.imageView instanceof ImageView)))
    {
      AdLog.e("GdtCanvasPictureComponentView", "buildImageView Failed");
      stopLoad(false);
      return;
      localObject = new AdImageViewAdapter.Params();
      ((AdImageViewAdapter.Params)localObject).context = new WeakReference(paramContext);
      ((AdImageViewAdapter.Params)localObject).url = parama.url;
      ((AdImageViewAdapter.Params)localObject).gaussianUrl = parama.gaussianUrl;
      ((AdImageViewAdapter.Params)localObject).callback = new WeakReference(this);
      this.imageView = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject);
      this.hasImageLoad = Boolean.valueOf(true);
    }
    if (parama.enableRoundRectBackground)
    {
      this.containerHelper = new com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b(new WeakReference(localLinearLayout));
      this.containerHelper.setRadius(this.data.radius);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext = (ViewGroup.MarginLayoutParams)localLinearLayout.getLayoutParams();
        paramContext.leftMargin = this.data.borderWidth;
        paramContext.topMargin = this.data.borderWidth;
        paramContext.rightMargin = this.data.borderWidth;
        paramContext.bottomMargin = this.data.borderWidth;
        localLinearLayout.setLayoutParams(paramContext);
      }
      this.helper = new com.tencent.ad.tangram.canvas.views.canvas.components.roundview.b(new WeakReference(this));
      this.helper.setBorderColor(Color.parseColor(this.data.borderColor));
      this.helper.setBorderWidth(this.data.borderWidth);
      this.helper.setRadius(this.data.radius);
    }
    localLinearLayout.addView(this.imageView);
    paramContext = this.imageView.getLayoutParams();
    paramContext.width = getData().width;
    paramContext.height = getData().height;
    this.imageView.setLayoutParams(paramContext);
    if (paramOnTouchListener != null) {
      this.imageView.setOnTouchListener(paramOnTouchListener);
    }
    for (;;)
    {
      this.status = new AdViewStatus(new WeakReference(this.imageView), new WeakReference(this));
      return;
      this.imageView.setOnTouchListener(new b.b(new b.1(this, parama), getResources()));
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.helper != null) {
      this.helper.dispatchDraw(paramCanvas);
    }
    if (this.containerHelper != null) {
      this.containerHelper.dispatchDraw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.helper != null) {
      this.helper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.containerHelper != null) {
      this.containerHelper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLocationChanged()
  {
    AdViewStatus localAdViewStatus;
    if (!this.status.visible)
    {
      double d = AdUIUtils.getPercentageOfGlobalVisibleRect(this.imageView);
      localAdViewStatus = this.status;
      if (d <= 0.0D) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      localAdViewStatus.visible = bool;
      if (this.status.visible) {
        refreshImageView();
      }
      return;
    }
  }
  
  public void onStopLoad(boolean paramBoolean)
  {
    stopLoad(paramBoolean);
    AdLog.d("GdtCanvasPictureComponentView", "loaded image, the image url is " + this.data.url);
    if ((this.canvasViewListener.get() != null) && (((AdCanvasViewListener)this.canvasViewListener.get()).getContentView() != null) && (this.imageLoadHandler == null)) {
      this.imageLoadHandler = ((AdCanvasViewListener)this.canvasViewListener.get()).getContentView().getMHandler();
    }
    if ((this.imageLoadHandler != null) && (this.needNoticeToLoadImage)) {
      this.imageLoadHandler.sendEmptyMessage(1);
    }
  }
  
  public void onViewResume()
  {
    super.onViewResume();
    refreshImageView();
  }
  
  public void refreshImageView()
  {
    AdLog.d("GdtCanvasPictureComponentView", "notice to refresh image, the image url is " + this.data.url);
    try
    {
      if (!this.hasImageLoad.booleanValue())
      {
        AdLog.d("GdtCanvasPictureComponentView", "refresh image, the image url is " + this.data.url);
        this.hasImageLoad = Boolean.valueOf(true);
        AdImageViewAdapter.Params localParams = new AdImageViewAdapter.Params();
        localParams.context = new WeakReference(getContext());
        localParams.url = this.data.url;
        localParams.isOnlyLoadGaussianUrl = false;
        localParams.callback = new WeakReference(this);
        AdImageViewBuilder.buildImageView(localParams, this.imageView);
        this.needNoticeToLoadImage = false;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.picture.b
 * JD-Core Version:    0.7.0.1
 */