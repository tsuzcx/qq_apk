package com.tencent.biz.pubaccount.readinjoy.capture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import lhr;

public class ReadInJoyCameraStatusLayout
  extends LinearLayout
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 80;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private lhr jdField_a_of_type_Lhr;
  
  public ReadInJoyCameraStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    setGravity(1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new LinearLayout.LayoutParams(AIOUtils.a(80.0F, getResources()), AIOUtils.a(80.0F, getResources())));
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131362206);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Lhr != null) {
      this.jdField_a_of_type_Lhr.a();
    }
  }
  
  public void setOnBottonClickListener(lhr paramlhr)
  {
    this.jdField_a_of_type_Lhr = paramlhr;
  }
  
  @TargetApi(16)
  public void setStatus(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      this.jdField_a_of_type_AndroidWidgetImageView.setBackground(getResources().getDrawable(2130840717));
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetImageView.setBackground(getResources().getDrawable(2130840718));
      Drawable localDrawable = getResources().getDrawable(2130840719);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return;
    case 2: 
      this.jdField_a_of_type_AndroidWidgetImageView.setBackground(getResources().getDrawable(2130840717));
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackground(getResources().getDrawable(2130840717));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraStatusLayout
 * JD-Core Version:    0.7.0.1
 */