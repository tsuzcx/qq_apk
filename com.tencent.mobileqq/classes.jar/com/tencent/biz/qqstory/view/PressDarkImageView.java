package com.tencent.biz.qqstory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

@TargetApi(14)
public class PressDarkImageView
  extends URLImageView
{
  public static final int[] a = { 16843210, 16843211 };
  public float b = 1.0F;
  public float c = 0.5F;
  public int d = 0;
  
  public PressDarkImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressDarkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    this.b = paramContext.getFloat(0, this.b);
    this.c = paramContext.getFloat(1, this.c);
    paramContext.recycle();
  }
  
  public void a()
  {
    if (this.d == 1)
    {
      super.clearColorFilter();
      return;
    }
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
    super.clearColorFilter();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (isPressed())
    {
      if (this.d == 1)
      {
        super.setColorFilter(436207616);
        return;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.c * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.c);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PressDarkImageView
 * JD-Core Version:    0.7.0.1
 */