package com.tencent.mobileqq.activity.springfestival.config;

import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.qphone.base.util.QLog;

class SpringFestivalRedpacketConfigManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      EntryConfigBean localEntryConfigBean = this.this$0.a();
      if (localEntryConfigBean == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalRedpacketConfigManager", 2, "startCheckHtmlOfflinePackage springFestivalRedpacketConfBean is empty!");
        }
      }
      else
      {
        SpringFestivalRedpacketConfigManager.a(this.this$0, localEntryConfigBean.htmlOfflineCheckConfig, this.this$0.b(), this.this$0.a());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfigManager", 1, localThrowable, new Object[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager.1
 * JD-Core Version:    0.7.0.1
 */