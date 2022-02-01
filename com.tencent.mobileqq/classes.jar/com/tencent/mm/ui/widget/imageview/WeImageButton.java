package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class WeImageButton
  extends AppCompatImageButton
{
  private int a;
  private int b;
  private float c = 1.0F;
  private int d = 255;
  private int e = 255;
  private boolean f = true;
  
  public WeImageButton(Context paramContext)
  {
    super(paramContext, null);
    a(paramContext, null);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = paramContext.getResources().getColor(2131165265);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WeImageBtn);
      this.a = paramContext.getColor(R.styleable.WeImageBtn_btnIconColor, this.b);
      paramContext.recycle();
      return;
    }
    this.a = this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.f))
    {
      paramCanvas = new PorterDuffColorFilter(this.a, PorterDuff.Mode.SRC_ATOP);
      getDrawable().setColorFilter(paramCanvas);
      this.f = false;
    }
  }
  
  public void setIconColor(int paramInt)
  {
    this.a = paramInt;
    this.f = true;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageButton
 * JD-Core Version:    0.7.0.1
 */