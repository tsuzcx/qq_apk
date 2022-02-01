package com.tencent.biz.troop.feeds;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;

class TroopNewGuidePopWindow$1
  implements DialogInterface.OnDismissListener
{
  TroopNewGuidePopWindow$1(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.deleteObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.1
 * JD-Core Version:    0.7.0.1
 */