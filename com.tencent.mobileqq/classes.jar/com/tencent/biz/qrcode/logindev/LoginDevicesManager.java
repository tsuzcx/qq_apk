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
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new LoginDevicesManager.1(this));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
      {
        int i = this.jdField_a_of_type_JavaUtilList.size();
        if (i > 1) {
          return 4;
        }
        i = ((LoginDevItem)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int;
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public String a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {
        break label299;
      }
      localObject1 = new StringBuilder();
      localObject3 = (DeviceManageConfBean)QConfigManager.a().a(528);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localObject3 == null) || (((DeviceManageConfBean)localObject3).a != 1)) {
        break label315;
      }
      bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        for (;;)
        {
          label299:
          throw localObject2;
        }
        label315:
        boolean bool = false;
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localObject3 = (LoginDevItem)this.jdField_a_of_type_JavaUtilList.get(0);
      ((StringBuilder)localObject1).append(((LoginDevItem)localObject3).jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(((LoginDevItem)localObject3).jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131693841));
      if (bool)
      {
        ((StringBuilder)localObject1).append("，");
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131694816));
      }
    }
    else
    {
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131698985));
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((StringBuilder)localObject1).append(((LoginDevItem)((Iterator)localObject3).next()).jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("、");
      }
      if (bool)
      {
        ((StringBuilder)localObject1).replace(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length(), "，");
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131694816));
      }
      else
      {
        ((StringBuilder)localObject1).replace(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length(), "。");
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
    return "";
  }
  
  public String a(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append(((LoginDevItem)localIterator.next()).jdField_a_of_type_JavaLangString);
          localStringBuilder.append("、");
        }
        localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
      }
      paramContext = paramContext.getString(2131716661, new Object[] { localStringBuilder.toString() });
      return paramContext;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
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
    boolean bool = false;
    if (paramSvcRespParam != null) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (paramSvcRespParam.onlineinfos != null)
        {
          if (this.jdField_a_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilList.clear();
          Iterator localIterator = paramSvcRespParam.onlineinfos.iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            OnlineInfos localOnlineInfos = (OnlineInfos)localIterator.next();
            if (localOnlineInfos.onlineStatus == 0) {
              continue;
            }
            j = (int)localOnlineInfos.uClientType;
            if (!LoginDevicesUtils.a(j)) {
              break label341;
            }
            LoginDevItem localLoginDevItem = new LoginDevItem(j);
            localLoginDevItem.jdField_a_of_type_Long = localOnlineInfos.instanceId;
            this.jdField_a_of_type_JavaUtilList.add(localLoginDevItem);
            if (!QLog.isDevelopLevel()) {
              break label341;
            }
            QLog.d("LoginDevicesManager", 4, localLoginDevItem.toString());
            break label341;
          }
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
            if (paramSvcRespParam.hasNext())
            {
              ((LoginDevicesManager.IDevListRefreshListener)paramSvcRespParam.next()).a(this.jdField_a_of_type_JavaUtilList);
              continue;
            }
          }
          i = this.jdField_a_of_type_JavaUtilList.size();
          if (i > 0) {
            bool = true;
          }
          return bool;
        }
      }
      finally {}
      return false;
      label341:
      if ((j == 66818) || (j == 66831) || (j == 81154)) {
        i = 1;
      }
    }
  }
  
  public boolean a(ArrayList<InstanceInfo> paramArrayList)
  {
    boolean bool = false;
    if (paramArrayList == null) {
      return false;
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InstanceInfo localInstanceInfo = (InstanceInfo)paramArrayList.next();
        i = (int)localInstanceInfo.iClientType;
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
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw paramArrayList;
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
    try
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
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevicesManager
 * JD-Core Version:    0.7.0.1
 */