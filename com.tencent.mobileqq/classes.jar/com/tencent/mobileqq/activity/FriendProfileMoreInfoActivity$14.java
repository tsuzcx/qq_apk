package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

class FriendProfileMoreInfoActivity$14
  implements IphonePickerView.IphonePickListener
{
  FriendProfileMoreInfoActivity$14(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      this.a.c = true;
      this.a.a(paramInt1, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.14
 * JD-Core Version:    0.7.0.1
 */