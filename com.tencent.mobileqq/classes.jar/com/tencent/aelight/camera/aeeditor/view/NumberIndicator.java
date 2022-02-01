package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class NumberIndicator
  extends TextView
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  
  public NumberIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public NumberIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NumberIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" / ");
    localStringBuilder.append(this.b);
    setText(localStringBuilder.toString());
  }
  
  public void setCurrentIndex(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.b))
    {
      this.jdField_a_of_type_Int = paramInt;
      a();
      return;
    }
    throw new IllegalArgumentException("currentIndex not valid, out of range");
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_Int)
    {
      this.b = paramInt;
      a();
      return;
    }
    throw new IllegalArgumentException("totalCount not valid, totalCount < currentIndex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.NumberIndicator
 * JD-Core Version:    0.7.0.1
 */