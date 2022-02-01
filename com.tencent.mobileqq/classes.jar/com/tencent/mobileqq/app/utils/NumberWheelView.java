package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndFlingListener;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;
import java.util.List;

public class NumberWheelView
  extends WheelView
  implements AdapterView.OnItemSelectedListener, VerticalGallery.OnEndFlingListener, VerticalGallery.OnEndMovementListener, VerticalGallery.OnSelectViewDataUpdateListener
{
  public int a;
  private final int b = 0;
  private final int c = 36;
  private final int d = 18;
  private final int e = -7829368;
  private final int f = 5;
  private final int g = 1;
  private final int h = 19;
  private final int i = -16777216;
  private NumberWheelView.ScrollStateListener j;
  private Context k;
  private NumberWheelView.NumberAdapter l;
  private int m;
  private int n;
  
  public NumberWheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NumberWheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NumberWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.k = paramContext;
    this.a = 1;
    this.m = 0;
    this.n = 0;
    setNeedTranslate(true);
    setScrollCycle(true);
    setOnEndFlingListener(this);
    setOnEndMovementListener(this);
    setOnItemSelectedListener(this);
    setOnSelectViewDataUpdateListener(this);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(18.0F);
        paramView.setTextColor(-7829368);
        return;
      }
      if (paramInt == 1)
      {
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(19.0F);
        paramView.setTextColor(-16777216);
      }
    }
  }
  
  public int getCurrent()
  {
    int i1 = getSelectedItemPosition();
    if ((i1 >= 0) && (i1 < this.l.a.size())) {
      return ((Integer)this.l.a.get(i1)).intValue();
    }
    return 0;
  }
  
  public void onEndFling(VerticalGallery paramVerticalGallery)
  {
    this.a = 1;
    NumberWheelView.ScrollStateListener localScrollStateListener = this.j;
    if (localScrollStateListener != null) {
      localScrollStateListener.a(this, paramVerticalGallery);
    }
  }
  
  public void onEndMovement(VerticalGallery paramVerticalGallery)
  {
    this.a = 1;
    NumberWheelView.ScrollStateListener localScrollStateListener = this.j;
    if (localScrollStateListener != null) {
      localScrollStateListener.a(this, paramVerticalGallery);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.a = 0;
    }
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i1 = this.l.getCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      a(paramAdapterView.getChildAt(paramInt), 0);
      paramInt += 1;
    }
    a(paramView, 1);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.a = 0;
    }
    return bool;
  }
  
  public void onSelectDataUpdate(View paramView, int paramInt)
  {
    a(paramView, 1);
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.m = paramInt2;
      this.n = paramInt1;
    }
    else
    {
      this.n = paramInt2;
      this.m = paramInt1;
    }
    NumberWheelView.NumberAdapter localNumberAdapter = this.l;
    if (localNumberAdapter == null)
    {
      this.l = new NumberWheelView.NumberAdapter(this, this.k, 36, this.m, this.n);
      setAdapter(this.l);
      return;
    }
    localNumberAdapter.a(paramInt1, paramInt2);
  }
  
  public void setScrollStateListener(NumberWheelView.ScrollStateListener paramScrollStateListener)
  {
    this.j = paramScrollStateListener;
  }
  
  public void setValue(int paramInt)
  {
    int i1 = this.m;
    if (paramInt >= i1)
    {
      if (paramInt > this.n) {
        return;
      }
      setSelection(paramInt - i1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NumberWheelView
 * JD-Core Version:    0.7.0.1
 */