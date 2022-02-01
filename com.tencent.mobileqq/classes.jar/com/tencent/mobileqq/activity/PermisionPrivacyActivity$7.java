package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;

class PermisionPrivacyActivity$7
  implements Runnable
{
  PermisionPrivacyActivity$7(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    int i = FriendIntimateRelationshipHelper.a(this.this$0.app);
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.runOnUiThread(new PermisionPrivacyActivity.7.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.7
 * JD-Core Version:    0.7.0.1
 */