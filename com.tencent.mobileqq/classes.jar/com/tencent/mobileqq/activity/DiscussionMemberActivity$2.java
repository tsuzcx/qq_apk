package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class DiscussionMemberActivity$2
  extends AvatarObserver
{
  DiscussionMemberActivity$2(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (this.a.g != null) {
      this.a.g.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.2
 * JD-Core Version:    0.7.0.1
 */