package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class NewFriendMoreSysMsgAdapter$6
  extends AvatarObserver
{
  NewFriendMoreSysMsgAdapter$6(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.6
 * JD-Core Version:    0.7.0.1
 */