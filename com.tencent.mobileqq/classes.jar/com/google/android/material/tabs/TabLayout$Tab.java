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
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @NonNull
  public TabLayout.TabView a;
  @Nullable
  public TabLayout a;
  @Nullable
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  @Nullable
  private Object jdField_a_of_type_JavaLangObject;
  @TabLayout.LabelVisibility
  private int jdField_b_of_type_Int = 1;
  @Nullable
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private int c = -1;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @Nullable
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NonNull
  public Tab a(@LayoutRes int paramInt)
  {
    return a(LayoutInflater.from(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView.getContext()).inflate(paramInt, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView, false));
  }
  
  @NonNull
  public Tab a(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.h == 1) || (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.k == 2)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a(true);
    }
    b();
    if ((BadgeUtils.a) && (TabLayout.TabView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView)) && (TabLayout.TabView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView).isVisible())) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView.invalidate();
    }
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    b();
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) && (!TextUtils.isEmpty(paramCharSequence))) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView.setContentDescription(paramCharSequence);
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    b();
    return this;
  }
  
  @Nullable
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void a()
  {
    TabLayout localTabLayout = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
    if (localTabLayout != null)
    {
      localTabLayout.b(this);
      return;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    TabLayout localTabLayout = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
    if (localTabLayout != null) {
      return localTabLayout.b() == this.jdField_a_of_type_Int;
    }
    throw new IllegalArgumentException("Tab not attached to a TabLayout");
  }
  
  @TabLayout.LabelVisibility
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NonNull
  public Tab b(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    b();
    return this;
  }
  
  void b()
  {
    TabLayout.TabView localTabView = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView;
    if (localTabView != null) {
      localTabView.b();
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout = null;
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout$TabView = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.c = -1;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_b_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.Tab
 * JD-Core Version:    0.7.0.1
 */