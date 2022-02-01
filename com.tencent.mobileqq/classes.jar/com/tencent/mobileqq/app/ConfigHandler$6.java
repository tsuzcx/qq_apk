package com.tencent.mobileqq.app;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

class ConfigHandler$6
  implements Runnable
{
  ConfigHandler$6(ConfigHandler paramConfigHandler, String paramString, StatusManager paramStatusManager, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    Object localObject1 = new File(this.this$0.a.getApplication().getFilesDir(), "rich_status.tmp");
    Object localObject2 = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.downloadData(this.this$0.a, (String)localObject2, (File)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleUpdateStatusActions download ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" result ");
      ((StringBuilder)localObject2).append(i);
      QLog.w("Q.richstatus.xml", 2, ((StringBuilder)localObject2).toString());
    }
    if (i == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a((File)localObject1, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer)) {
        this.this$0.notifyUI(7, true, Integer.valueOf(102));
      } else {
        this.this$0.notifyUI(7, false, Integer.valueOf(-3));
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("httpdownload failed: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", result ");
        ((StringBuilder)localObject1).append(i);
        QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject1).toString());
      }
      if ((i != 4) && (i != 12)) {
        this.this$0.notifyUI(7, false, Integer.valueOf(-1));
      } else {
        this.this$0.notifyUI(7, false, Integer.valueOf(-3));
      }
    }
    localObject1 = StatisticCollector.getInstance(BaseApplication.getContext());
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("result", String.valueOf(i));
    ((HashMap)localObject2).put("version", String.valueOf(this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer));
    ((HashMap)localObject2).put("url", this.jdField_a_of_type_JavaLangString);
    String str = this.this$0.a.getCurrentAccountUin();
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject1).collectPerformance(str, "RichStatusAction", bool, 0L, 0L, (HashMap)localObject2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.6
 * JD-Core Version:    0.7.0.1
 */