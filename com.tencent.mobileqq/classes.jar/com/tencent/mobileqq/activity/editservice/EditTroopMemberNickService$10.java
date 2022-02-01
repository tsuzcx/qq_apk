package com.tencent.mobileqq.activity.editservice;

import android.content.res.Resources;
import android.widget.EditText;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.PureColorAdapter;
import com.tencent.mobileqq.widget.ClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.ColorClearableEditText;

class EditTroopMemberNickService$10
  implements ClearableEditText.OnTextClearedListener
{
  EditTroopMemberNickService$10(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      ColorClearableEditText localColorClearableEditText = (ColorClearableEditText)this.a.jdField_a_of_type_AndroidWidgetEditText;
      localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
      localColorClearableEditText.setCustomCloth(0, false);
    }
    else
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.setTextColor(EditTroopMemberNickService.a(this.a).getColor(2131167157));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter.a(-1);
    this.a.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.10
 * JD-Core Version:    0.7.0.1
 */