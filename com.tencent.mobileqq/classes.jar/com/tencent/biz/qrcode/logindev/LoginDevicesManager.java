package com.tencent.biz.qrcode.logindev;

import QQService.InstanceInfo;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.DeviceManageConfBean;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class LoginDevicesManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<LoginDevicesManager.IDevListRefreshListener> jdField_a_of_type_JavaUtilArrayList = null;
  private List<LoginDevItem> jdField_a_of_type_JavaUtilList;
  
  public LoginDevicesManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new LoginDevicesManager.1(this));
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      return 4;
    }
    return ((LoginDevItem)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (DeviceManageConfBean)QConfigManager.a().a(528);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localObject != null) && (((DeviceManageConfBean)localObject).a == 1)) {}
    for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localObject = (LoginDevItem)this.jdField_a_of_type_JavaUtilList.get(0);
        localStringBuilder.append(((LoginDevItem)localObject).jdField_a_of_type_JavaLangString).append(" ").append(((LoginDevItem)localObject).jdField_b_of_type_JavaLangString).append(" ").append(HardCodeUtil.a(2131693887));
        if (bool) {
          localStringBuilder.append("，").append(HardCodeUtil.a(2131694830));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(HardCodeUtil.a(2131698906));
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(((LoginDevItem)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString).append("、");
        }
        if (bool)
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "，");
          localStringBuilder.append(HardCodeUtil.a(2131694830));
        }
        else
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "。");
        }
      }
    }
  }
  
  public String a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((LoginDevItem)localIterator.next()).jdField_a_of_type_JavaLangString).append("、");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
    }
    return paramContext.getString(2131717008, new Object[] { localStringBuilder.toString() });
  }
  
  public void a(LoginDevicesManager.IDevListRefreshListener paramIDevListRefreshListener)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramIDevListRefreshListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramIDevListRefreshListener);
      }
      if (paramIDevListRefreshListener != null) {
        paramIDevListRefreshListener.a(this.jdField_a_of_type_JavaUtilList);
      }
      return;
    }
    finally {}
  }
  
  public boolean a(SvcRespParam paramSvcRespParam)
  {
    boolean bool = true;
    if ((paramSvcRespParam == null) || (paramSvcRespParam.onlineinfos == null))
    {
      bool = false;
      return bool;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Iterator localIterator = paramSvcRespParam.onlineinfos.iterator();
    int i = 0;
    label61:
    while (localIterator.hasNext())
    {
      OnlineInfos localOnlineInfos = (OnlineInfos)localIterator.next();
      if (localOnlineInfos.onlineStatus != 0)
      {
        int j = (int)localOnlineInfos.uClientType;
        if (LoginDevicesUtils.a(j))
        {
          LoginDevItem localLoginDevItem = new LoginDevItem(j);
          localLoginDevItem.jdField_a_of_type_Long = localOnlineInfos.instanceId;
          this.jdField_a_of_type_JavaUtilList.add(localLoginDevItem);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localLoginDevItem.toString());
          }
        }
        if ((j != 66818) && (j != 66831) && (j != 81154)) {
          break label345;
        }
        i = 1;
      }
    }
    label345:
    for (;;)
    {
      break label61;
      if ((i == 0) && (paramSvcRespParam.PCstat != 0) && ((paramSvcRespParam.iPCClientType == 65793) || (paramSvcRespParam.iPCClientType == 77313)))
      {
        paramSvcRespParam = new LoginDevItem(paramSvcRespParam.iPCClientType);
        this.jdField_a_of_type_JavaUtilList.add(0, paramSvcRespParam);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, paramSvcRespParam.toString());
        }
      }
      a();
      if (QLog.isColorLevel()) {
        QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByRegPrxy size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramSvcRespParam = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramSvcRespParam.hasNext()) {
          ((LoginDevicesManager.IDevListRefreshListener)paramSvcRespParam.next()).a(this.jdField_a_of_type_JavaUtilList);
        }
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        break;
      }
      return false;
    }
  }
  
  public boolean a(ArrayList<InstanceInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      InstanceInfo localInstanceInfo = (InstanceInfo)paramArrayList.next();
      int i = (int)localInstanceInfo.iClientType;
      if (LoginDevicesUtils.a(i))
      {
        LoginDevItem localLoginDevItem = new LoginDevItem(i);
        localLoginDevItem.jdField_a_of_type_Long = localInstanceInfo.iAppId;
        this.jdField_a_of_type_JavaUtilList.add(localLoginDevItem);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, localLoginDevItem.toString());
        }
      }
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByOnlinePush size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((LoginDevicesManager.IDevListRefreshListener)paramArrayList.next()).a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(LoginDevicesManager.IDevListRefreshListener paramIDevListRefreshListener)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramIDevListRefreshListener);
      }
      return;
    }
    finally
    {
      paramIDevListRefreshListener = finally;
      throw paramIDevListRefreshListener;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevicesManager
 * JD-Core Version:    0.7.0.1
 */