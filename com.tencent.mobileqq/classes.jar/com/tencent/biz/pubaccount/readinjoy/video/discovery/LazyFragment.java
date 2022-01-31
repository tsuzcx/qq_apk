package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public abstract class LazyFragment
  extends Fragment
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected LayoutInflater a;
  protected View a;
  protected ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if ((a() != null) && (a().getParent() != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, this.jdField_a_of_type_AndroidWidgetFrameLayout, false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, this.jdField_a_of_type_AndroidViewViewGroup, false);
  }
  
  protected void a(Bundle paramBundle)
  {
    if ((getUserVisibleHint()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      b(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    f();
  }
  
  protected void b() {}
  
  protected void b(Bundle paramBundle)
  {
    a(a());
    c(paramBundle);
  }
  
  protected void c() {}
  
  public abstract void c(Bundle paramBundle);
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void g()
  {
    if ((!this.jdField_a_of_type_Boolean) && (a() != null))
    {
      this.jdField_a_of_type_Boolean = true;
      b(this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_Boolean) && (!this.b) && (getUserVisibleHint()))
    {
      this.b = true;
      a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_Boolean) && (this.b) && (getUserVisibleHint()))
    {
      this.b = false;
      d();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      g();
    }
    if ((this.jdField_a_of_type_Boolean) && (a() != null))
    {
      if (paramBoolean)
      {
        this.b = true;
        a();
        b();
      }
    }
    else {
      return;
    }
    this.b = false;
    c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.LazyFragment
 * JD-Core Version:    0.7.0.1
 */