package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;

class TroopInviteStatusFragment$3
  implements Runnable
{
  TroopInviteStatusFragment$3(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    if ((this.this$0.l != null) && (!this.this$0.l.isFinishing()))
    {
      Intent localIntent = AIOUtils.a(new Intent(this.this$0.l, SplashActivity.class), null);
      localIntent.putExtra("uin", this.this$0.n);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.this$0.o);
      localIntent.putExtra("troop_uin", this.this$0.n);
      this.this$0.startActivity(localIntent);
      this.this$0.l.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.3
 * JD-Core Version:    0.7.0.1
 */