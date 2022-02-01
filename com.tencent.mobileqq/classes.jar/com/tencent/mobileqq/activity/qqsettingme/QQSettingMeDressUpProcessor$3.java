package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import mqq.app.AppRuntime;

class QQSettingMeDressUpProcessor$3
  implements Runnable
{
  QQSettingMeDressUpProcessor$3(QQSettingMeDressUpProcessor paramQQSettingMeDressUpProcessor) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (this.this$0.a.getValue() != null) && (((BusinessInfoCheckUpdate.AppInfo)this.this$0.a.getValue()).iNewFlag.get() == 1))
    {
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.this$0.c.getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null) {
        localIWebProcessManagerService.startWebProcess(-1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor.3
 * JD-Core Version:    0.7.0.1
 */