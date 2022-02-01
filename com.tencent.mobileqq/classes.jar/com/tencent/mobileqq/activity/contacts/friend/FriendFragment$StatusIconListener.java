package com.tencent.mobileqq.activity.contacts.friend;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;

class FriendFragment$StatusIconListener
  implements IIconListener
{
  private FriendFragment$StatusIconListener(FriendFragment paramFriendFragment) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((FriendFragment.c(this.a)) && (paramBitmap != null) && (paramInt2 == 200)) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.StatusIconListener
 * JD-Core Version:    0.7.0.1
 */