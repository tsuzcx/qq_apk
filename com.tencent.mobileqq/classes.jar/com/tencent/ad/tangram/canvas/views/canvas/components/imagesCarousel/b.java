package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.content.Context;
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
  private static int delay = 2000;
  private static long releaseTime = 0L;
  public int OFF_SCREEN_PAGE_LIMIT = 2;
  private int PAGE_MARGIN = 0;
  private b.a handler = new b.a(new WeakReference(this));
  private boolean isScrolling = false;
  private c mAdapter;
  private Context mContext;
  private int mCurrentPosition = 2;
  private ViewPager mViewPager;
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
    init(paramContext, parama);
  }
  
  private void autoHandleScroll(Message paramMessage)
  {
    if ((this.handler == null) || (this.runnable == null)) {}
    while (this.viewList.size() <= 0) {
      return;
    }
    if (paramMessage.what == WHEEL)
    {
      if (!this.isScrolling)
      {
        int i = (this.mCurrentPosition + 1) % this.viewList.size();
        AdLog.i("AdCanvasImagesCarouselComponentView", "autoHandleScroll: mCurrentPosition=" + this.mCurrentPosition + " position=" + i);
        this.mViewPager.setCurrentItem(i, true);
      }
      releaseTime = System.currentTimeMillis();
    }
    this.handler.removeCallbacks(this.runnable);
    this.handler.postDelayed(this.runnable, delay);
  }
  
  private com.tencent.ad.tangram.canvas.views.canvas.components.picture.b getImageView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, com.tencent.ad.tangram.canvas.views.canvas.components.picture.a parama)
  {
    parama.enableRoundRectBackground = true;
    parama.radius = com.tencent.ad.tangram.canvas.views.a.dp2px(8.0F, paramContext.getResources());
    parama.borderWidth = com.tencent.ad.tangram.canvas.views.a.dp2px(1.0F, paramContext.getResources());
    return new com.tencent.ad.tangram.canvas.views.canvas.components.picture.b(paramContext, paramWeakReference, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)com.tencent.ad.tangram.canvas.views.canvas.components.picture.a.class.cast(parama), null);
  }
  
  private void init(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null) || (!parama.isValid())) {}
    do
    {
      do
      {
        return;
        this.value = parama;
        if (parama.displaySpeed > 0) {
          delay = parama.displaySpeed * 1000;
        }
        this.PAGE_MARGIN = com.tencent.ad.tangram.canvas.views.a.dp2px(10.0F, paramContext.getResources());
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
          this.viewList.add(getImageView(paramContext, this.canvasViewListener, locala));
        }
      }
      if (this.value.imageList.size() > this.OFF_SCREEN_PAGE_LIMIT)
      {
        int i = 0;
        while (i < this.OFF_SCREEN_PAGE_LIMIT)
        {
          this.viewList.add(0, getImageView(paramContext, this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)com.tencent.ad.tangram.canvas.views.canvas.components.picture.a.class.cast(this.value.imageList.get(this.value.imageList.size() - 1 - i))));
          this.viewList.add(getImageView(paramContext, this.canvasViewListener, (com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)com.tencent.ad.tangram.canvas.views.canvas.components.picture.a.class.cast(this.value.imageList.get(i))));
          i += 1;
        }
        this.showPosition += this.OFF_SCREEN_PAGE_LIMIT;
      }
      this.mAdapter = new c();
      this.mAdapter.setViewList(this.viewList);
      this.mViewPager = new ViewPager(paramContext);
      this.mViewPager.setClipChildren(false);
      this.mViewPager.setOffscreenPageLimit(this.OFF_SCREEN_PAGE_LIMIT * 2);
      this.mViewPager.setAdapter(this.mAdapter);
      this.mViewPager.setCurrentItem(this.showPosition);
      this.mViewPager.setPageMargin(this.PAGE_MARGIN);
      this.mViewPager.setOnPageChangeListener(new b.1(this));
      parama.addView(this.mViewPager);
      this.mViewPager.post(new b.2(this));
    } while ((this.handler == null) || (this.runnable == null));
    this.handler.postDelayed(this.runnable, delay);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b
 * JD-Core Version:    0.7.0.1
 */