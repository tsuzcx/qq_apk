package com.tencent.ad.tangram.views.canvas.components.imagesCarousel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends AdCanvasComponentView
{
  private static final String TAG = "AdCanvasImagesCarouselComponentView";
  private static int WHEEL = 100;
  private static int WHEEL_WAIT = 101;
  private static int delay;
  private List<com.tencent.ad.tangram.views.canvas.components.picture.b> adCanvasPictureComponentViews;
  private b.a handler = new b.a(new WeakReference(this));
  private boolean isScrolling = false;
  private c mAdapter;
  private Context mContext;
  private int mCurrentPosition = 0;
  private ViewPager mViewPager;
  private long releaseTime = 0L;
  private b.b runnable = new b.b(new WeakReference(this));
  private int showPosition = 0;
  private a value;
  private List<View> viewList = new ArrayList();
  
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
    this.mContext = paramContext;
    init(paramContext, parama, null);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, Handler paramHandler)
  {
    super(paramContext, paramWeakReference);
    this.mContext = paramContext;
    init(paramContext, parama, paramHandler);
  }
  
  private void autoHandleScroll(Message paramMessage)
  {
    if (this.handler != null)
    {
      if (this.runnable == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("autoHandleScroll call: size=");
      localStringBuilder.append(this.viewList.size());
      localStringBuilder.append(" msg=");
      localStringBuilder.append(paramMessage);
      AdLog.i("AdCanvasImagesCarouselComponentView", localStringBuilder.toString());
      if (this.viewList.size() > 0)
      {
        if (paramMessage.what == WHEEL)
        {
          if (!this.isScrolling)
          {
            int i = (this.mCurrentPosition + 1) % this.viewList.size();
            paramMessage = new StringBuilder();
            paramMessage.append("autoHandleScroll: mCurrentPosition=");
            paramMessage.append(this.mCurrentPosition);
            paramMessage.append(" position=");
            paramMessage.append(i);
            paramMessage.append(" size: ");
            paramMessage.append(this.viewList.size());
            AdLog.i("AdCanvasImagesCarouselComponentView", paramMessage.toString());
            this.mViewPager.setCurrentItem(i, true);
          }
          this.releaseTime = System.currentTimeMillis();
        }
        this.handler.removeCallbacks(this.runnable);
        this.handler.postDelayed(this.runnable, delay);
      }
    }
  }
  
  private com.tencent.ad.tangram.views.canvas.components.picture.b getImageView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, com.tencent.ad.tangram.views.canvas.components.picture.a parama1, Handler paramHandler)
  {
    parama1.enableRoundRectBackground = parama.enableImageRoundRectBackground;
    parama1.radius = parama.imageRadius;
    parama1.borderWidth = parama.imageBorderWidth;
    parama1.borderColor = parama.imageBorderColor;
    paramContext = new com.tencent.ad.tangram.views.canvas.components.picture.b(paramContext, paramWeakReference, parama1, null, paramHandler);
    this.adCanvasPictureComponentViews.add(paramContext);
    return paramContext;
  }
  
  private void init(Context paramContext, a parama, Handler paramHandler)
  {
    if ((paramContext != null) && (parama != null))
    {
      if (!parama.isValid()) {
        return;
      }
      this.adCanvasPictureComponentViews = new ArrayList();
      this.value = parama;
      if (parama.displaySpeed > 0) {
        delay = parama.displaySpeed * 1000;
      }
      parama = new FrameLayout(paramContext);
      parama.setBackgroundColor(-1);
      parama.setClipChildren(false);
      Object localObject1 = new FrameLayout.LayoutParams(-1, -2);
      addView(parama);
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.value.marginLeft;
      ((FrameLayout.LayoutParams)localObject1).topMargin = this.value.marginTop;
      ((FrameLayout.LayoutParams)localObject1).rightMargin = this.value.marginRight;
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.value.marginBottom;
      ((FrameLayout.LayoutParams)localObject1).gravity = 0;
      parama.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.value.imageList != null)
      {
        if (this.value.imageList.size() == 0) {
          return;
        }
        this.viewList.clear();
        localObject1 = this.value.imageList.iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.ad.tangram.views.canvas.components.picture.a)((Iterator)localObject1).next();
          if (localObject2 != null) {
            this.viewList.add(getImageView(paramContext, this.canvasViewListener, this.value, (com.tencent.ad.tangram.views.canvas.components.picture.a)localObject2, paramHandler));
          }
        }
        if (this.value.imageList.size() > this.value.pageLimit)
        {
          int i = 0;
          while (i < this.value.pageLimit)
          {
            localObject1 = this.viewList;
            localObject2 = this.canvasViewListener;
            a locala = this.value;
            ((List)localObject1).add(0, getImageView(paramContext, (WeakReference)localObject2, locala, (com.tencent.ad.tangram.views.canvas.components.picture.a)locala.imageList.get(this.value.imageList.size() - 1 - i), paramHandler));
            localObject1 = this.viewList;
            localObject2 = this.canvasViewListener;
            locala = this.value;
            ((List)localObject1).add(getImageView(paramContext, (WeakReference)localObject2, locala, (com.tencent.ad.tangram.views.canvas.components.picture.a)locala.imageList.get(i), paramHandler));
            i += 1;
          }
          this.showPosition += this.value.pageLimit;
        }
        this.mAdapter = new c();
        this.mAdapter.setViewList(this.viewList);
        this.mAdapter.setPageLimit(this.value.pageLimit);
        this.mViewPager = new ViewPager(paramContext);
        this.mViewPager.setClipChildren(false);
        this.mViewPager.setOffscreenPageLimit(this.value.pageLimit * 2);
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setCurrentItem(this.showPosition);
        this.mCurrentPosition = this.showPosition;
        this.mViewPager.setPageMargin(this.value.pageMargin);
        this.mViewPager.setOnPageChangeListener(new b.1(this));
        parama.addView(this.mViewPager);
        this.mViewPager.post(new b.2(this));
        paramContext = this.handler;
        if (paramContext != null)
        {
          parama = this.runnable;
          if (parama != null) {
            paramContext.postDelayed(parama, delay);
          }
        }
      }
    }
  }
  
  public List<com.tencent.ad.tangram.views.canvas.components.picture.b> getAdCanvasPictureComponentViews()
  {
    return this.adCanvasPictureComponentViews;
  }
  
  public AdCanvasComponentData getData()
  {
    return this.value;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    b.a locala = this.handler;
    if (locala != null)
    {
      locala.removeCallbacksAndMessages(null);
      this.handler = null;
    }
    if (this.runnable != null) {
      this.runnable = null;
    }
  }
  
  public void onLocationChanged()
  {
    super.onLocationChanged();
    Object localObject = this.adCanvasPictureComponentViews;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.ad.tangram.views.canvas.components.picture.b)((Iterator)localObject).next()).onLocationChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b
 * JD-Core Version:    0.7.0.1
 */