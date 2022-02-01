package com.tencent.biz.troopgift;

import android.widget.TextView;
import com.tencent.image.URLDrawable.DownloadListener;

class TroopGiftPanel$10
  implements URLDrawable.DownloadListener
{
  TroopGiftPanel$10(TroopGiftPanel paramTroopGiftPanel, TextView paramTextView) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.10
 * JD-Core Version:    0.7.0.1
 */