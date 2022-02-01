package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout;

public class ReadInjoyMenuIconView
  extends PressEffectLinearLayout
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public ReadInjoyMenuIconView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyMenuIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setGravity(17);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560205, this);
    TextView localTextView = (TextView)paramContext.findViewById(2131380936);
    localTextView.setTextSize(0, this.b);
    localTextView.setTextColor(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.topMargin = this.c;
    localTextView.setLayoutParams(localLayoutParams);
    paramContext = (KandianUrlImageView)paramContext.findViewById(2131380886);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.d, this.e));
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      paramContext.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInjoyMenuIconView);
    this.jdField_a_of_type_Int = paramContext.getColor(3, -16777216);
    this.b = paramContext.getDimensionPixelSize(5, 16);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(6);
    this.c = paramContext.getDimensionPixelSize(4, 10);
    this.d = paramContext.getDimensionPixelSize(2, 10);
    this.e = paramContext.getDimensionPixelSize(1, 10);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(0);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyMenuIconView
 * JD-Core Version:    0.7.0.1
 */