package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;

public abstract class AbsEmptyView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private View d;
  
  public AbsEmptyView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AbsEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      int i = this.jdField_c_of_type_Int;
      if (i == paramInt) {
        return;
      }
      if ((i == 0) && (paramInt == 3)) {
        return;
      }
    }
    this.jdField_c_of_type_Int = paramInt;
    this.d.setVisibility(8);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131381136));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131381121));
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378745));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363671));
      return;
    }
    if (paramInt == 4)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.d.setVisibility(0);
    }
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561756, this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370381);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378738);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131378737);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131376496));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378745));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363671));
    this.d = super.findViewById(2131379200);
    this.jdField_a_of_type_Int = UIUtils.a(getContext());
    this.jdField_b_of_type_Int = a();
    a(0, true);
    super.postDelayed(new AbsEmptyView.2(this), 500L);
  }
  
  public abstract int a();
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824));
  }
  
  public void setRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new AbsEmptyView.1(this, paramOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AbsEmptyView
 * JD-Core Version:    0.7.0.1
 */