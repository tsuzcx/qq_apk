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
    if (paramMessage.what != 1001) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_SHOW_WINDOW mTroopNotify = ");
      paramMessage.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify);
      paramMessage.append(", mTroopNotifyAd = ");
      paramMessage.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd);
      QLog.d("TroopTipsPopWindow", 2, paramMessage.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd != null)
    {
      paramMessage = this.a;
      paramMessage.a(paramMessage.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.10
 * JD-Core Version:    0.7.0.1
 */