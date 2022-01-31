package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import raf;

public class KandianUrlImageView
  extends ResizeURLImageView
{
  private raf jdField_a_of_type_Raf;
  private boolean jdField_a_of_type_Boolean;
  
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
    if (!this.jdField_a_of_type_Boolean) {
      super.onDetachedFromWindow();
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Raf != null) {
      this.jdField_a_of_type_Raf.a(paramView, paramInt);
    }
  }
  
  public void setIsRecyclerView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setVisibilityChangedListener(raf paramraf)
  {
    this.jdField_a_of_type_Raf = paramraf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView
 * JD-Core Version:    0.7.0.1
 */