package com.tencent.biz.pubaccount.weishi_new.operationh5;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;

public class OperationTitleBarView
  extends FrameLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  
  public OperationTitleBarView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OperationTitleBarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private float a()
  {
    float f2 = Utils.a(ViewUtils.a(getContext()), getResources());
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 25.0F;
    }
    return f1 + 48.0F;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(1929641989, this, false));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, Utils.a(a(), getResources()));
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(1929576459));
    this.b = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(1929576461));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(1929576462));
    this.c = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(1929576460));
  }
  
  public void a(int paramInt)
  {
    float f1 = Utils.a(100.0F, getResources());
    float f2 = paramInt;
    if (f2 < f1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(f2 / f1);
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      this.b.setImageResource(1929510914);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(1929445377));
      this.c.setImageResource(1929510912);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    this.b.setImageResource(1929510915);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(1929445376));
    this.c.setImageResource(1929510913);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setOperationTitleClickListener(OperationTitleBarView.OperationTitleClickListener paramOperationTitleClickListener)
  {
    this.b.setOnClickListener(new OperationTitleBarView.1(this, paramOperationTitleClickListener));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new OperationTitleBarView.2(this, paramOperationTitleClickListener));
    this.c.setOnClickListener(new OperationTitleBarView.3(this, paramOperationTitleClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.OperationTitleBarView
 * JD-Core Version:    0.7.0.1
 */