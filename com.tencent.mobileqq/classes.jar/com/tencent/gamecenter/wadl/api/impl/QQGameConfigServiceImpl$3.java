package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.MobileQQ;

class QQGameConfigServiceImpl$3
  implements Runnable
{
  QQGameConfigServiceImpl$3(QQGameConfigServiceImpl paramQQGameConfigServiceImpl, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.this$0.getConfigFile();
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (FileUtils.a(((File)localObject).getAbsolutePath(), this.jdField_a_of_type_JavaLangString, false))
    {
      GameCenterSpUtils.a("LAST_GET_CONF_VERSION", this.jdField_a_of_type_Long);
      GameCenterSpUtils.a("LAST_GET_CONF_TIME", QQGameConfigServiceImpl.access$200(this.this$0));
      localObject = new Intent("com.tencent.gamecenter.action");
      ((Intent)localObject).setPackage(MobileQQ.sMobileQQ.getPackageName());
      ((Intent)localObject).putExtra("key_event_id", 1);
      MobileQQ.sMobileQQ.sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */