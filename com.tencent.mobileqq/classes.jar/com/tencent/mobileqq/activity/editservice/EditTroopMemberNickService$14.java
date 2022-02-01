package com.tencent.mobileqq.activity.editservice;

import android.view.View;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class EditTroopMemberNickService$14
  implements OnItemSelectListener
{
  EditTroopMemberNickService$14(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1) {
      EditTroopMemberNickService.d(this.a).onFinish();
    }
    if (paramInt == 2) {
      EditTroopMemberNickService.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.14
 * JD-Core Version:    0.7.0.1
 */