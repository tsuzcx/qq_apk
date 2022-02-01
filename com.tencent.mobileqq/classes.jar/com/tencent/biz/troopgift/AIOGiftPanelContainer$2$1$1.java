package com.tencent.biz.troopgift;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class AIOGiftPanelContainer$2$1$1
  extends DownloadListener
{
  AIOGiftPanelContainer$2$1$1(AIOGiftPanelContainer.2.1 param1, long paramLong, String paramString, int paramInt) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "onDone, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
    }
    if (paramDownloadTask.jdField_a_of_type_Int == 0) {
      localObject = paramDownloadTask.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramDownloadTask = new File((String)localObject);
        String str = FileUtils.b(paramDownloadTask);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new TroopGiftAioPanelData(new JSONObject(str), this.jdField_a_of_type_JavaLangString);
          ((TroopGiftAioPanelData)localObject).a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = ((TroopGiftAioPanelData)localObject);
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(false);
          if (!this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
            this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          paramDownloadTask.deleteOnExit();
        }
        AIOGiftPanelContainer.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
      }
      catch (IOException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
    }
    QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_Long) + ", errorCode = " + paramDownloadTask.jdField_a_of_type_Int);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2.1.1
 * JD-Core Version:    0.7.0.1
 */