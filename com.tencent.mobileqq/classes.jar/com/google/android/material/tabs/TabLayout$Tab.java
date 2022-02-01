package com.google.android.material.tabs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

public class TabLayout$Tab
{
  @Nullable
  public TabLayout a;
  @NonNull
  public TabLayout.TabView b;
  @Nullable
  private Object c;
  @Nullable
  private Drawable d;
  @Nullable
  private CharSequence e;
  @Nullable
  private CharSequence f;
  private int g = -1;
  @Nullable
  private View h;
  @TabLayout.LabelVisibility
  private int i = 1;
  private int j = -1;
  
  @Nullable
  public View a()
  {
    return this.h;
  }
  
  @NonNull
  public Tab a(@LayoutRes int paramInt)
  {
    return a(LayoutInflater.from(this.b.getContext()).inflate(paramInt, this.b, false));
  }
  
  @NonNull
  public Tab a(@Nullable Drawable paramDrawable)
  {
    this.d = paramDrawable;
    if ((this.a.p == 1) || (this.a.s == 2)) {
      this.a.a(true);
    }
    h();
    if ((BadgeUtils.a) && (TabLayout.TabView.a(this.b)) && (TabLayout.TabView.b(this.b).isVisible())) {
      this.b.invalidate();
    }
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable View paramView)
  {
    this.h = paramView;
    h();
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(paramCharSequence))) {
      this.b.setContentDescription(paramCharSequence);
    }
    this.e = paramCharSequence;
    h();
    return this;
  }
  
  @Nullable
  public Drawable b()
  {
    return this.d;
  }
  
  @NonNull
  public Tab b(@Nullable CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    h();
    return this;
  }
  
  void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int c()
  {
    return this.g;
  }
  
  @Nullable
  public CharSequence d()
  {
    return this.e;
  }
  
  @TabLayout.LabelVisibility
  public int e()
  {
    return this.i;
  }
  
  public void f()
  {
    TabLayout localTabLayout = this.a;
    if (localTabLayout != null)
    {
      localTabLayout.c(this);
      return;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  public boolean g()
  {
    TabLayout localTabLayout = this.a;
    if (localTabLayout != null) {
      return localTabLayout.getSelectedTabPosition() == this.g;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  void h()
  {
    TabLayout.TabView localTabView = this.b;
    if (localTabView != null) {
      localTabView.b();
    }
  }
  
  void i()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.j = -1;
    this.e = null;
    this.f = null;
    this.g = -1;
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.Tab
 * JD-Core Version:    0.7.0.1
 */