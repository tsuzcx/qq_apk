package com.tencent.mobileqq.activity.contacts.fragment;

import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class AlphabetFriendFragment$1
  implements Runnable
{
  AlphabetFriendFragment$1(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  public void run()
  {
    try
    {
      if (AlphabetFriendFragment.a(this.this$0) == null) {
        AlphabetFriendFragment.a(this.this$0, (Vibrator)this.this$0.getActivity().getSystemService("vibrator"));
      }
      AlphabetFriendFragment.a(this.this$0).vibrate(20L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("contacts.fragment.AlphabetFriendFragment", 2, "Vibrator exception.");
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.AlphabetFriendFragment.1
 * JD-Core Version:    0.7.0.1
 */