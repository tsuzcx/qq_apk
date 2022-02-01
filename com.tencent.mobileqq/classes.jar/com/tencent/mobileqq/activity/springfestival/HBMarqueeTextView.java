package com.tencent.mobileqq.activity.springfestival;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

@SuppressLint({"AppCompatCustomView"})
public class HBMarqueeTextView
  extends TextView
{
  public HBMarqueeTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HBMarqueeTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HBMarqueeTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isFocused()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBMarqueeTextView
 * JD-Core Version:    0.7.0.1
 */