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
    if (this.a.jdField_c_of_type_Int == 1) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if ((2131375173 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.a.setAlpha(0.5F);
      }
      else if ((2131375190 == paramView.getId()) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        this.a.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
      else if ((2131375197 == paramView.getId()) && (this.a.jdField_d_of_type_AndroidWidgetImageView != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null))
      {
        this.a.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        continue;
        if ((2131375173 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
        {
          this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          this.a.a.setAlpha(1.0F);
        }
        else if ((2131375190 == paramView.getId()) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView != null))
        {
          this.a.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        }
        else if ((2131375197 == paramView.getId()) && (this.a.jdField_d_of_type_AndroidWidgetImageView != null) && (this.a.jdField_c_of_type_AndroidWidgetTextView != null))
        {
          this.a.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          this.a.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          continue;
          if (this.a.jdField_c_of_type_Int == 2) {
            switch (paramMotionEvent.getAction())
            {
            case 2: 
            default: 
              break;
            case 0: 
              if ((2131375202 == paramView.getId()) && (this.a.e != null) && (this.a.jdField_d_of_type_AndroidWidgetTextView != null))
              {
                this.a.e.setAlpha(0.5F);
                this.a.jdField_d_of_type_AndroidWidgetTextView.setAlpha(0.5F);
              }
              else if ((2131375176 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
              {
                this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.5F);
                this.a.a.setAlpha(0.5F);
              }
              break;
            case 1: 
            case 3: 
              if ((2131375202 == paramView.getId()) && (this.a.e != null) && (this.a.jdField_d_of_type_AndroidWidgetTextView != null))
              {
                this.a.e.setAlpha(1.0F);
                this.a.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
              }
              else if ((2131375176 == paramView.getId()) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.a != null))
              {
                this.a.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
                this.a.a.setAlpha(1.0F);
              }
              break;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.MyViewAlphaOnTouchListener
 * JD-Core Version:    0.7.0.1
 */