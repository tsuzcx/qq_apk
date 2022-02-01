package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;

public class QQLogo
  extends ImageView
{
  private boolean a = false;
  private boolean b = false;
  
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
    int i = getResources().getDimensionPixelSize(2131298696);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispearLogo_internal:");
    if (localLayoutParams.bottomMargin != i) {
      bool = true;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("|");
    localStringBuilder.append(localLayoutParams.bottomMargin);
    localStringBuilder.append("|");
    localStringBuilder.append(i);
    AVLog.printColorLog("QQLogo", localStringBuilder.toString());
    if (localLayoutParams.bottomMargin != i)
    {
      setVisibility(8);
      return;
    }
    d();
  }
  
  private void b()
  {
    this.a = true;
    AVLog.printColorLog("QQLogo", "showLogo_internal:");
    c();
  }
  
  private void c()
  {
    AVLog.printColorLog("QQLogo", "showLogo:");
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
    AVLog.printColorLog("QQLogo", "dispearLogo:");
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new QQLogo.1(this));
    clearAnimation();
    startAnimation(localAlphaAnimation);
  }
  
  private void setLogoBottomOffset(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLogoBottomOffset:");
    ((StringBuilder)localObject).append(paramInt);
    AVLog.printColorLog("QQLogo", ((StringBuilder)localObject).toString());
    int i = getResources().getDimensionPixelSize(2131298696);
    localObject = (RelativeLayout.LayoutParams)getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + paramInt);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void setQQLogoAttr(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLogo:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(getVisibility());
    AVLog.printColorLog("QQLogo", localStringBuilder.toString());
    if ((getVisibility() == 8) && (!this.a) && (paramBoolean))
    {
      b();
      return;
    }
    if ((getVisibility() == 0) && (this.a) && (!paramBoolean)) {
      a();
    }
  }
  
  public void setQQLogo(boolean paramBoolean, int paramInt)
  {
    if (this.b) {
      return;
    }
    if ((paramInt != 2) && (paramInt != 4))
    {
      if (getVisibility() == 0)
      {
        AVLog.printColorLog("QQLogo", "setOffset audio hide qq logo");
        setVisibility(8);
      }
    }
    else {
      setQQLogoAttr(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QQLogo
 * JD-Core Version:    0.7.0.1
 */