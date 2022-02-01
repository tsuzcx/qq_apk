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
  private ImageView a;
  private Drawable b;
  private int c;
  private int d;
  
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
    LayoutInflater.from(paramContext).inflate(2064056348, this, true);
    this.a = ((ImageView)findViewById(2063991189));
    paramContext = this.b;
    if (paramContext != null) {
      this.a.setImageDrawable(paramContext);
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
    this.b = paramContext.getDrawable(1);
    this.c = paramContext.getDimensionPixelSize(2, 0);
    this.d = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  public ImageView getForegroundView()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.a;
    if ((localObject != null) && (this.c != 0) && (this.d != 0))
    {
      localObject = ((ImageView)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.c;
      ((ViewGroup.LayoutParams)localObject).height = this.d;
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setForegroundAndBackgroundResource(@DrawableRes int paramInt1, @DrawableRes int paramInt2)
  {
    setForegroundResource(paramInt1);
    setBackgroundResource(paramInt2);
  }
  
  public void setForegroundResource(@DrawableRes int paramInt)
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void setForegroundSize(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECompoundButton
 * JD-Core Version:    0.7.0.1
 */