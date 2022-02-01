package com.tencent.biz.qqcircle.richframework.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class TabLayoutCompat$Tab
{
  TabLayoutCompat a;
  TabLayoutCompat.TabView b;
  private Object c;
  private Drawable d;
  private CharSequence e;
  private CharSequence f;
  private int g = -1;
  private View h;
  
  @Nullable
  public View a()
  {
    return this.h;
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
    this.e = paramCharSequence;
    h();
    return this;
  }
  
  void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  @Nullable
  public Drawable b()
  {
    return this.d;
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
  
  public void e()
  {
    TabLayoutCompat localTabLayoutCompat = this.a;
    if (localTabLayoutCompat != null)
    {
      localTabLayoutCompat.a(this);
      return;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  public boolean f()
  {
    TabLayoutCompat localTabLayoutCompat = this.a;
    if (localTabLayoutCompat != null) {
      return localTabLayoutCompat.getSelectedTabPosition() == this.g;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  @Nullable
  public CharSequence g()
  {
    return this.f;
  }
  
  void h()
  {
    TabLayoutCompat.TabView localTabView = this.b;
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
    this.e = null;
    this.f = null;
    this.g = -1;
    this.h = null;
  }
  
  @Nullable
  public TextView j()
  {
    TabLayoutCompat.TabView localTabView = this.b;
    if (localTabView == null) {
      return null;
    }
    return localTabView.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab
 * JD-Core Version:    0.7.0.1
 */