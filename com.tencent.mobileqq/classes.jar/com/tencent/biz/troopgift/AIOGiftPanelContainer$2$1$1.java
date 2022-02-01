package com.tencent.biz.troopgift;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDone, time=");
      ((StringBuilder)localObject).append(l - this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", total=");
      ((StringBuilder)localObject).append(l - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long);
      QLog.d("TroopGiftPanel.time", 2, ((StringBuilder)localObject).toString());
    }
    if (paramDownloadTask.jdField_a_of_type_Int == 0)
    {
      localObject = paramDownloadTask.a().getString("filePath");
      try
      {
        paramDownloadTask = new File((String)localObject);
        String str = FileUtils.readFileToString(paramDownloadTask);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDone() content =  ");
          localStringBuilder.append(str);
          localStringBuilder.append(", filePath = ");
          localStringBuilder.append((String)localObject);
          QLog.d("AIOGiftPanelContainer", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new TroopGiftAioPanelData(new JSONObject(str), this.jdField_a_of_type_JavaLangString);
          ((TroopGiftAioPanelData)localObject).a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData = ((TroopGiftAioPanelData)localObject);
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(false);
          if (!this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
            this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          paramDownloadTask.deleteOnExit();
        }
        AIOGiftPanelContainer.a(this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(paramDownloadTask));
        return;
      }
      catch (IOException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(paramDownloadTask));
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError() time =  ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2$1.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", errorCode = ");
      ((StringBuilder)localObject).append(paramDownloadTask.jdField_a_of_type_Int);
      QLog.d("AIOGiftPanelContainer", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2.1.1
 * JD-Core Version:    0.7.0.1
 */