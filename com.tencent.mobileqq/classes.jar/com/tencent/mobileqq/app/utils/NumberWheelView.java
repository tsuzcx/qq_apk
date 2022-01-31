package com.tencent.mobileqq.app.utils;

import akwd;
import akwe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import bfpv;
import bfxa;
import bfxb;
import bfxc;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import java.util.List;

public class NumberWheelView
  extends WheelView
  implements bfpv, bfxa, bfxb, bfxc
{
  public int a;
  private akwd jdField_a_of_type_Akwd;
  private akwe jdField_a_of_type_Akwe;
  private Context jdField_a_of_type_AndroidContentContext;
  private final int h = 0;
  private final int i = 36;
  private final int j = 18;
  private final int k = -7829368;
  private final int l = 5;
  private final int m = 1;
  private final int n = 19;
  private final int o = -16777216;
  private int p;
  private int q;
  
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
    this.p = 0;
    this.q = 0;
    setNeedTranslate(true);
    setScrollCycle(true);
    setOnEndFlingListener(this);
    setOnEndMovementListener(this);
    setOnItemSelectedListener(this);
    setOnSelectViewDataUpdateListener(this);
  }
  
  private void b(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt != 0) {
        break label30;
      }
      ((WheelTextView)paramView).setTextSize(18.0F);
      ((WheelTextView)paramView).setTextColor(-7829368);
    }
    label30:
    while (paramInt != 1) {
      return;
    }
    ((WheelTextView)paramView).setTextSize(19.0F);
    ((WheelTextView)paramView).setTextColor(-16777216);
  }
  
  public int a()
  {
    int i1 = getSelectedItemPosition();
    if ((i1 < 0) || (i1 >= this.jdField_a_of_type_Akwd.a.size())) {
      return 0;
    }
    return ((Integer)this.jdField_a_of_type_Akwd.a.get(i1)).intValue();
  }
  
  public void a(View paramView, int paramInt)
  {
    b(paramView, 1);
  }
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i1 = this.jdField_a_of_type_Akwd.getCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      b(paramAdapterView.getChildAt(paramInt), 0);
      paramInt += 1;
    }
    b(paramView, 1);
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_Akwe != null) {
      this.jdField_a_of_type_Akwe.a(this, paramVerticalGallery);
    }
  }
  
  public void b(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_Akwe != null) {
      this.jdField_a_of_type_Akwe.a(this, paramVerticalGallery);
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
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (bool) {
      this.jdField_a_of_type_Int = 0;
    }
    return bool;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.p = paramInt2;
      this.q = paramInt1;
    }
    while (this.jdField_a_of_type_Akwd == null)
    {
      this.jdField_a_of_type_Akwd = new akwd(this, this.jdField_a_of_type_AndroidContentContext, 36, this.p, this.q);
      setAdapter(this.jdField_a_of_type_Akwd);
      return;
      this.q = paramInt2;
      this.p = paramInt1;
    }
    this.jdField_a_of_type_Akwd.a(paramInt1, paramInt2);
  }
  
  public void setScrollStateListener(akwe paramakwe)
  {
    this.jdField_a_of_type_Akwe = paramakwe;
  }
  
  public void setValue(int paramInt)
  {
    if ((paramInt < this.p) || (paramInt > this.q)) {
      return;
    }
    setSelection(paramInt - this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NumberWheelView
 * JD-Core Version:    0.7.0.1
 */