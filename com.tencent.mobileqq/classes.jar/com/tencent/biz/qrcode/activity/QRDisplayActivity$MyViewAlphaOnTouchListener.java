package com.tencent.biz.qrcode.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

class QRDisplayActivity$MyViewAlphaOnTouchListener
  implements View.OnTouchListener
{
  private QRDisplayActivity$MyViewAlphaOnTouchListener(QRDisplayActivity paramQRDisplayActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (this.a.jdField_c_of_type_Int == 1)
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          if ((2131374688 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
          {
            this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
            this.a.a.setAlpha(1.0F);
          }
          else if ((2131374705 == paramView.getId()) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView != null))
          {
            this.a.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
            this.a.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          }
          else if ((2131374712 == paramView.getId()) && (this.a.jdField_d_of_type_AndroidWidgetImageView != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null))
          {
            this.a.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
            this.a.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          }
        }
      }
      else if ((2131374688 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.a.setAlpha(0.5F);
      }
      else if ((2131374705 == paramView.getId()) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        this.a.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
      else if ((2131374712 == paramView.getId()) && (this.a.jdField_d_of_type_AndroidWidgetImageView != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null))
      {
        this.a.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
    }
    else if (this.a.jdField_c_of_type_Int == 2)
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          if ((2131374717 == paramView.getId()) && (this.a.e != null) && (this.a.jdField_d_of_type_AndroidWidgetTextView != null))
          {
            this.a.e.setAlpha(1.0F);
            this.a.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          }
          else if ((2131374691 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
          {
            this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
            this.a.a.setAlpha(1.0F);
          }
        }
      }
      else if ((2131374717 == paramView.getId()) && (this.a.e != null) && (this.a.jdField_d_of_type_AndroidWidgetTextView != null))
      {
        this.a.e.setAlpha(0.5F);
        this.a.jdField_d_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
      else if ((2131374691 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.a.setAlpha(0.5F);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.MyViewAlphaOnTouchListener
 * JD-Core Version:    0.7.0.1
 */