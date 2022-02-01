package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qqui.R.styleable;

public class RatingBar
  extends LinearLayout
{
  private boolean a = true;
  private RatingBar.OnRatingListener b;
  private Object c;
  private float d;
  private int e;
  private Drawable f;
  private Drawable g;
  private int h;
  
  public RatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    setOrientation(0);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.di);
    this.d = ((TypedArray)localObject).getDimension(R.styleable.dm, 20.0F);
    this.e = ((TypedArray)localObject).getInteger(R.styleable.dj, 5);
    this.f = ((TypedArray)localObject).getDrawable(R.styleable.dk);
    this.g = ((TypedArray)localObject).getDrawable(R.styleable.dl);
    ((TypedArray)localObject).recycle();
    while (i < this.e)
    {
      localObject = a(paramContext, paramAttributeSet);
      ((ImageView)localObject).setOnClickListener(new RatingBar.1(this));
      addView((View)localObject);
      i += 1;
    }
  }
  
  private ImageView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.d), Math.round(this.d)));
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setImageDrawable(this.f);
    paramContext.setMaxWidth(10);
    paramContext.setMaxHeight(10);
    return paramContext;
  }
  
  public int getStarCount()
  {
    return this.h;
  }
  
  public void setBindObject(Object paramObject)
  {
    this.c = paramObject;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setOnRatingListener(RatingBar.OnRatingListener paramOnRatingListener)
  {
    this.b = paramOnRatingListener;
  }
  
  public void setStar(int paramInt, boolean paramBoolean)
  {
    int j = this.e;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    int k = 0;
    j = k;
    paramInt = i;
    if (i < 0)
    {
      paramInt = 0;
      j = k;
    }
    while (j < paramInt)
    {
      ((ImageView)getChildAt(j)).setImageDrawable(this.g);
      if (paramBoolean)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.0F, 1.0F, 1.0F);
        getChildAt(j).startAnimation(localScaleAnimation);
      }
      j += 1;
    }
    i = this.e - 1;
    while (i >= paramInt)
    {
      ((ImageView)getChildAt(i)).setImageDrawable(this.f);
      i -= 1;
    }
  }
  
  public void setStarCount(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setStarEmptyDrawable(Drawable paramDrawable)
  {
    this.f = paramDrawable;
  }
  
  public void setStarFillDrawable(Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }
  
  public void setStarImageSize(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.RatingBar
 * JD-Core Version:    0.7.0.1
 */