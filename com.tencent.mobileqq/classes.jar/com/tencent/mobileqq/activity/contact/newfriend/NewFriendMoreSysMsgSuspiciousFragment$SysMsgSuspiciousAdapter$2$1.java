package com.tencent.mobileqq.activity.contact.newfriend;

import android.view.View;
import java.util.List;

class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2$1
  implements Runnable
{
  NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2$1(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2 param2, List paramList) {}
  
  public void run()
  {
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.b.this$0, this.a);
    if ((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.e(this.b.this$0) != null) && (!NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.e(this.b.this$0).isEmpty()))
    {
      if (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.f(this.b.this$0) != null) {
        NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.f(this.b.this$0).setVisibility(8);
      }
    }
    else if (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.f(this.b.this$0) != null) {
      NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.f(this.b.this$0).setVisibility(0);
    }
    this.b.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */