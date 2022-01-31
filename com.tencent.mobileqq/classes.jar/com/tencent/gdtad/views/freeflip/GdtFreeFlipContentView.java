package com.tencent.gdtad.views.freeflip;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import qmr;

abstract class GdtFreeFlipContentView
  extends URLImageView
  implements qmr
{
  private boolean a;
  
  public GdtFreeFlipContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtFreeFlipContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.freeflip.GdtFreeFlipContentView
 * JD-Core Version:    0.7.0.1
 */