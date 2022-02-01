package com.tencent.av.ui;

import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class NormalMenuView
{
  final String a;
  NormalMenuView.ViewEvent b = null;
  RelativeLayout c = null;
  int d;
  boolean e = false;
  ObjectAnimator f = null;
  
  public NormalMenuView(RelativeLayout paramRelativeLayout, int paramInt, NormalMenuView.ViewEvent paramViewEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MenuView_");
    localStringBuilder.append(paramInt);
    this.a = localStringBuilder.toString();
    this.c = paramRelativeLayout;
    this.d = paramInt;
    this.b = paramViewEvent;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.c == null) {
      return;
    }
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowMenuView, isShow[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], needAnimation[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], lastObjectAnimator[");
    boolean bool;
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(this.c.getVisibility());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    b();
    localObject = this.b;
    if (localObject != null) {
      ((NormalMenuView.ViewEvent)localObject).a(paramLong, this.c, true);
    }
    if (paramBoolean)
    {
      int i = c();
      localObject = null;
      if (paramInt == 3) {
        localObject = ObjectAnimator.ofFloat(this.c, "TranslationY", new float[] { i, 0.0F });
      } else if (paramInt == 4) {
        localObject = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 1.0F });
      }
      if (localObject == null)
      {
        QLog.w(this.a, 1, "ShowMenuView, warning animator is null");
        return;
      }
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).addListener(new NormalMenuView.2(this, i, paramLong));
      this.e = true;
      this.f = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).start();
      return;
    }
    this.c.setVisibility(0);
    this.e = true;
    localObject = this.b;
    if (localObject != null) {
      ((NormalMenuView.ViewEvent)localObject).a(paramLong, this.c, false);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, QavPanel.OnDismissAnimationEndListener paramOnDismissAnimationEndListener)
  {
    Object localObject = this.c;
    int i;
    if (localObject != null) {
      i = ((RelativeLayout)localObject).getVisibility();
    } else {
      i = 4;
    }
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiddenMenuView, isShow[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], needAnimation[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], lastObjectAnimator[");
    boolean bool;
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    b();
    if (paramBoolean)
    {
      i = c();
      localObject = null;
      if (paramInt == 2) {
        localObject = ObjectAnimator.ofFloat(this.c, "TranslationY", new float[] { 0.0F, i });
      }
      if (localObject == null)
      {
        if (!AudioHelper.a()) {
          return;
        }
        paramOnDismissAnimationEndListener = new StringBuilder();
        paramOnDismissAnimationEndListener.append(HardCodeUtil.a(2131906695));
        paramOnDismissAnimationEndListener.append(this.e);
        paramOnDismissAnimationEndListener.append("], height[");
        paramOnDismissAnimationEndListener.append(i);
        paramOnDismissAnimationEndListener.append("], seq[");
        paramOnDismissAnimationEndListener.append(paramLong);
        paramOnDismissAnimationEndListener.append("]");
        paramOnDismissAnimationEndListener = paramOnDismissAnimationEndListener.toString();
        QLog.w(this.a, 1, paramOnDismissAnimationEndListener, new Throwable("打印调用栈"));
        throw new IllegalArgumentException(paramOnDismissAnimationEndListener);
      }
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).addListener(new NormalMenuView.1(this, i, paramLong, paramOnDismissAnimationEndListener));
      this.f = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).start();
      this.e = false;
      paramOnDismissAnimationEndListener = this.b;
      if (paramOnDismissAnimationEndListener != null) {
        paramOnDismissAnimationEndListener.b(paramLong, this.c, true);
      }
    }
    else
    {
      paramOnDismissAnimationEndListener = this.b;
      if (paramOnDismissAnimationEndListener != null) {
        paramOnDismissAnimationEndListener.b(paramLong, this.c, true);
      }
      paramOnDismissAnimationEndListener = this.c;
      if (paramOnDismissAnimationEndListener != null)
      {
        paramOnDismissAnimationEndListener.setVisibility(8);
        this.e = false;
      }
      paramOnDismissAnimationEndListener = this.b;
      if (paramOnDismissAnimationEndListener != null) {
        paramOnDismissAnimationEndListener.b(paramLong, this.c, false);
      }
    }
  }
  
  void b()
  {
    ObjectAnimator localObjectAnimator = this.f;
    this.f = null;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  int c()
  {
    RelativeLayout localRelativeLayout = this.c;
    int i = 0;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.measure(0, 0);
      i = this.c.getMeasuredHeight();
    }
    return i;
  }
  
  public RelativeLayout d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView
 * JD-Core Version:    0.7.0.1
 */