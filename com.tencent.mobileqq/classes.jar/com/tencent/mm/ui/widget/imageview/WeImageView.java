package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class WeImageView
  extends AppCompatImageView
{
  private int a;
  private float b = 1.0F;
  private int c;
  private int d = 255;
  private int e = 255;
  private boolean f = true;
  private boolean g = false;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public WeImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public WeImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.c = paramContext.getResources().getColor(2131165265);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WeImageView);
      this.a = paramContext.getColor(R.styleable.WeImageView_iconColor, this.c);
      this.b = paramContext.getFloat(R.styleable.WeImageView_iconAlpha, 1.0F);
      paramContext.recycle();
      return;
    }
    this.a = this.c;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int i = this.d;
    if (isPressed()) {
      i = 127;
    } else if (isEnabled()) {
      i = this.d;
    }
    if ((!isEnabled()) || (!isFocusable())) {
      i = 255;
    }
    if (i != this.e)
    {
      this.e = i;
      if (getDrawable() != null) {
        getDrawable().setAlpha(i);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.g) && (this.f))
    {
      getDrawable().mutate().clearColorFilter();
      this.g = false;
      this.f = false;
      return;
    }
    if ((getDrawable() != null) && (this.f))
    {
      int j = this.a;
      int i = j;
      if (j != 0) {
        i = j & 0xFFFFFF | 0xFF000000;
      }
      j = Color.alpha(this.a);
      float f1 = this.b;
      if (f1 != 1.0F) {
        j = (int)(f1 * 255.0F);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.a != 0)
      {
        this.d = j;
        getDrawable().setAlpha(j);
      }
      this.f = false;
    }
  }
  
  public void setClearColorFilter(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.f = true;
    invalidate();
  }
  
  public void setIconColor(int paramInt)
  {
    this.a = paramInt;
    this.f = true;
    invalidate();
  }
  
  public void setIconColor(int paramInt, float paramFloat)
  {
    this.a = paramInt;
    this.b = paramFloat;
    this.f = true;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */