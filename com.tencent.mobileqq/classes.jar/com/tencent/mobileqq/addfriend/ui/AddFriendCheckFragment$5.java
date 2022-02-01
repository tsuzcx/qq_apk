package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;

class AddFriendCheckFragment$5
  implements DialogInterface.OnClickListener
{
  AddFriendCheckFragment$5(AddFriendCheckFragment paramAddFriendCheckFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendCheckFragment.a(this.a)) {
      return;
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.5
 * JD-Core Version:    0.7.0.1
 */