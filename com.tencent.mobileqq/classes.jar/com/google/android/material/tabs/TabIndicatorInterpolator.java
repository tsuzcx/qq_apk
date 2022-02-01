package com.google.android.material.tabs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;

class TabIndicatorInterpolator
{
  static RectF a(@NonNull TabLayout.TabView paramTabView, @Dimension(unit=0) int paramInt)
  {
    int i = paramTabView.getContentWidth();
    int j = paramTabView.getContentHeight();
    paramInt = (int)ViewUtils.a(paramTabView.getContext(), paramInt);
    if (i >= paramInt) {
      paramInt = i;
    }
    i = (paramTabView.getLeft() + paramTabView.getRight()) / 2;
    int k = (paramTabView.getTop() + paramTabView.getBottom()) / 2;
    paramInt /= 2;
    j /= 2;
    int m = i / 2;
    return new RectF(i - paramInt, k - j, paramInt + i, k + m);
  }
  
  static RectF a(TabLayout paramTabLayout, @Nullable View paramView)
  {
    if (paramView == null) {
      return new RectF();
    }
    if ((!paramTabLayout.d()) && ((paramView instanceof TabLayout.TabView))) {
      return a((TabLayout.TabView)paramView, 24);
    }
    return new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  void a(TabLayout paramTabLayout, View paramView, @NonNull Drawable paramDrawable)
  {
    paramTabLayout = a(paramTabLayout, paramView);
    paramDrawable.setBounds((int)paramTabLayout.left, paramDrawable.getBounds().top, (int)paramTabLayout.right, paramDrawable.getBounds().bottom);
  }
  
  void a(TabLayout paramTabLayout, View paramView1, View paramView2, @FloatRange(from=0.0D, to=1.0D) float paramFloat, @NonNull Drawable paramDrawable)
  {
    paramView1 = a(paramTabLayout, paramView1);
    paramTabLayout = a(paramTabLayout, paramView2);
    paramDrawable.setBounds(AnimationUtils.a((int)paramView1.left, (int)paramTabLayout.left, paramFloat), paramDrawable.getBounds().top, AnimationUtils.a((int)paramView1.right, (int)paramTabLayout.right, paramFloat), paramDrawable.getBounds().bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabIndicatorInterpolator
 * JD-Core Version:    0.7.0.1
 */