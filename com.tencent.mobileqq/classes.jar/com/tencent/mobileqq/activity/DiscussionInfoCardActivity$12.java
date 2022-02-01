package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class DiscussionInfoCardActivity$12
  extends ProfileCardObserver
{
  DiscussionInfoCardActivity$12(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {
      paramObject = (Card)paramObject;
    } else {
      paramObject = null;
    }
    if ((paramBoolean) && (paramObject != null) && (DiscussionInfoCardActivity.r(this.a) != null)) {
      DiscussionInfoCardActivity.r(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.12
 * JD-Core Version:    0.7.0.1
 */