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
    Object localObject1;
    if ((this.a.content_list != null) && (this.a.content_list.size() > 0))
    {
      localObject1 = (String)this.a.content_list.get(0);
      Object localObject2 = QFindConfigUtil.a((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("config0 ");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("QFind", 2, ((StringBuilder)localObject3).toString());
      }
      if (localObject2 == null) {
        return;
      }
      int i = 1;
      while (i < this.a.content_list.size())
      {
        String str = (String)this.a.content_list.get(i);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("receiveAllConfigs|type: 65,content: ");
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append(",version: ");
          ((StringBuilder)localObject3).append(this.a.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject3).toString());
        }
        QFindConfig localQFindConfig = QFindConfigUtil.a(str);
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (localQFindConfig != null)
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (localQFindConfig.a > ((QFindConfig)localObject2).a)
          {
            localObject4 = str;
            localObject3 = localQFindConfig;
          }
        }
        i += 1;
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
      Object localObject3 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("qfind_assist");
      ((StringBuilder)localObject4).append(SmartDeviceProxyMgr.b(this.this$0).getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject3).putString(((StringBuilder)localObject4).toString(), String.valueOf(((QFindConfig)localObject2).b));
      ((SharedPreferences.Editor)localObject3).commit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir());
      ((StringBuilder)localObject2).append("/qfindconfig");
      FileUtils.writeFile(((StringBuilder)localObject2).toString(), (String)localObject1);
      this.this$0.a(null, false);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receiveAllConfigs|type: 65content_list is emtpy,version: ");
      ((StringBuilder)localObject1).append(this.a.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr.2
 * JD-Core Version:    0.7.0.1
 */