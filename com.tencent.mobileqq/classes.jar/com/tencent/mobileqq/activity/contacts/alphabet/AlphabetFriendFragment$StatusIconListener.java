package com.tencent.mobileqq.activity.contacts.alphabet;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;

class AlphabetFriendFragment$StatusIconListener
  implements IIconListener
{
  private AlphabetFriendFragment$StatusIconListener(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((AlphabetFriendFragment.b(this.a)) && (paramBitmap != null) && (paramInt2 == 200)) {
      AlphabetFriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.StatusIconListener
 * JD-Core Version:    0.7.0.1
 */