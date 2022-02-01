package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

class FriendProfileMoreInfoActivity$13
  implements IphonePickerView.PickerViewAdapter
{
  FriendProfileMoreInfoActivity$13(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return 2;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    FriendProfileMoreInfoActivity localFriendProfileMoreInfoActivity;
    if (paramInt2 == 0)
    {
      localFriendProfileMoreInfoActivity = this.a;
      paramInt1 = 2131891484;
    }
    else
    {
      localFriendProfileMoreInfoActivity = this.a;
      paramInt1 = 2131889246;
    }
    return localFriendProfileMoreInfoActivity.getString(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.13
 * JD-Core Version:    0.7.0.1
 */