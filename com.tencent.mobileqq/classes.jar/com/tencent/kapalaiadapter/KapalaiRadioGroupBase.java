package com.tencent.kapalaiadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

public class KapalaiRadioGroupBase
  extends RadioGroup
{
  public KapalaiRadioGroupBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public KapalaiRadioGroupBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void init() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kapalaiadapter.KapalaiRadioGroupBase
 * JD-Core Version:    0.7.0.1
 */