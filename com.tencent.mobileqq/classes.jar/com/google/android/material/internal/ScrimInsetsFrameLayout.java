package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  @Nullable
  Drawable a;
  Rect b;
  private Rect c = new Rect();
  private boolean d = true;
  private boolean e = true;
  
  public ScrimInsetsFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrimInsetsFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.fS, paramInt, R.style.p, new int[0]);
    this.a = paramContext.getDrawable(R.styleable.fT);
    paramContext.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener(this, new ScrimInsetsFrameLayout.1(this));
  }
  
  protected void a(WindowInsetsCompat paramWindowInsetsCompat) {}
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.b != null) && (this.a != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      if (this.d)
      {
        this.c.set(0, 0, i, this.b.top);
        this.a.setBounds(this.c);
        this.a.draw(paramCanvas);
      }
      if (this.e)
      {
        this.c.set(0, j - this.b.bottom, i, j);
        this.a.setBounds(this.c);
        this.a.draw(paramCanvas);
      }
      this.c.set(0, this.b.top, this.b.left, j - this.b.bottom);
      this.a.setBounds(this.c);
      this.a.draw(paramCanvas);
      this.c.set(i - this.b.right, this.b.top, i, j - this.b.bottom);
      this.a.setBounds(this.c);
      this.a.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
  }
  
  public void setDrawBottomInsetForeground(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setDrawTopInsetForeground(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setScrimInsetForeground(@Nullable Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */