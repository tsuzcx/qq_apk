package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;

class AddFriendCheckFragment$6
  implements DialogInterface.OnClickListener
{
  AddFriendCheckFragment$6(AddFriendCheckFragment paramAddFriendCheckFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendCheckFragment.a(this.a)) {
      return;
    }
    if (AddFriendCheckFragment.a(this.a) == 1)
    {
      this.a.getActivity().finish();
      return;
    }
    AddFriendCheckFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.6
 * JD-Core Version:    0.7.0.1
 */