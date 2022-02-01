package com.tencent.mobileqq.activity.contacts.alphabet;

import android.os.Vibrator;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class AlphabetFriendFragment$1
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
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.1
 * JD-Core Version:    0.7.0.1
 */