package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SettingMeRelativeLayout
  extends RelativeLayout
{
  private View a;
  private float b = 1.0F;
  private float c;
  private ImageView d;
  
  public SettingMeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SettingMeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(14)
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        ((View)localObject).setTranslationX(super.getTranslationX() * this.b + this.c);
        localObject = this.d;
        if (localObject != null) {
          ((ImageView)localObject).setTranslationX(super.getTranslationX() * this.b);
        }
      }
    }
  }
  
  public void setSurfaceView(View paramView, ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    this.a = paramView;
    this.d = paramImageView;
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  @TargetApi(14)
  public void setTranslationX(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setTranslationX(paramFloat);
      Object localObject = this.a;
      if (localObject != null) {
        ((View)localObject).setTranslationX(this.b * paramFloat + this.c);
      }
      localObject = this.d;
      if (localObject != null) {
        ((ImageView)localObject).setTranslationX(paramFloat * this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingMeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */