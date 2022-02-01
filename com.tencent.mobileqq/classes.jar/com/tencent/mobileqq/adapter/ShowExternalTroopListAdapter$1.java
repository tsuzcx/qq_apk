package com.tencent.mobileqq.adapter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;

class ShowExternalTroopListAdapter$1
  extends TroopAvatarObserver
{
  ShowExternalTroopListAdapter$1(ShowExternalTroopListAdapter paramShowExternalTroopListAdapter) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getBitmapFromCache(113, paramString);
    if (localBitmap != null) {
      this.a.a(paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.1
 * JD-Core Version:    0.7.0.1
 */