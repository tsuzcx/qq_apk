package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class NumberIndicator
  extends TextView
{
  private boolean a = false;
  private int b;
  private int c;
  
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
    localStringBuilder.append(this.b);
    localStringBuilder.append(" / ");
    localStringBuilder.append(this.c);
    setText(localStringBuilder.toString());
  }
  
  public void setCurrentIndex(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.c))
    {
      this.b = paramInt;
      a();
      return;
    }
    throw new IllegalArgumentException("currentIndex not valid, out of range");
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt >= this.b)
    {
      this.c = paramInt;
      a();
      return;
    }
    throw new IllegalArgumentException("totalCount not valid, totalCount < currentIndex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.NumberIndicator
 * JD-Core Version:    0.7.0.1
 */