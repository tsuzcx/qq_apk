package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

public final class TabLayoutCompat$Tab
{
  private int jdField_a_of_type_Int = -1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  TabLayoutCompat.TabView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView;
  TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Object jdField_a_of_type_JavaLangObject;
  private CharSequence b;
  
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
  public Tab a(int paramInt)
  {
    return a(LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView.getContext()).inflate(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView, false));
  }
  
  @NonNull
  public Tab a(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    c();
    return this;
  }
  
  @NonNull
  public Tab a(@Nullable Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  @Nullable
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  @Nullable
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.e(this);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b() == this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public CharSequence b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.c(this, true);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView.b();
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.b = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab
 * JD-Core Version:    0.7.0.1
 */