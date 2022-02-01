package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback;

class ForwardFriendListActivity$8
  implements ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback
{
  ForwardFriendListActivity$8(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(View paramView)
  {
    if (ForwardFriendListActivity.a(this.a))
    {
      ForwardFriendListActivity.b(this.a, paramView);
      return;
    }
    ForwardFriendListActivity.c(this.a, paramView);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return ForwardFriendListActivity.a(this.a, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.8
 * JD-Core Version:    0.7.0.1
 */