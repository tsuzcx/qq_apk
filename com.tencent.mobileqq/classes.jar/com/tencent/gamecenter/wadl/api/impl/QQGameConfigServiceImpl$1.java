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
    Object localObject1 = this.this$0.getConfigFile();
    if (((File)localObject1).exists()) {
      localObject1 = FileUtils.readFileContent((File)localObject1);
    } else {
      localObject1 = null;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("loadConfig content=");
    ((StringBuilder)???).append((String)localObject1);
    QLog.d("Wadl_QQGameConfigServiceImpl", 1, ((StringBuilder)???).toString());
    synchronized (QQGameConfigServiceImpl.access$000(this.this$0))
    {
      QQGameConfigServiceImpl.access$000(this.this$0).clear();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool) {
        try
        {
          WadlCommConfig localWadlCommConfig = new WadlCommConfig();
          localWadlCommConfig.a = "comminfo";
          localWadlCommConfig.a((String)localObject1);
          QQGameConfigServiceImpl.access$000(this.this$0).put("comminfo", localWadlCommConfig);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */