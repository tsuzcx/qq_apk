package com.tencent.mobileqq.app;

import abti;
import android.content.SharedPreferences;
import bdmm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import mqq.manager.Manager;

public class DeviceProfileManager$AccountDpcManager
  implements Manager
{
  public static HashSet<String> a;
  public AppInterface a;
  private String a;
  public HashMap<String, DeviceProfileManager.DPCConfigInfo> a;
  public HashMap<String, DeviceProfileManager.DPCConfigInfo> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public DeviceProfileManager$AccountDpcManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaLangString = abti.a(paramAppInterface.getCurrentAccountUin());
    if (BaseApplicationImpl.sProcessId != 9) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null) {
      return "";
    }
    return abti.a(paramAppInterface.getCurrentAccountUin()) + "_" + paramString;
  }
  
  private String a(String paramString)
  {
    return this.jdField_a_of_type_JavaLangString + "_" + paramString;
  }
  
  private void a()
  {
    DeviceProfileManager.AccountDpcManager.DpcAccountNames[] arrayOfDpcAccountNames = DeviceProfileManager.AccountDpcManager.DpcAccountNames.values();
    int j = arrayOfDpcAccountNames.length;
    int i = 0;
    while (i < j)
    {
      DeviceProfileManager.AccountDpcManager.DpcAccountNames localDpcAccountNames = arrayOfDpcAccountNames[i];
      this.b.put(a(localDpcAccountNames.name()), new DeviceProfileManager.DPCConfigInfo());
      jdField_a_of_type_JavaUtilHashSet.add(localDpcAccountNames.name());
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a();
    if (!paramBoolean) {
      return;
    }
    SharedPreferences localSharedPreferences = bdmm.a(BaseApplicationImpl.getApplication(), "dpcConfig_account");
    DeviceProfileManager.AccountDpcManager.DpcAccountNames[] arrayOfDpcAccountNames = DeviceProfileManager.AccountDpcManager.DpcAccountNames.values();
    int j = arrayOfDpcAccountNames.length;
    int i = 0;
    label30:
    String str1;
    String str2;
    DeviceProfileManager.DPCConfigInfo localDPCConfigInfo;
    if (i < j)
    {
      str1 = a(arrayOfDpcAccountNames[i].name());
      str2 = localSharedPreferences.getString(str1, "");
      if (!"".equals(str2)) {
        break label155;
      }
      localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.b.get(str1)).clone();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, localDPCConfigInfo);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceProfileManager", 2, "init loop mFeatureMapLV2_account MAP: " + str1 + "=" + localDPCConfigInfo.toString());
      }
      i += 1;
      break label30;
      break;
      label155:
      localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
      DeviceProfileManager.a(localDPCConfigInfo, str2);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceProfileManager", 2, "AccountDpcManager onDestroy()");
    }
    synchronized (DeviceProfileManager.a())
    {
      DeviceProfileManager.a(null);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      DeviceProfileManager.a().a(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager
 * JD-Core Version:    0.7.0.1
 */