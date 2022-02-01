package com.tencent.device.devicemgr;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.qfind.QFindConfig;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class SmartDeviceProxyMgr$2
  implements Runnable
{
  SmartDeviceProxyMgr$2(SmartDeviceProxyMgr paramSmartDeviceProxyMgr, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    if ((this.a.content_list != null) && (this.a.content_list.size() > 0))
    {
      localObject1 = (String)this.a.content_list.get(0);
      localObject2 = QFindConfigUtil.a((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("QFind", 2, "config0 " + (String)localObject1);
      }
      if (localObject2 != null) {}
    }
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      Object localObject2;
      return;
      int i = 1;
      while (i < this.a.content_list.size())
      {
        String str = (String)this.a.content_list.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 65,content: " + str + ",version: " + this.a.version.get());
        }
        QFindConfig localQFindConfig = QFindConfigUtil.a(str);
        Object localObject4 = localObject2;
        localObject3 = localObject1;
        if (localQFindConfig != null)
        {
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (localQFindConfig.a > ((QFindConfig)localObject2).a)
          {
            localObject4 = localQFindConfig;
            localObject3 = str;
          }
        }
        i += 1;
        localObject2 = localObject4;
        localObject1 = localObject3;
      }
      Object localObject3 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
      ((SharedPreferences.Editor)localObject3).putString("qfind_assist" + SmartDeviceProxyMgr.a(this.this$0).getCurrentAccountUin(), String.valueOf(((QFindConfig)localObject2).b));
      ((SharedPreferences.Editor)localObject3).commit();
      FileUtils.a(BaseApplicationImpl.getApplication().getFilesDir() + "/qfindconfig", (String)localObject1);
      this.this$0.a(null, false);
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 65content_list is emtpy,version: " + this.a.version.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr.2
 * JD-Core Version:    0.7.0.1
 */