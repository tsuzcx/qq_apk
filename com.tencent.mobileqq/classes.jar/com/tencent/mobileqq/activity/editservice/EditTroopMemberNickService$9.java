package com.tencent.mobileqq.activity.editservice;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;

class EditTroopMemberNickService$9
  implements SoftInputDetectView.OnImStateChangedListener
{
  EditTroopMemberNickService$9(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    EditTroopMemberNickService.b(this.a, paramBoolean);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      EditTroopMemberNickService.a(this.a, 0);
      if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = 0;
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847309);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847303);
      }
    }
    else
    {
      if (EditTroopMemberNickService.b(this.a) > 0)
      {
        EditTroopMemberNickService localEditTroopMemberNickService = this.a;
        EditTroopMemberNickService.a(localEditTroopMemberNickService, EditTroopMemberNickService.b(localEditTroopMemberNickService));
        return;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.9
 * JD-Core Version:    0.7.0.1
 */