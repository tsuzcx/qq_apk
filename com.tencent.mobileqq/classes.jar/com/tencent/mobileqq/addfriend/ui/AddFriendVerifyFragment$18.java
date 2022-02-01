package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddFriendVerifyFragment$18
  implements Runnable
{
  AddFriendVerifyFragment$18(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((AddFriendVerifyFragment)localObject).a = DialogUtil.a(((AddFriendVerifyFragment)localObject).getActivity(), 230);
    this.this$0.a.setMessage(2131694463);
    localObject = new AddFriendVerifyFragment.18.1(this);
    this.this$0.a.setPositiveButton(2131694583, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.18
 * JD-Core Version:    0.7.0.1
 */