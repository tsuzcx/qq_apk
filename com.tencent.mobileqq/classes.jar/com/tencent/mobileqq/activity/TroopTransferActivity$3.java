package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class TroopTransferActivity$3
  extends AvatarObserver
{
  TroopTransferActivity$3(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.h.a(paramString) != null)) {
      this.a.h.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.3
 * JD-Core Version:    0.7.0.1
 */