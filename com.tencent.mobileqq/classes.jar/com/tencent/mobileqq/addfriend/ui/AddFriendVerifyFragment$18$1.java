package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddFriendVerifyFragment$18$1
  implements DialogInterface.OnClickListener
{
  AddFriendVerifyFragment$18$1(AddFriendVerifyFragment.18 param18) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.g.cancel();
      this.a.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.18.1
 * JD-Core Version:    0.7.0.1
 */