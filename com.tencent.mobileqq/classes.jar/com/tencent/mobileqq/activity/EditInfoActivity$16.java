package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditInfoActivity$16
  implements View.OnClickListener
{
  EditInfoActivity$16(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848264);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703659));
    this.a.jdField_a_of_type_Boolean = false;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.16
 * JD-Core Version:    0.7.0.1
 */