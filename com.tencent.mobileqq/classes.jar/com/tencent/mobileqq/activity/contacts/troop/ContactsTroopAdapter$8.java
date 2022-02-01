package com.tencent.mobileqq.activity.contacts.troop;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;

class ContactsTroopAdapter$8
  extends TroopAvatarObserver
{
  ContactsTroopAdapter$8(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getFaceBitmap(113, paramString, false, 0);
    if (localBitmap != null) {
      ContactsTroopAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.8
 * JD-Core Version:    0.7.0.1
 */