package com.bumptech.glide.request.target;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable
  extends Drawable
{
  private final Matrix a;
  private final RectF b;
  private final RectF c;
  private Drawable d;
  private FixedSizeDrawable.State e;
  private boolean f;
  
  public FixedSizeDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this(new FixedSizeDrawable.State(paramDrawable.getConstantState(), paramInt1, paramInt2), paramDrawable);
  }
  
  FixedSizeDrawable(FixedSizeDrawable.State paramState, Drawable paramDrawable)
  {
    this.e = ((FixedSizeDrawable.State)Preconditions.a(paramState));
    this.d = ((Drawable)Preconditions.a(paramDrawable));
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    this.a = new Matrix();
    this.b = new RectF(0.0F, 0.0F, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    this.c = new RectF();
  }
  
  private void a()
  {
    this.a.setRectToRect(this.b, this.c, Matrix.ScaleToFit.CENTER);
  }
  
  public void clearColorFilter()
  {
    this.d.clearColorFilter();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.a);
    this.d.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  @RequiresApi(19)
  public int getAlpha()
  {
    return this.d.getAlpha();
  }
  
  public Drawable.Callback getCallback()
  {
    return this.d.getCallback();
  }
  
  public int getChangingConfigurations()
  {
    return this.d.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.e;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.d.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.e.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.e.a;
  }
  
  public int getMinimumHeight()
  {
    return this.d.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.d.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.d.getOpacity();
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    return this.d.getPadding(paramRect);
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
    this.d.invalidateSelf();
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.f) && (super.mutate() == this))
    {
      this.d = this.d.mutate();
      this.e = new FixedSizeDrawable.State(this.e);
      this.f = true;
    }
    return this;
  }
  
  public void scheduleSelf(@NonNull Runnable paramRunnable, long paramLong)
  {
    super.scheduleSelf(paramRunnable, paramLong);
    this.d.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void setBounds(@NonNull Rect paramRect)
  {
    super.setBounds(paramRect);
    this.c.set(paramRect);
    a();
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.d.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, @NonNull PorterDuff.Mode paramMode)
  {
    this.d.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
  
  @Deprecated
  public void setDither(boolean paramBoolean)
  {
    this.d.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.d.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.d.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(@NonNull Runnable paramRunnable)
  {
    super.unscheduleSelf(paramRunnable);
    this.d.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.FixedSizeDrawable
 * JD-Core Version:    0.7.0.1
 */