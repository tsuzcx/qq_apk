package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.PaintDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class KanDianRoundCornerTextView
  extends TextView
{
  private float jdField_a_of_type_Float = 0.4F;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "#000000";
  
  public KanDianRoundCornerTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setCornerRadius(this.jdField_a_of_type_Int);
    localPaintDrawable.setColorFilter(Color.parseColor(this.jdField_a_of_type_JavaLangString), PorterDuff.Mode.SRC_ATOP);
    localPaintDrawable.setAlpha((int)(255.0F * this.jdField_a_of_type_Float));
    setBackgroundDrawable(localPaintDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView
 * JD-Core Version:    0.7.0.1
 */