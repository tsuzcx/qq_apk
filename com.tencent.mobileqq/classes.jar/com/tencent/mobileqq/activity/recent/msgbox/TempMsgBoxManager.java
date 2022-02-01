package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.msgbox.config.SessionKey;
import com.tencent.mobileqq.activity.recent.msgbox.config.SessionKeyUinTypeMap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class TempMsgBoxManager
  implements Manager
{
  private volatile TempMsgBoxConfigData jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxConfigData;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TempMsgBoxManager.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public TempMsgBoxManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface).isEmpty())
    {
      RecentUser localRecentUser = paramQQAppInterface.getRecentUserProxy().a(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      paramQQAppInterface.getRecentUserProxy().a(localRecentUser, paramBoolean);
    }
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxConfigData;
    if (localObject == null) {}
    for (;;)
    {
      return false;
      localObject = ((TempMsgBoxConfigData)localObject).a();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          if (SessionKeyUinTypeMap.a(paramInt, (SessionKey)((List)localObject).get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "onAddToFilterList() called with: uin = [" + paramString + "], app = [" + paramQQAppInterface + "]");
    }
    if (a(paramString, 0)) {
      a(paramQQAppInterface);
    }
  }
  
  private void d(String paramString)
  {
    FilterMsgBoxRecentUserUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
  
  public List<RecentUser> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a().a(true, false);
    int i = 0;
    while (i < paramQQAppInterface.size())
    {
      RecentUser localRecentUser = (RecentUser)paramQQAppInterface.get(i);
      if (b(localRecentUser.uin, localRecentUser.getType())) {
        localArrayList.add(localRecentUser);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "getMsgBoxRecentUsers() called with: outList = [" + localArrayList + "]");
    }
    return localArrayList;
  }
  
  public void a(TempMsgBoxConfigData paramTempMsgBoxConfigData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxConfigData = paramTempMsgBoxConfigData;
    if (b())
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      new RecentUserCacheHelper().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(TempMsgBoxObserver.class, 1, true, new Bundle());
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = FilterMsgBoxRecentUserUtil.a(paramQQAppInterface);
    if (((List)localObject).isEmpty()) {
      return;
    }
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.FILTER_MSG_UIN, 10012);
    QLog.i("TempMsgBoxManager", 1, "addFilterBoxRecentUser: ");
    localRecentUser.uin = AppConstants.FILTER_MSG_UIN;
    localRecentUser.setType(10012);
    paramQQAppInterface = (RecentUser)((List)localObject).get(0);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = (RecentUser)localIterator.next();
      if (((RecentUser)localObject).lastmsgtime <= paramQQAppInterface.lastmsgtime) {
        break label136;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    label136:
    for (;;)
    {
      break;
      localRecentUser.lastmsgtime = paramQQAppInterface.lastmsgtime;
      localRecentUserProxy.b(localRecentUser);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getRecentUserProxy();
    paramString = paramQQAppInterface.a(paramString, paramInt);
    if (paramBoolean) {}
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      paramString.showUpTime = l;
      paramQQAppInterface.b(paramString);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "addToWhiteList() called with: uin = [" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_filter_session_whitelist", 0).edit().putBoolean(paramString, true).apply();
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "addToFilterList() called with: uin = [" + paramString + "]");
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount() + "_filter_session", 0).edit();
    localEditor.putBoolean(paramString, true);
    localEditor.apply();
    b(paramString, paramQQAppInterface);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("TempMsgBoxManager", 1, "setMsgBoxRead() called with: read = [" + paramBoolean + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_msg_box_read", 0).edit().putBoolean("key_msg_box_read", paramBoolean).apply();
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_msg_box_read", 0).getBoolean("key_msg_box_read", false);
    QLog.i("TempMsgBoxManager", 1, "isMsgBoxRead() boxRead = [" + bool + "]");
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool1 = false;
    if (!b()) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_filter_session", 0).getBoolean(paramString, false);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TempMsgBoxManager", 2, "f [" + paramString + "," + paramInt + "]");
    return bool2;
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount() + "_filter_session", 0).getBoolean(paramString, false);
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "hasFilter() called with: uin = [" + paramString + "], result = [" + bool + "]");
    }
    return bool;
  }
  
  public List<RecentUser> b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "initTempMsgBoxList() result " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_filter_session_whitelist", 0).edit().putBoolean(paramString, false).apply();
  }
  
  public boolean b()
  {
    TempMsgBoxConfigData localTempMsgBoxConfigData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxConfigData;
    if (localTempMsgBoxConfigData != null) {
      return localTempMsgBoxConfigData.a();
    }
    QLog.d("TempMsgBoxManager", 1, "msgBoxSwitch() called loadConObj");
    localTempMsgBoxConfigData = (TempMsgBoxConfigData)QConfigManager.a().a(704);
    if (localTempMsgBoxConfigData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxConfigData = localTempMsgBoxConfigData;
      return localTempMsgBoxConfigData.a();
    }
    return false;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool1 = false;
    if (!b()) {}
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if (!a(paramString, paramInt)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TempMsgBoxManager", 2, "isBelongToMsgBox() called isBelongToFilterBox: uin = [" + paramString + "], type = [" + paramInt + "]");
          return false;
          if (paramInt == 10012) {
            return true;
          }
        } while (GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt));
        bool2 = a(paramInt);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TempMsgBoxManager", 2, "m [" + paramString + "," + paramInt + "]");
    return bool2;
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxManager", 2, "removeFromFilterList() called with: uin = [" + paramString + "]");
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_filter_session", 0).edit();
    localEditor.putBoolean(paramString, false);
    localEditor.apply();
    d(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager
 * JD-Core Version:    0.7.0.1
 */