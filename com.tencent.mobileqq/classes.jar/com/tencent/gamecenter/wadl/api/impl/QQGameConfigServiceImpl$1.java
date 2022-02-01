package com.tencent.gamecenter.wadl.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class QQGameConfigServiceImpl$1
  implements Runnable
{
  QQGameConfigServiceImpl$1(QQGameConfigServiceImpl paramQQGameConfigServiceImpl) {}
  
  public void run()
  {
    ??? = this.this$0.getConfigFile();
    String str = null;
    if (((File)???).exists()) {
      str = FileUtils.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigServiceImpl", 2, "loadConfig content=" + str);
    }
    synchronized (QQGameConfigServiceImpl.access$000(this.this$0))
    {
      QQGameConfigServiceImpl.access$000(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        WadlCommConfig localWadlCommConfig = new WadlCommConfig();
        localWadlCommConfig.a = "comminfo";
        localWadlCommConfig.a(str);
        QQGameConfigServiceImpl.access$000(this.this$0).put("comminfo", localWadlCommConfig);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */