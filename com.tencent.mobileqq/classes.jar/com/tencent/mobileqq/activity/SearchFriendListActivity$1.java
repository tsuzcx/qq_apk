package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class SearchFriendListActivity$1
  extends AvatarObserver
{
  SearchFriendListActivity$1(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      SearchFriendListActivity.b(this.a).notifyDataSetChanged();
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null)) {
      SearchFriendListActivity.b(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity.1
 * JD-Core Version:    0.7.0.1
 */