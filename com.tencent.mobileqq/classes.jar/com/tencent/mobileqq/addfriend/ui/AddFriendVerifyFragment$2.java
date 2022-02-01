package com.tencent.mobileqq.addfriend.ui;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AddFriendVerifyFragment$2
  implements Runnable
{
  AddFriendVerifyFragment$2(AddFriendVerifyFragment paramAddFriendVerifyFragment, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((AddFriendVerifyFragment)localObject).a(AddFriendVerifyFragment.a((AddFriendVerifyFragment)localObject));
    ThreadManager.getUIHandler().post(new AddFriendVerifyFragment.2.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.2
 * JD-Core Version:    0.7.0.1
 */