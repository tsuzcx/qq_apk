package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import krx;
import lwm;

public class QQLogo
  extends ImageView
{
  private boolean a;
  private boolean b;
  
  public QQLogo(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQLogo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQLogo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    boolean bool = false;
    this.a = false;
    int i = getResources().getDimensionPixelSize(2131166704);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder().append("dispearLogo_internal:");
    if (localLayoutParams.bottomMargin != i) {
      bool = true;
    }
    krx.c("QQLogo", bool + "|" + localLayoutParams.bottomMargin + "|" + i);
    if (localLayoutParams.bottomMargin != i)
    {
      setVisibility(8);
      return;
    }
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    krx.c("QQLogo", "QQLogo:" + this.a + "|" + paramBoolean + "|" + getVisibility());
    if ((getVisibility() == 8) && (!this.a) && (paramBoolean)) {
      b();
    }
    while ((getVisibility() != 0) || (!this.a) || (paramBoolean)) {
      return;
    }
    a();
  }
  
  private void b()
  {
    this.a = true;
    krx.c("QQLogo", "showLogo_internal:");
    c();
  }
  
  private void c()
  {
    krx.c("QQLogo", "showLogo:");
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f = ((Transformation)localObject).getAlpha();
    clearAnimation();
    localObject = new AlphaAnimation(f, 1.0F);
    ((AlphaAnimation)localObject).setDuration(800L);
    startAnimation((Animation)localObject);
    setVisibility(0);
  }
  
  private void d()
  {
    krx.c("QQLogo", "dispearLogo:");
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new lwm(this));
    clearAnimation();
    startAnimation(localAlphaAnimation);
  }
  
  public void setQQLogo(boolean paramBoolean, int paramInt)
  {
    if (this.b) {}
    do
    {
      return;
      if ((paramInt == 2) || (paramInt == 4))
      {
        a(paramBoolean);
        return;
      }
    } while (getVisibility() != 0);
    krx.c("QQLogo", "setOffset audio hide qq logo");
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QQLogo
 * JD-Core Version:    0.7.0.1
 */