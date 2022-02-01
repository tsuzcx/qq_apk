package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ForegroundLinearLayout
  extends LinearLayoutCompat
{
  protected boolean a = true;
  boolean b = false;
  @Nullable
  private Drawable c;
  private final Rect d = new Rect();
  private final Rect e = new Rect();
  private int f = 119;
  
  public ForegroundLinearLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ForegroundLinearLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.dc, paramInt, 0, new int[0]);
    this.f = paramContext.getInt(R.styleable.de, this.f);
    paramAttributeSet = paramContext.getDrawable(R.styleable.dd);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.a = paramContext.getBoolean(R.styleable.df, true);
    paramContext.recycle();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable = this.c;
    if (localDrawable != null)
    {
      if (this.b)
      {
        this.b = false;
        Rect localRect1 = this.d;
        Rect localRect2 = this.e;
        int i = getRight() - getLeft();
        int j = getBottom() - getTop();
        if (this.a) {
          localRect1.set(0, 0, i, j);
        } else {
          localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
        }
        Gravity.apply(this.f, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
        localDrawable.setBounds(localRect2);
      }
      localDrawable.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.c;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.c.setState(getDrawableState());
    }
  }
  
  @Nullable
  public Drawable getForeground()
  {
    return this.c;
  }
  
  public int getForegroundGravity()
  {
    return this.f;
  }
  
  @RequiresApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = (paramBoolean | this.b);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = true;
  }
  
  public void setForeground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.c);
      }
      this.c = paramDrawable;
      if (paramDrawable != null)
      {
        setWillNotDraw(false);
        paramDrawable.setCallback(this);
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getDrawableState());
        }
        if (this.f == 119) {
          paramDrawable.getPadding(new Rect());
        }
      }
      else
      {
        setWillNotDraw(true);
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (this.f != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      this.f = paramInt;
      if ((this.f == 119) && (this.c != null))
      {
        Rect localRect = new Rect();
        this.c.getPadding(localRect);
      }
      requestLayout();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */