package com.tencent.mobileqq.activity.contact.connections;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;

class ConnectsExplorationFriendAdapter$1
  implements IIconListener
{
  ConnectsExplorationFriendAdapter$1(ConnectsExplorationFriendAdapter paramConnectsExplorationFriendAdapter) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.1
 * JD-Core Version:    0.7.0.1
 */