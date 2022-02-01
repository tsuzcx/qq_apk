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
  private Context jdField_a_of_type_AndroidContentContext;
  private NumberWheelView.NumberAdapter jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter;
  private NumberWheelView.ScrollStateListener jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$ScrollStateListener;
  private final int b = 0;
  private final int c = 36;
  private final int d = 18;
  private final int e = -7829368;
  private final int f = 5;
  private final int g = 1;
  private final int h = 19;
  private final int i = -16777216;
  private int j;
  private int k;
  
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = 1;
    this.j = 0;
    this.k = 0;
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
  
  public int a()
  {
    int m = getSelectedItemPosition();
    if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter.a.size())) {
      return ((Integer)this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter.a.get(m)).intValue();
    }
    return 0;
  }
  
  public void onEndFling(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = 1;
    NumberWheelView.ScrollStateListener localScrollStateListener = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$ScrollStateListener;
    if (localScrollStateListener != null) {
      localScrollStateListener.a(this, paramVerticalGallery);
    }
  }
  
  public void onEndMovement(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = 1;
    NumberWheelView.ScrollStateListener localScrollStateListener = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$ScrollStateListener;
    if (localScrollStateListener != null) {
      localScrollStateListener.a(this, paramVerticalGallery);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.jdField_a_of_type_Int = 0;
    }
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter.getCount();
    paramInt = 0;
    while (paramInt < m)
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
      this.jdField_a_of_type_Int = 0;
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
      this.j = paramInt2;
      this.k = paramInt1;
    }
    else
    {
      this.k = paramInt2;
      this.j = paramInt1;
    }
    NumberWheelView.NumberAdapter localNumberAdapter = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter;
    if (localNumberAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter = new NumberWheelView.NumberAdapter(this, this.jdField_a_of_type_AndroidContentContext, 36, this.j, this.k);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$NumberAdapter);
      return;
    }
    localNumberAdapter.a(paramInt1, paramInt2);
  }
  
  public void setScrollStateListener(NumberWheelView.ScrollStateListener paramScrollStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView$ScrollStateListener = paramScrollStateListener;
  }
  
  public void setValue(int paramInt)
  {
    int m = this.j;
    if (paramInt >= m)
    {
      if (paramInt > this.k) {
        return;
      }
      setSelection(paramInt - m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NumberWheelView
 * JD-Core Version:    0.7.0.1
 */