package com.tencent.mobileqq.activity.aio.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;

public class ComboAnimation3
  extends AIOAnimationConatiner.AIOAnimator
{
  static final int g = (int)(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density * 60.0F + 0.5F);
  Drawable[] d;
  float e = 0.04166667F;
  long f;
  private View h;
  private View i;
  
  public ComboAnimation3(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean a(long paramLong)
  {
    int n = this.h.getLeft();
    int i1 = this.h.getWidth() / 2;
    int j = this.h.getTop();
    int k = this.h.getHeight() / 2;
    int i2 = this.a.getWidth() / 2;
    int m = this.a.getHeight() / 2;
    n = i2 - (n + i1);
    j = m - (j + k);
    if ((n != 0) || (j != 0))
    {
      this.h.offsetLeftAndRight(n);
      this.h.offsetTopAndBottom(j);
      this.i.offsetLeftAndRight(n);
      this.i.offsetTopAndBottom(j);
      this.a.invalidate();
    }
    return true;
  }
  
  protected void a(int paramInt)
  {
    QQViewCompatUtil.a(this.a, paramInt);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(this.f);
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    int k = ((Integer)paramVarArgs[0]).intValue();
    this.f = ((Long)paramVarArgs[1]).longValue();
    if (k > 0)
    {
      int i2 = Integer.toString(k).length();
      int n;
      if (k > 99)
      {
        this.d = new Drawable[4];
        this.d[3] = this.b.getResources().getDrawable(2130837966);
        j = this.d[3].getIntrinsicWidth();
        this.d[2] = this.b.getResources().getDrawable(2130838281);
        k = this.d[2].getIntrinsicWidth();
        this.d[1] = this.b.getResources().getDrawable(2130838281);
        n = j + 0 + k + this.d[1].getIntrinsicWidth();
      }
      else
      {
        this.d = new Drawable[i2 + 1];
        int m = 0;
        j = 0;
        int i1;
        do
        {
          paramVarArgs = this.d;
          n = i2 - m;
          paramVarArgs[n] = this.b.getResources().getDrawable(k % 10 + 2130838272);
          n = j + this.d[n].getIntrinsicWidth();
          m += 1;
          i1 = k / 10;
          k = i1;
          j = n;
        } while (i1 > 0);
      }
      this.d[0] = this.b.getResources().getDrawable(2130838282);
      int j = n + this.d[0].getIntrinsicWidth();
      this.h = new ComboAnimation3.ComboView(this, this.b.getContext());
      this.i = new ComboAnimation3.ComboView(this, this.b.getContext());
      this.a.addViewInLayout(this.h, -1, AIOAnimationConatiner.a, false);
      this.a.addViewInLayout(this.i, -1, AIOAnimationConatiner.a, false);
      this.h.layout(0, 0, j, g);
      this.i.layout(0, 0, j, g);
      if (a(this.f))
      {
        if (VersionUtils.e())
        {
          this.h.setLayerType(2, null);
          paramVarArgs = this.h;
          float f1 = j / 2;
          paramVarArgs.setPivotX(f1);
          this.h.setPivotY(g / 2);
          this.i.setLayerType(2, null);
          this.i.setPivotX(f1);
          this.i.setPivotY(g / 2);
          Object localObject1 = Keyframe.ofFloat(0.0F, 0.0F);
          Object localObject2 = Keyframe.ofFloat(this.e * 11.0F, 1.0F);
          Object localObject3 = Keyframe.ofFloat(this.e * 20.0F, 1.0F);
          Keyframe localKeyframe = Keyframe.ofFloat(1.0F, 0.0F);
          paramVarArgs = new Keyframe[4];
          paramVarArgs[0] = Keyframe.ofFloat(0.0F, 1.0F);
          paramVarArgs[1] = Keyframe.ofFloat(this.e * 6.0F, 1.5F);
          paramVarArgs[2] = Keyframe.ofFloat(this.e * 11.0F, 1.0F);
          paramVarArgs[3] = Keyframe.ofFloat(1.0F, 1.0F);
          localObject3 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject1, localObject2, localObject3, localKeyframe });
          localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", paramVarArgs);
          localObject2 = PropertyValuesHolder.ofKeyframe("scaleY", paramVarArgs);
          paramVarArgs = ObjectAnimator.ofPropertyValuesHolder(this.h, new PropertyValuesHolder[] { localObject3 }).setDuration(1000L);
          localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.h, new PropertyValuesHolder[] { localObject1 }).setDuration(1000L);
          localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.h, new PropertyValuesHolder[] { localObject2 }).setDuration(1000L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).addListener(new ComboAnimation3.1(this));
          ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
          ((AnimatorSet)localObject3).start();
          this.h.setTag(localObject3);
          this.i.setAlpha(0.0F);
          paramVarArgs = ObjectAnimator.ofFloat(this.i, "alpha", new float[] { 0.5F, 0.0F }).setDuration(333L);
          localObject1 = ObjectAnimator.ofFloat(this.i, "scaleX", new float[] { 1.5F, 2.0F }).setDuration(333L);
          localObject2 = ObjectAnimator.ofFloat(this.i, "scaleY", new float[] { 1.5F, 2.0F }).setDuration(333L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
          ((AnimatorSet)localObject3).setStartDelay((this.e * 5.0F * 1000.0F));
          ((AnimatorSet)localObject3).start();
          this.i.setTag(localObject3);
          return true;
        }
        paramVarArgs = new ComboAnimation3.2(this);
        paramVarArgs.setDuration(1000L);
        paramVarArgs.setFillAfter(true);
        this.h.setAnimation(paramVarArgs);
        paramVarArgs.setAnimationListener(new ComboAnimation3.3(this));
        paramVarArgs = new ComboAnimation3.4(this);
        paramVarArgs.setDuration(1000L);
        paramVarArgs.setFillAfter(true);
        this.i.setAnimation(paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  @TargetApi(11)
  protected void c()
  {
    this.a.removeViewInLayout(this.h);
    this.a.removeViewInLayout(this.i);
    if (VersionUtils.e())
    {
      Animator localAnimator1 = (Animator)this.h.getTag();
      Animator localAnimator2 = (Animator)this.i.getTag();
      if (localAnimator1 != null) {
        localAnimator1.cancel();
      }
      if (localAnimator2 != null) {
        localAnimator2.cancel();
      }
    }
    this.h = null;
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.ComboAnimation3
 * JD-Core Version:    0.7.0.1
 */