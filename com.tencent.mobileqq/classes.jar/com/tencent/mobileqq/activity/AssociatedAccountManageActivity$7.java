package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;

class AssociatedAccountManageActivity$7
  implements Runnable
{
  AssociatedAccountManageActivity$7(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.a) {
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).deleteHistory(this.this$0.app, this.b);
    }
    this.this$0.runOnUiThread(new AssociatedAccountManageActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7
 * JD-Core Version:    0.7.0.1
 */