package com.tencent.biz.troopgift;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AIOGiftPanelContainer$2$1
  extends TroopGiftCallback
{
  AIOGiftPanelContainer$2$1(AIOGiftPanelContainer.2 param2, TroopGiftManager paramTroopGiftManager, long paramLong, AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 5) {
      TroopGiftAioPanelData.a(paramString2);
    }
    do
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onGetExtraData() , configURL = " + paramString1 + ", serverVer=" + paramInt + ", localVer=" + i + ", exIds=" + paramString2);
        }
        QLog.d("TroopGiftPanel.time", 1, "onGetExtraData, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        if ((paramInt > i) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null)) {
          break;
        }
        AIOGiftPanelContainer.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int == 4)) {
          TroopGiftAioPanelData.a(paramString2, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        }
      }
    } while (TextUtils.isEmpty(paramString1));
    Object localObject = new File(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH + "troopGiftConfig.tmp";
    paramString1 = new DownloadTask(paramString1, new File((String)localObject));
    paramString1.b = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a().a(paramString1, new AIOGiftPanelContainer.2.1.1(this, l, paramString2, paramInt), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2.1
 * JD-Core Version:    0.7.0.1
 */