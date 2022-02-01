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
      this.a.a.setCursorVisible(true);
      EditTroopMemberNickService.b(this.a, 0);
      if (this.a.v != null) {
        this.a.v.setVisibility(8);
      }
      if (this.a.q != null)
      {
        this.a.q.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.a.q.getLayoutParams()).bottomMargin = 0;
        this.a.t.setImageResource(2130848960);
        this.a.u.setImageResource(2130848954);
      }
    }
    else
    {
      if (EditTroopMemberNickService.h(this.a) > 0)
      {
        EditTroopMemberNickService localEditTroopMemberNickService = this.a;
        EditTroopMemberNickService.c(localEditTroopMemberNickService, EditTroopMemberNickService.h(localEditTroopMemberNickService));
        return;
      }
      this.a.q.setVisibility(8);
      this.a.a.setCursorVisible(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.9
 * JD-Core Version:    0.7.0.1
 */