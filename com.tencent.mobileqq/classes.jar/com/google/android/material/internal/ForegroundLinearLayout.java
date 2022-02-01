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
  private int jdField_a_of_type_Int = 119;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected boolean a;
  private final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_b_of_type_Boolean = false;
  
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
    this.jdField_a_of_type_Boolean = true;
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.C, paramInt, 0, new int[0]);
    this.jdField_a_of_type_Int = paramContext.getInt(R.styleable.bZ, this.jdField_a_of_type_Int);
    paramAttributeSet = paramContext.getDrawable(R.styleable.bY);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.ca, true);
    paramContext.recycle();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        Rect localRect1 = this.jdField_a_of_type_AndroidGraphicsRect;
        Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
        int i = getRight() - getLeft();
        int j = getBottom() - getTop();
        if (this.jdField_a_of_type_Boolean) {
          localRect1.set(0, 0, i, j);
        } else {
          localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
        }
        Gravity.apply(this.jdField_a_of_type_Int, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
        localDrawable.setBounds(localRect2);
      }
      localDrawable.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
    }
  }
  
  @RequiresApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Boolean = (paramBoolean | this.jdField_b_of_type_Boolean);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setForeground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable != null)
      {
        setWillNotDraw(false);
        paramDrawable.setCallback(this);
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getDrawableState());
        }
        if (this.jdField_a_of_type_Int == 119) {
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
    if (this.jdField_a_of_type_Int != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_Int == 119) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        Rect localRect = new Rect();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(localRect);
      }
      requestLayout();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */