package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.log.AdLog;
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
  private List<com.tencent.ad.tangram.canvas.views.canvas.components.picture.b> adCanvasPictureComponentViews;
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
    if ((this.handler == null) || (this.runnable == null)) {}
    do
    {
      return;
      AdLog.i("AdCanvasImagesCarouselComponentView", "autoHandleScroll call: size=" + this.viewList.size() + " msg=" + paramMessage);
    } while (this.viewList.size() <= 0);
    if (paramMessage.what == WHEEL)
    {
      if (!this.isScrolling)
      {
        int i = (this.mCurrentPosition + 1) % this.viewList.size();
        AdLog.i("AdCanvasImagesCarouselComponentView", "autoHandleScroll: mCurrentPosition=" + this.mCurrentPosition + " position=" + i + " size: " + this.viewList.size());
        this.mViewPager.setCurrentItem(i, true);
      }
      this.releaseTime = System.currentTimeMillis();
    }
    this.handler.removeCallbacks(this.runnable);
    this.handler.postDelayed(this.runnable, delay);
  }
  
  private com.tencent.ad.tangram.canvas.views.canvas.components.picture.b getImageView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, com.tencent.ad.tangram.canvas.views.canvas.components.picture.a parama1, Handler paramHandler)
  {
    parama1.enableRoundRectBackground = parama.enableImageRoundRectBackground;
    parama1.radius = parama.imageRadius;
    parama1.borderWidth = parama.imageBorderWidth;
    parama1.borderColor = parama.imageBorderColor;
    paramContext = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.b(paramContext, paramWeakReference, parama1, null, paramHandler);
    this.adCanvasPictureComponentViews.add(paramContext);
    return paramContext;
  }
  
  private void init(Context paramContext, a parama, Handler paramHandler)
  {
    if ((paramContext == null) || (parama == null) || (!parama.isValid())) {}
    do
    {
      do
      {
        return;
        this.adCanvasPictureComponentViews = new ArrayList();
        this.value = parama;
        if (parama.displaySpeed > 0) {
          delay = parama.displaySpeed * 1000;
        }
        parama = new FrameLayout(paramContext);
        parama.setBackgroundColor(-1);
        parama.setClipChildren(false);
        localObject = new FrameLayout.LayoutParams(-1, -2);
        addView(parama);
        ((FrameLayout.LayoutParams)localObject).leftMargin = this.value.marginLeft;
        ((FrameLayout.LayoutParams)localObject).topMargin = this.value.marginTop;
        ((FrameLayout.LayoutParams)localObject).rightMargin = this.value.marginRight;
        ((FrameLayout.LayoutParams)localObject).bottomMargin = this.value.marginBottom;
        ((FrameLayout.LayoutParams)localObject).gravity = 0;
        parama.setLayoutParams((ViewGroup.LayoutParams)localObject);
      } while ((this.value.imageList == null) || (this.value.imageList.size() == 0));
      this.viewList.clear();
      Object localObject = this.value.imageList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.ad.tangram.canvas.views.canvas.components.picture.a locala = (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)((Iterator)localObject).next();
        if (locala != null) {
          this.viewList.add(getImageView(paramContext, this.canvasViewListener, this.value, locala, paramHandler));
        }
      }
      if (this.value.imageList.size() > this.value.pageLimit)
      {
        int i = 0;
        while (i < this.value.pageLimit)
        {
          this.viewList.add(0, getImageView(paramContext, this.canvasViewListener, this.value, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)this.value.imageList.get(this.value.imageList.size() - 1 - i), paramHandler));
          this.viewList.add(getImageView(paramContext, this.canvasViewListener, this.value, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)this.value.imageList.get(i), paramHandler));
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
    } while ((this.handler == null) || (this.runnable == null));
    this.handler.postDelayed(this.runnable, delay);
  }
  
  public List<com.tencent.ad.tangram.canvas.views.canvas.components.picture.b> getAdCanvasPictureComponentViews()
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
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
    if (this.runnable != null) {
      this.runnable = null;
    }
  }
  
  public void onLocationChanged()
  {
    super.onLocationChanged();
    if (this.adCanvasPictureComponentViews != null)
    {
      Iterator localIterator = this.adCanvasPictureComponentViews.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.b)localIterator.next()).onLocationChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b
 * JD-Core Version:    0.7.0.1
 */