package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anwj;
import bhrq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class DeviceProfileManager$2
  implements Runnable
{
  DeviceProfileManager$2(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString) {}
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$RespGetConfig.config_list.get(0);
    Object localObject1 = localConfig.content_list;
    QLog.i("DeviceProfileManager", 1, "onDPCResponse is called, version=" + localConfig.version.get());
    if (localObject1 != null) {}
    boolean bool1;
    int i;
    SharedPreferences.Editor localEditor2;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor3;
    HashMap localHashMap;
    label262:
    Object localObject8;
    anwj localanwj;
    Object localObject7;
    SharedPreferences.Editor localEditor1;
    Object localObject6;
    label465:
    boolean bool2;
    for (;;)
    {
      try
      {
        if (((PBRepeatField)localObject1).size() != 0)
        {
          bool1 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
          if (!bool1) {}
        }
        else
        {
          return;
        }
        ??? = new HashMap();
        i = 0;
        if (i < ((PBRepeatField)localObject1).size())
        {
          if (this.this$0.a((String)((PBRepeatField)localObject1).get(i), (HashMap)???)) {
            break label843;
          }
          QLog.e("DeviceProfileManager", 1, "onDPCResponse parseDPCXML error, so return");
          break label843;
        }
        Iterator localIterator = ((HashMap)???).entrySet().iterator();
        localEditor2 = bhrq.a(BaseApplicationImpl.getApplication(), "dpcConfig").edit();
        localSharedPreferences = bhrq.a(BaseApplicationImpl.getApplication(), "dpcConfig_account");
        localEditor3 = localSharedPreferences.edit();
        localObject1 = null;
        localObject7 = DeviceProfileManager.a().b;
      }
      catch (Exception localException) {}finally
      {
        QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + false);
        DeviceProfileManager.a(this.this$0, false);
      }
      bool1 = true;
      ??? = DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a(), (String)localObject8);
      localEditor1 = localEditor3;
      localObject6 = localObject3;
      DeviceProfileManager.a(this.this$0, QLog.isColorLevel(), 1, new Object[] { localObject8, localanwj.toString(), Boolean.valueOf(bool1) });
      if (localObject6 != null)
      {
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject6).get(???);
        bool1 = false;
        localObject8 = localDPCConfigInfo;
        if (localDPCConfigInfo == null)
        {
          bool1 = true;
          localObject7 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject7).get(???);
          if ((localObject7 != null) && (((DeviceProfileManager.DPCConfigInfo)localObject7).clone() != null)) {
            localObject8 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject7).clone();
          }
        }
        else
        {
          DeviceProfileManager.a(this.this$0, QLog.isColorLevel(), 3, new Object[] { ???, localObject8, Boolean.valueOf(bool1) });
          bool2 = DeviceProfileManager.a((DeviceProfileManager.DPCConfigInfo)localObject8, localanwj.b.toString().trim());
          if (!bool1) {
            break label850;
          }
          ((HashMap)localObject6).put(???, localObject8);
          break label850;
        }
      }
    }
    for (;;)
    {
      label631:
      localEditor1.putString((String)???, localanwj.b);
      label843:
      label850:
      do
      {
        DeviceProfileManager.a(this.this$0, QLog.isColorLevel(), 4, new Object[] { ???, localObject8, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        break label262;
        localObject7 = DeviceProfileManager.b(this.this$0);
        bool1 = false;
        localObject6 = localHashMap;
        localEditor1 = localEditor2;
        ??? = localObject8;
        break label465;
        synchronized (this.this$0)
        {
          DeviceProfileManager.a(this.this$0, localHashMap);
          if ((DeviceProfileManager.a() != null) && (DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(DeviceProfileManager.a().jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))) {
            DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap = localObject3;
          }
          bool1 = DeviceProfileManager.a(this.this$0, localConfig, localEditor2, localSharedPreferences, localEditor3);
          QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + bool1);
          DeviceProfileManager.a(this.this$0, bool1);
          return;
        }
        i += 1;
        break;
        if (bool1) {
          break label631;
        }
      } while (!bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager.2
 * JD-Core Version:    0.7.0.1
 */