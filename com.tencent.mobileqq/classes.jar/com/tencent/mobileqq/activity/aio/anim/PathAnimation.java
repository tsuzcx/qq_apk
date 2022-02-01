package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class PathAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  ArrayList<AnimationPath.Values> d;
  private PathAnimation.Animator e;
  
  public PathAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @TargetApi(11)
  void a(View paramView, AnimationPath.Values paramValues)
  {
    if (!paramValues.k) {
      return;
    }
    int i = paramView.getLeft();
    int j = paramView.getWidth() / 2;
    int k = paramView.getTop();
    int m = paramView.getHeight() / 2;
    paramView.offsetTopAndBottom(paramValues.b - (k + m));
    paramView.offsetLeftAndRight(paramValues.a - (i + j));
    if (VersionUtils.e())
    {
      paramView.setAlpha(paramValues.i);
      paramView.setRotation(paramValues.c);
      paramView.setScaleX(paramValues.f);
      paramView.setScaleY(paramValues.g);
      paramView.setRotationX(paramValues.d);
      paramView.setRotationY(paramValues.e);
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        Drawable[] arrayOfDrawable;
        if ((paramVarArgs[0] instanceof Drawable[]))
        {
          arrayOfDrawable = (Drawable[])paramVarArgs[0];
        }
        else
        {
          arrayOfDrawable = new Drawable[1];
          arrayOfDrawable[0] = ((Drawable)paramVarArgs[0]);
        }
        int k = ((Integer)paramVarArgs[1]).intValue();
        long l1 = ((Long)paramVarArgs[2]).longValue();
        localAnimationPath = (AnimationPath)AIOAnimationConatiner.b.loadClass((String)paramVarArgs[3]).newInstance();
        this.d = new ArrayList(k);
        l2 = AnimationUtils.currentAnimationTimeMillis();
        i = 0;
        j = 0;
        if (i < k)
        {
          localView = new View(this.b.getContext());
          double d1 = Math.random();
          int m = arrayOfDrawable.length;
          double d2 = m;
          Double.isNaN(d2);
          m = (int)(d1 * d2);
          localDrawable = arrayOfDrawable[m];
          localView.setBackgroundDrawable(localDrawable);
          localView.layout(-localDrawable.getIntrinsicWidth(), -localDrawable.getIntrinsicHeight(), 0, 0);
          this.a.addView(localView);
          if (i != 0)
          {
            d1 = Math.random();
            d2 = l1;
            Double.isNaN(d2);
            j = (int)(d1 * d2);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        AnimationPath localAnimationPath;
        long l2;
        int i;
        int j;
        View localView;
        Drawable localDrawable;
        AnimationPath.Values localValues;
        return false;
      }
      try
      {
        localValues = new AnimationPath.Values();
        localValues.j = (j + l2);
        localValues.l = localView;
        if (i == 0) {
          paramVarArgs = localAnimationPath;
        } else {
          paramVarArgs = localAnimationPath.a();
        }
        localValues.m = paramVarArgs;
        if (VersionUtils.e())
        {
          localView.setLayerType(2, null);
          localView.setPivotX(localDrawable.getIntrinsicWidth() / 2);
          localView.setPivotY(localDrawable.getIntrinsicHeight() / 2);
        }
        else
        {
          localView.setTag(localValues);
        }
        this.d.add(localValues);
        i += 1;
      }
      catch (Exception paramVarArgs) {}
    }
    if (this.e == null)
    {
      this.e = new PathAnimation.Animator(this, null);
      this.b.postDelayed(this.e, 16L);
    }
    return true;
    return false;
  }
  
  protected void c()
  {
    if (this.e != null)
    {
      this.b.removeCallbacks(this.e);
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation
 * JD-Core Version:    0.7.0.1
 */