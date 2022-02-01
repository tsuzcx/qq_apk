package com.tencent.mobileqq.apollo.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class HotChatCenterFragment$6
  implements Runnable
{
  HotChatCenterFragment$6(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void run()
  {
    try
    {
      HotChatCenterFragment.a(this.this$0);
      if (this.this$0.isAdded()) {
        this.this$0.getActivity().runOnUiThread(new HotChatCenterFragment.6.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HotchatActivity", 1, localThrowable, new Object[] { "[update] failed" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.6
 * JD-Core Version:    0.7.0.1
 */