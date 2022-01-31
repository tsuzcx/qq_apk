package com.tencent.biz.pubaccount.readinjoy.viola.wormhole;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import srp;

public class WormholeView
  extends FrameLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private srp jdField_a_of_type_Srp;
  private boolean jdField_a_of_type_Boolean;
  
  public WormholeView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public WormholeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WormholeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Srp != null) {
        this.jdField_a_of_type_Srp.a(this);
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Srp != null) {
        this.jdField_a_of_type_Srp.b(this);
      }
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131380289));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380291);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380290));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    f();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    e();
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    f();
  }
  
  public void setLifeListener(srp paramsrp)
  {
    this.jdField_a_of_type_Srp = paramsrp;
  }
  
  public void setOnErrorViewClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView
 * JD-Core Version:    0.7.0.1
 */