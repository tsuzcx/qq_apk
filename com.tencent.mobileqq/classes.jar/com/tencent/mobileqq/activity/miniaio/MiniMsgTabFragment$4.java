package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class MiniMsgTabFragment$4
  implements Runnable
{
  MiniMsgTabFragment$4(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void run()
  {
    Intent localIntent = MiniMsgTabFragment.a(this.this$0);
    localIntent.putExtra("miniAppID", MiniMsgTabFragment.a(this.this$0));
    localIntent.putExtra("clickID", -1);
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.setResult(-1, localIntent);
      localFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.4
 * JD-Core Version:    0.7.0.1
 */