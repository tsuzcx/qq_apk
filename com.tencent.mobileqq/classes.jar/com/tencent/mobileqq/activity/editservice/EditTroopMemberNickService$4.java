package com.tencent.mobileqq.activity.editservice;

import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.HideInputmethod;

class EditTroopMemberNickService$4
  implements ShopLayout.HideInputmethod
{
  EditTroopMemberNickService$4(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void a()
  {
    if (this.a.q == null) {
      return;
    }
    if ((this.a.q.getVisibility() == 0) || (EditTroopMemberNickService.c(this.a)))
    {
      EditTroopMemberNickService.d(this.a).hideInputMethod();
      this.a.q.setVisibility(8);
      this.a.a.setCursorVisible(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.4
 * JD-Core Version:    0.7.0.1
 */