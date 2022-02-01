package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R.styleable;

public class TabItem
  extends View
{
  public final CharSequence a;
  public final Drawable b;
  public final int c;
  
  public TabItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.hg);
    this.a = paramContext.getText(R.styleable.hj);
    this.b = paramContext.getDrawable(R.styleable.hh);
    this.c = paramContext.getResourceId(R.styleable.hi, 0);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabItem
 * JD-Core Version:    0.7.0.1
 */