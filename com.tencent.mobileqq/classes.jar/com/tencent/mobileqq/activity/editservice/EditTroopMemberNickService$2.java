package com.tencent.mobileqq.activity.editservice;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditTroopMemberNickService$2
  implements View.OnClickListener
{
  EditTroopMemberNickService$2(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void onClick(View paramView)
  {
    EditTroopMemberNickService.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.2
 * JD-Core Version:    0.7.0.1
 */