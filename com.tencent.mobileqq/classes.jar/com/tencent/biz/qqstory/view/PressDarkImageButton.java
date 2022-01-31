package com.tencent.biz.qqstory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageButton;

@TargetApi(14)
public class PressDarkImageButton
  extends ImageButton
{
  public static final int[] a;
  public float a;
  private boolean a;
  public float b = 0.5F;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 16843210, 16843211 };
  }
  
  public PressDarkImageButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Float = paramContext.getFloat(0, this.jdField_a_of_type_Float);
    this.b = paramContext.getFloat(1, this.b);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (isPressed())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.b * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.b);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.jdField_a_of_type_Float);
      return;
    }
    super.clearColorFilter();
  }
  
  public void setEnableDark(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        super.setImageAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      }
    }
    else {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.jdField_a_of_type_Float);
      return;
    }
    super.clearColorFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PressDarkImageButton
 * JD-Core Version:    0.7.0.1
 */