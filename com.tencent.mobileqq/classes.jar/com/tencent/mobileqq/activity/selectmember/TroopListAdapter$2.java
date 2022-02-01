package com.tencent.mobileqq.activity.selectmember;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;

class TroopListAdapter$2
  extends TroopBusinessObserver
{
  TroopListAdapter$2(TroopListAdapter paramTroopListAdapter) {}
  
  public void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getFaceBitmap(113, paramString, false, 0);
    if (localBitmap != null) {
      TroopListAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListAdapter.2
 * JD-Core Version:    0.7.0.1
 */