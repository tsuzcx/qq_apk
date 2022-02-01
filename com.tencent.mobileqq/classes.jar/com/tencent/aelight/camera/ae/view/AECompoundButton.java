package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.impl.R.styleable;

public class AECompoundButton
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private int b;
  
  public AECompoundButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECompoundButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECompoundButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    b(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2064318488, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2064122309));
    paramContext = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
    }
  }
  
  private void b(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.b);
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(1);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2, 0);
    this.b = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (this.jdField_a_of_type_Int != 0) && (this.b != 0))
    {
      localObject = ((ImageView)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject).height = this.b;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setForegroundAndBackgroundResource(@DrawableRes int paramInt1, @DrawableRes int paramInt2)
  {
    setForegroundResource(paramInt1);
    setBackgroundResource(paramInt2);
  }
  
  public void setForegroundResource(@DrawableRes int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void setForegroundSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECompoundButton
 * JD-Core Version:    0.7.0.1
 */