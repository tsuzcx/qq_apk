package com.tencent.biz.troop.feeds;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class TroopNewGuidePopWindow$10
  extends Handler
{
  TroopNewGuidePopWindow$10(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "MSG_SHOW_WINDOW mTroopNotify = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify + ", mTroopNotifyAd = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd != null) {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.10
 * JD-Core Version:    0.7.0.1
 */