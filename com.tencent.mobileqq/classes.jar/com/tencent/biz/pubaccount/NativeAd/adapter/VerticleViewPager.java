package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class VerticleViewPager
  extends ViewPager
{
  public VerticleViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VerticleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMotionEvent.setLocation(paramMotionEvent.getY() / f2 * f1, paramMotionEvent.getX() / f1 * f2);
    return paramMotionEvent;
  }
  
  private void a()
  {
    setPageTransformer(true, new VerticleViewPager.VerticalPageTransformer(this, null));
    setOverScrollMode(2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(a(paramMotionEvent));
    a(paramMotionEvent);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(a(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.VerticleViewPager
 * JD-Core Version:    0.7.0.1
 */