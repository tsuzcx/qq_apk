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
  public final int a;
  public final Drawable a;
  public final CharSequence a;
  
  public TabItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ax);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getText(R.styleable.eS);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(R.styleable.eQ);
    this.jdField_a_of_type_Int = paramContext.getResourceId(R.styleable.eR, 0);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabItem
 * JD-Core Version:    0.7.0.1
 */