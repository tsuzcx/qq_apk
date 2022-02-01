package com.tencent.av.wtogether.adapter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;

class QGroupExpandableListAdapter$6
  extends TroopAvatarObserver
{
  QGroupExpandableListAdapter$6(QGroupExpandableListAdapter paramQGroupExpandableListAdapter) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getFaceBitmap(113, paramString, false, 0);
    if (localBitmap != null) {
      QGroupExpandableListAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.6
 * JD-Core Version:    0.7.0.1
 */