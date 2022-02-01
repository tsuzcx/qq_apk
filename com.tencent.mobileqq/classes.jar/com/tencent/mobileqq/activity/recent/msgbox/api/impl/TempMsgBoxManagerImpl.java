package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxUtil;
import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigData;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.activity.recent.msgbox.config.SessionKey;
import com.tencent.mobileqq.activity.recent.msgbox.config.SessionKeyUinTypeMap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class TempMsgBoxManagerImpl
  implements ITempMsgBoxManager, Manager
{
  public static final String FILTER_SESSION = "_filter_session";
  public static final String FILTER_SESSION_WHITELIST = "_filter_session_whitelist";
  public static final String KEY_MSG_BOX_READ = "key_msg_box_read";
  public static final String MSG_BOX_READ = "_msg_box_read";
  public static final String TAG = "TempMsgBoxManager";
  private AppInterface mApp;
  private final IFriendObserver mFriendListObserver = new TempMsgBoxManagerImpl.1(this);
  private volatile TempMsgBoxConfigData mTempMsgBoxConfigData;
  
  public TempMsgBoxManagerImpl() {}
  
  public TempMsgBoxManagerImpl(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  private void onAddToFilterList(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddToFilterList() called with: uin = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("TempMsgBoxManager", 2, localStringBuilder.toString());
    }
    if (isBelongToFilterBox(paramString, 0)) {
      addFilterBoxRecentUser();
    }
  }
  
  private void onRemoveFromFilterList()
  {
    FilterMsgBoxUtil.a(this.mApp, true);
  }
  
  public void addFilterBoxRecentUser()
  {
    Object localObject2 = FilterMsgBoxUtil.a(this.mApp);
    if (((List)localObject2).isEmpty()) {
      return;
    }
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.FILTER_MSG_UIN, 10012);
    QLog.i("TempMsgBoxManager", 1, "addFilterBoxRecentUser: ");
    localRecentUser.uin = AppConstants.FILTER_MSG_UIN;
    localRecentUser.setType(10012);
    Object localObject1 = (RecentUser)((List)localObject2).get(0);
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (RecentUser)localIterator.next();
      if (((RecentUser)localObject2).lastmsgtime > ((RecentUser)localObject1).lastmsgtime) {
        localObject1 = localObject2;
      }
    }
    localRecentUser.lastmsgtime = ((RecentUser)localObject1).lastmsgtime;
    localRecentUserProxy.b(localRecentUser);
  }
  
  public void addToFilterList(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addToFilterList() called with: uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_filter_session");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(paramString, true);
    ((SharedPreferences.Editor)localObject).apply();
    onAddToFilterList(paramString);
  }
  
  public void addToWhiteList(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addToWhiteList() called with: uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_filter_session_whitelist");
    ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString, true).apply();
  }
  
  public boolean configContains(int paramInt)
  {
    Object localObject = this.mTempMsgBoxConfigData;
    if (localObject == null) {
      return false;
    }
    if (!msgBoxSwitch()) {
      return false;
    }
    localObject = ((TempMsgBoxConfigData)localObject).b();
    if (localObject == null) {
      return false;
    }
    int i = 0;
    while (i < ((List)localObject).size())
    {
      if (SessionKeyUinTypeMap.a(paramInt, (SessionKey)((List)localObject).get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public List<RecentUser> getMsgBoxRecentUsers()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int i = 0;
    localObject = ((RecentUserProxy)localObject).a(true, false);
    while (i < ((List)localObject).size())
    {
      RecentUser localRecentUser = (RecentUser)((List)localObject).get(i);
      if (isBelongToMsgBox(localRecentUser.uin, localRecentUser.getType())) {
        localArrayList.add(localRecentUser);
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMsgBoxRecentUsers() called with: outList = [");
      ((StringBuilder)localObject).append(localArrayList);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public TempMsgBoxConfigData getTempMsgBoxConfigData()
  {
    return this.mTempMsgBoxConfigData;
  }
  
  public boolean hasFilter(String paramString)
  {
    Object localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_filter_session");
    boolean bool = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString, false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasFilter() called with: uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], result = [");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean isBelongToFilterBox(String paramString, int paramInt)
  {
    if (!msgBoxSwitch()) {
      return false;
    }
    Object localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_filter_session");
    boolean bool = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString, false);
    if ((bool) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("f [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean isBelongToMsgBox(String paramString, int paramInt)
  {
    if (!msgBoxSwitch()) {
      return false;
    }
    if (isBelongToFilterBox(paramString, paramInt))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isBelongToMsgBox() called isBelongToFilterBox: uin = [");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], type = [");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = (String)TempMsgBoxUtil.c().get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (ITempMsgBoxBusinessHandler)TempMsgBoxUtil.d().get(localObject);
      if ((localObject != null) && (((ITempMsgBoxBusinessHandler)localObject).a(this.mApp, paramInt))) {
        return false;
      }
    }
    boolean bool = configContains(paramInt);
    if ((bool) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("m [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      return ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getCallback().a(this.mApp, paramString, paramInt);
    }
    return false;
  }
  
  public boolean isMsgBoxRead()
  {
    Object localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_msg_box_read");
    boolean bool = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("key_msg_box_read", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isMsgBoxRead() boxRead = [");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("]");
    QLog.i("TempMsgBoxManager", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public boolean msgBoxSwitch()
  {
    TempMsgBoxConfigData localTempMsgBoxConfigData = this.mTempMsgBoxConfigData;
    if (localTempMsgBoxConfigData != null) {
      return localTempMsgBoxConfigData.a();
    }
    QLog.d("TempMsgBoxManager", 1, "msgBoxSwitch() called loadConObj");
    localTempMsgBoxConfigData = (TempMsgBoxConfigData)QConfigManager.b().b(704);
    if (localTempMsgBoxConfigData != null)
    {
      this.mTempMsgBoxConfigData = localTempMsgBoxConfigData;
      return localTempMsgBoxConfigData.a();
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.mApp.addObserver(this.mFriendListObserver);
    TempMsgBoxUtil.e();
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.mFriendListObserver);
  }
  
  public void removeFromFilterList(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeFromFilterList() called with: uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("TempMsgBoxManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_filter_session");
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(paramString, false);
    ((SharedPreferences.Editor)localObject).apply();
    onRemoveFromFilterList();
  }
  
  public void removeFromWhiteList(String paramString)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_filter_session_whitelist");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString, false).apply();
  }
  
  public void setMsgBoxRead(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMsgBoxRead() called with: read = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    QLog.i("TempMsgBoxManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getAccount());
    localStringBuilder.append("_msg_box_read");
    ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("key_msg_box_read", paramBoolean).apply();
  }
  
  public void setTempMsgBoxConfigData(TempMsgBoxConfigData paramTempMsgBoxConfigData)
  {
    this.mTempMsgBoxConfigData = paramTempMsgBoxConfigData;
    if (msgBoxSwitch())
    {
      addFilterBoxRecentUser();
      new RecentUserCacheHelper().a(this.mApp);
    }
    this.mApp.notifyObservers(TempMsgBoxObserver.class, 1, true, new Bundle());
  }
  
  public void updateIsTop(String paramString, int paramInt, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    paramString = localRecentUserProxy.b(paramString, paramInt);
    long l;
    if (paramBoolean) {
      l = System.currentTimeMillis() / 1000L;
    } else {
      l = 0L;
    }
    paramString.showUpTime = l;
    localRecentUserProxy.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.impl.TempMsgBoxManagerImpl
 * JD-Core Version:    0.7.0.1
 */