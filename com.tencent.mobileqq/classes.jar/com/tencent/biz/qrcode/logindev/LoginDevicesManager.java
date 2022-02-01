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
  private QQAppInterface a;
  private List<LoginDevItem> b;
  private ArrayList<LoginDevicesManager.IDevListRefreshListener> c = null;
  
  public LoginDevicesManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void c()
  {
    try
    {
      if ((this.b != null) && (this.b.size() > 1)) {
        Collections.sort(this.b, new LoginDevicesManager.1(this));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    try
    {
      if ((this.b == null) || (this.b.size() < 1)) {
        break label299;
      }
      localObject1 = new StringBuilder();
      localObject3 = (DeviceManageConfBean)QConfigManager.b().b(528);
      if ((this.a == null) || (localObject3 == null) || (((DeviceManageConfBean)localObject3).a != 1)) {
        break label315;
      }
      bool = SettingCloneUtil.readValue(this.a.getApplication(), this.a.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);
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
    if (this.b.size() == 1)
    {
      localObject3 = (LoginDevItem)this.b.get(0);
      ((StringBuilder)localObject1).append(((LoginDevItem)localObject3).e);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(((LoginDevItem)localObject3).f);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131891417));
      if (bool)
      {
        ((StringBuilder)localObject1).append("，");
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131892519));
      }
    }
    else
    {
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131896981));
      localObject3 = this.b.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((StringBuilder)localObject1).append(((LoginDevItem)((Iterator)localObject3).next()).e);
        ((StringBuilder)localObject1).append("、");
      }
      if (bool)
      {
        ((StringBuilder)localObject1).replace(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length(), "，");
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131892519));
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
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append(((LoginDevItem)localIterator.next()).e);
          localStringBuilder.append("、");
        }
        localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
      }
      paramContext = paramContext.getString(2131914124, new Object[] { localStringBuilder.toString() });
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
      if (this.c == null) {
        this.c = new ArrayList();
      }
      if (!this.c.contains(paramIDevListRefreshListener)) {
        this.c.add(paramIDevListRefreshListener);
      }
      if (paramIDevListRefreshListener != null) {
        paramIDevListRefreshListener.a(this.b);
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
          if (this.b == null) {
            this.b = new ArrayList();
          }
          this.b.clear();
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
            localLoginDevItem.a = localOnlineInfos.instanceId;
            this.b.add(localLoginDevItem);
            if (!QLog.isDevelopLevel()) {
              break label341;
            }
            QLog.d("LoginDevicesManager", 4, localLoginDevItem.toString());
            break label341;
          }
          if ((i == 0) && (paramSvcRespParam.PCstat != 0) && ((paramSvcRespParam.iPCClientType == 65793) || (paramSvcRespParam.iPCClientType == 77313)))
          {
            paramSvcRespParam = new LoginDevItem(paramSvcRespParam.iPCClientType);
            this.b.add(0, paramSvcRespParam);
            if (QLog.isDevelopLevel()) {
              QLog.d("LoginDevicesManager", 4, paramSvcRespParam.toString());
            }
          }
          c();
          if (QLog.isColorLevel()) {
            QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByRegPrxy size:", Integer.valueOf(this.b.size()) });
          }
          if (this.c != null)
          {
            paramSvcRespParam = this.c.iterator();
            if (paramSvcRespParam.hasNext())
            {
              ((LoginDevicesManager.IDevListRefreshListener)paramSvcRespParam.next()).a(this.b);
              continue;
            }
          }
          i = this.b.size();
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
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.clear();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InstanceInfo localInstanceInfo = (InstanceInfo)paramArrayList.next();
        i = (int)localInstanceInfo.iClientType;
        if (LoginDevicesUtils.a(i))
        {
          LoginDevItem localLoginDevItem = new LoginDevItem(i);
          localLoginDevItem.a = localInstanceInfo.iAppId;
          this.b.add(localLoginDevItem);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localLoginDevItem.toString());
          }
        }
      }
      c();
      if (QLog.isColorLevel()) {
        QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByOnlinePush size:", Integer.valueOf(this.b.size()) });
      }
      if (this.c != null)
      {
        paramArrayList = this.c.iterator();
        while (paramArrayList.hasNext()) {
          ((LoginDevicesManager.IDevListRefreshListener)paramArrayList.next()).a(this.b);
        }
      }
      int i = this.b.size();
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
  
  public int b()
  {
    try
    {
      if ((this.b != null) && (this.b.size() >= 1))
      {
        int i = this.b.size();
        if (i > 1) {
          return 4;
        }
        i = ((LoginDevItem)this.b.get(0)).c;
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  public void b(LoginDevicesManager.IDevListRefreshListener paramIDevListRefreshListener)
  {
    try
    {
      if (this.c != null) {
        this.c.remove(paramIDevListRefreshListener);
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
      if (this.b != null)
      {
        this.b.clear();
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.clear();
        this.c = null;
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