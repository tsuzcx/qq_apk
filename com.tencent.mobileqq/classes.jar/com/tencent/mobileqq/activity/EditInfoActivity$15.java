package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditInfoActivity$15
  implements View.OnClickListener
{
  EditInfoActivity$15(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    EditInfoActivity localEditInfoActivity = this.a;
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      localEditInfoActivity.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label137;
      }
      this.a.b();
      if (this.a.getIntent().getBooleanExtra("key_need_hide_couser_when_emoj", false)) {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838192);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703664));
      if ((!this.a.b) && (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label137:
      this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848264);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703654));
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.15
 * JD-Core Version:    0.7.0.1
 */