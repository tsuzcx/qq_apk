package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

class FriendProfileMoreInfoActivity$14
  implements IphonePickerView.IphonePickListener
{
  FriendProfileMoreInfoActivity$14(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.a.r != null) && (this.a.r.isShowing())) {
      this.a.r.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    FriendProfileMoreInfoActivity localFriendProfileMoreInfoActivity = this.a;
    localFriendProfileMoreInfoActivity.z = true;
    localFriendProfileMoreInfoActivity.a(paramInt1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.14
 * JD-Core Version:    0.7.0.1
 */