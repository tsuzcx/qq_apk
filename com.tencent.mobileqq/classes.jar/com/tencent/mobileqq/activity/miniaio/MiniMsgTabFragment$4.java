package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;

class MiniMsgTabFragment$4
  implements Runnable
{
  MiniMsgTabFragment$4(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void run()
  {
    Intent localIntent = MiniMsgTabFragment.k(this.this$0);
    localIntent.putExtra("miniAppID", MiniMsgTabFragment.d(this.this$0));
    localIntent.putExtra("clickID", -1);
    BaseActivity localBaseActivity = this.this$0.getBaseActivity();
    if (localBaseActivity != null)
    {
      localBaseActivity.setResult(-1, localIntent);
      localBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.4
 * JD-Core Version:    0.7.0.1
 */