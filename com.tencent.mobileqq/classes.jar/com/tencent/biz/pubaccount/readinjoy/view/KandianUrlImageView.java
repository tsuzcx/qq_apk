package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;

public class KandianUrlImageView
  extends ResizeURLImageView
{
  private boolean a;
  
  public KandianUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    if (!this.a) {
      super.onDetachedFromWindow();
    }
  }
  
  public void setIsRecyclerView(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView
 * JD-Core Version:    0.7.0.1
 */