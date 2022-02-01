package com.tencent.mobileqq.activity.selectmember;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;

class TroopListBaseAdapter$4
  extends TroopBusinessObserver
{
  TroopListBaseAdapter$4(TroopListBaseAdapter paramTroopListBaseAdapter) {}
  
  public void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getFaceBitmap(113, paramString, false, 0);
    if (localBitmap != null) {
      TroopListBaseAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */