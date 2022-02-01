package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.qphone.base.remote.SimpleAccount;

class SubAccountBindActivity$3$1$1
  implements Runnable
{
  SubAccountBindActivity$3$1$1(SubAccountBindActivity.3.1 param1) {}
  
  public void run()
  {
    this.a.b.a.hideJuhua();
    this.a.b.a.showQQToast(this.a.b.a.getString(2131916897));
    Intent localIntent = new Intent(this.a.b.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.a.getUin());
    localIntent.putExtra("fromWhere", this.a.b.a.fromWhere);
    this.a.b.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */