package com.tencent.biz.qqcircle.immersive.views.banner;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;

public class QFSImageBanner
  extends FrameLayout
{
  private long a = 2000L;
  private long b = 1000L;
  private ViewPager2 c;
  private QFSImageBannerAdapter d;
  private QFSImageBanner.AutoLoopTask e;
  private FeedCloudMeta.StFeed f;
  private ValueAnimator g;
  private int h;
  private float i;
  private float j;
  private int k = 0;
  private List<ViewPager2.OnPageChangeCallback> l = new ArrayList();
  
  public QFSImageBanner(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSImageBanner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFSImageBanner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = new QFSImageBanner.AutoLoopTask(this);
    this.c = new ViewPager2(paramContext);
    this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.c.registerOnPageChangeCallback(c());
    this.d = new QFSImageBannerAdapter();
    this.c.setAdapter(this.d);
    addView(this.c);
  }
  
  private void a(String paramString)
  {
    FeedCloudMeta.StFeed localStFeed = this.f;
    if (localStFeed == null) {
      return;
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(localStFeed).setActionType(100).setSubActionType(2).setExt1(paramString)));
  }
  
  private ViewPager2.OnPageChangeCallback c()
  {
    return new QFSImageBanner.1(this);
  }
  
  private void setCurrentItemWithAnimation(int paramInt)
  {
    ViewPager2 localViewPager2 = this.c;
    if (localViewPager2 == null) {
      return;
    }
    this.h = 0;
    int m = localViewPager2.getCurrentItem();
    this.g = ValueAnimator.ofInt(new int[] { 0, this.c.getWidth() * (paramInt - m) });
    this.g.addUpdateListener(new QFSImageBanner.2(this));
    this.g.addListener(new QFSImageBanner.3(this));
    this.g.setInterpolator(new AccelerateDecelerateInterpolator());
    this.g.setDuration(this.b);
    this.g.start();
  }
  
  private void setTempCurrentItem(int paramInt)
  {
    this.c.setCurrentItem(paramInt, false);
  }
  
  public int a(int paramInt)
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null) {
      return 0;
    }
    return localQFSImageBannerAdapter.a(paramInt);
  }
  
  public void a()
  {
    if (!this.d.c()) {
      return;
    }
    b();
    postDelayed(this.e, this.a);
  }
  
  public void a(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback)
  {
    this.l.add(paramOnPageChangeCallback);
  }
  
  public void b()
  {
    removeCallbacks(this.e);
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if ((m == 2) && ((Math.abs(paramMotionEvent.getX() - this.i) > 5.0F) || (Math.abs(paramMotionEvent.getY() - this.j) > 5.0F))) {
        setEnableLoop(false);
      }
    }
    else
    {
      this.i = paramMotionEvent.getX();
      this.j = paramMotionEvent.getY();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public long getAnimationTime()
  {
    return this.b;
  }
  
  public int getCurrentItem()
  {
    ViewPager2 localViewPager2 = this.c;
    if (localViewPager2 == null) {
      return 0;
    }
    return a(localViewPager2.getCurrentItem());
  }
  
  public int getItemCount()
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null) {
      return 0;
    }
    return localQFSImageBannerAdapter.getItemCount();
  }
  
  public long getLoopDurationTime()
  {
    return this.a;
  }
  
  public int getRealCount()
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null) {
      return 0;
    }
    return localQFSImageBannerAdapter.a();
  }
  
  public ViewPager2 getViewPager2()
  {
    return this.c;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
    a(String.valueOf(a(this.k) + 1));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, true);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if (getRealCount() <= paramInt) {
      return;
    }
    if (this.c.isFakeDragging()) {
      this.c.endFakeDrag();
    }
    if (paramBoolean)
    {
      setCurrentItemWithAnimation(paramInt);
      return;
    }
    this.c.setCurrentItem(paramInt, false);
  }
  
  public void setData(FeedCloudMeta.StFeed paramStFeed)
  {
    this.f = paramStFeed;
    this.d.a(paramStFeed);
    this.d.notifyDataSetChanged();
  }
  
  public void setEnableLoop(boolean paramBoolean)
  {
    if (this.d.b() == paramBoolean) {
      return;
    }
    this.d.a(paramBoolean);
    if (paramBoolean)
    {
      localQFSImageBannerAdapter = this.d;
      localQFSImageBannerAdapter.notifyItemInserted(localQFSImageBannerAdapter.a());
      return;
    }
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    localQFSImageBannerAdapter.notifyItemRemoved(localQFSImageBannerAdapter.a());
    b();
  }
  
  public void setIQFSFeedIoc(IQFSFeedIoc paramIQFSFeedIoc)
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null)
    {
      QLog.i("QFSImageBanner", 1, "[setIQFSFeedIoc] mAdapter is null");
      return;
    }
    localQFSImageBannerAdapter.a(paramIQFSFeedIoc);
  }
  
  public void setLoopDurationTime(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setPlayScene(int paramInt)
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null) {
      return;
    }
    localQFSImageBannerAdapter.b(paramInt);
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null) {
      return;
    }
    localQFSImageBannerAdapter.a(paramQCircleReportBean);
  }
  
  public void setVerticalPos(int paramInt)
  {
    QFSImageBannerAdapter localQFSImageBannerAdapter = this.d;
    if (localQFSImageBannerAdapter == null)
    {
      QLog.i("QFSImageBanner", 1, "[setVerticalPos] mAdapter is null");
      return;
    }
    localQFSImageBannerAdapter.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner
 * JD-Core Version:    0.7.0.1
 */