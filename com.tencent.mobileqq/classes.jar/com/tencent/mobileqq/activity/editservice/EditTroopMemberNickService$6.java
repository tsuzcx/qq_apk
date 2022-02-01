package com.tencent.mobileqq.activity.editservice;

import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.ShopSetting;
import com.tencent.mobileqq.widget.ColorClearableEditText;

class EditTroopMemberNickService$6
  implements ShopLayout.ShopSetting
{
  EditTroopMemberNickService$6(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.a.a instanceof ColorClearableEditText))
    {
      ColorClearableEditText localColorClearableEditText = (ColorClearableEditText)this.a.a;
      localColorClearableEditText.setCustomCloth(paramInt2, true);
      EditTroopMemberNickService.a(this.a).updateEditTextAndNum(localColorClearableEditText.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.6
 * JD-Core Version:    0.7.0.1
 */