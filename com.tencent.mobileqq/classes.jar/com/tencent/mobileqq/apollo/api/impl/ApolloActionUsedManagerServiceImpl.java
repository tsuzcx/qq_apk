package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManagerService;
import com.tencent.mobileqq.apollo.api.handler.ApolloGetActionUsedListVasHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ApolloActionUsedManagerServiceImpl
  implements IApolloActionUsedManagerService
{
  public static final String TAG = "ApolloActionUsedManager";
  public ConcurrentHashMap<Integer, List<Integer>> actionIdMap = new ConcurrentHashMap();
  public QQAppInterface mApp;
  
  public List<Integer> getActionIdData(int paramInt)
  {
    Object localObject;
    if (this.actionIdMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (List)this.actionIdMap.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ApolloActionUsedManager", 2, "data from actionIdMap is null, pkgId =" + paramInt);
      }
    }
    for (;;)
    {
      return null;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0).getString("sp_key_apollo_panel_action_used_map" + this.mApp.getCurrentAccountUin(), null);
      if (localObject != null)
      {
        if (!((ConcurrentHashMap)new Gson().fromJson((String)localObject, new ApolloActionUsedManagerServiceImpl.1(this).getType())).containsKey(Integer.valueOf(paramInt))) {
          continue;
        }
        List localList = (List)this.actionIdMap.get(Integer.valueOf(paramInt));
        localObject = localList;
        if (localList != null) {
          break;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloActionUsedManager", 2, "data from sp is null, pkgId =" + paramInt);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ApolloActionUsedManager", 2, "sp is null");
      }
    }
  }
  
  public void getActionIdDataFromServer(int paramInt)
  {
    if (NetworkUtil.g(this.mApp.getApp())) {
      ApolloGetActionUsedListVasHandler.a(this.mApp, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloActionUsedManager", 2, "NetworkAvailable is false!");
  }
  
  public boolean isDataExpired()
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("aio_used_action_sp", 0);
    Long localLong1 = Long.valueOf(((SharedPreferences)localObject).getLong("sp_key_apollo_panel_action_used_last_request_time" + this.mApp.getCurrentAccountUin(), 0L));
    localObject = Long.valueOf(((SharedPreferences)localObject).getLong("sp_key_apollo_panel_action_used_request_interval" + this.mApp.getCurrentUin(), 0L));
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    if (localLong2.longValue() > localLong1.longValue() + ((Long)localObject).longValue()) {}
    for (boolean bool = true;; bool = false)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isApolloPanelCacheExpired] ").append(bool).append(", currentTime: ").append(localLong2).append(", battleGameLastRequestTime: ").append(localLong1).append(", battleGameRequestInterval: ").append(localObject);
      QLog.d("ApolloActionUsedManager", 1, new Object[] { localStringBuilder });
      return bool;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)paramAppRuntime);
      return;
    }
    QLog.e("ApolloActionUsedManager", 1, "[onCreate] error, not run in QQAppInterface!");
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void saveActionIdData(int paramInt1, int paramInt2)
  {
    Object localObject1 = (List)this.actionIdMap.get(Integer.valueOf(paramInt1));
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(Integer.valueOf(paramInt2));
        this.actionIdMap.put(Integer.valueOf(paramInt1), localObject1);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
        String str = new Gson().toJson(this.actionIdMap);
        ((SharedPreferences)localObject1).edit().putString("sp_key_apollo_panel_action_used_map" + this.mApp.getCurrentAccountUin(), str).commit();
        return;
      }
      finally {}
      if (((List)localObject1).contains(Integer.valueOf(paramInt2))) {
        ((List)localObject1).remove(((List)localObject1).indexOf(Integer.valueOf(paramInt2)));
      }
      if (((List)localObject1).size() < 48)
      {
        ((List)localObject1).add(0, Integer.valueOf(paramInt2));
      }
      else
      {
        localObject2.remove(localObject2.size() - 1);
        localObject2.add(0, Integer.valueOf(paramInt2));
      }
    }
  }
  
  public void saveApolloActionUsedRequestInterval(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloActionUsedManager", 1, "[saveApolloActionUsedRequestInterval] app is null!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionUsedManager", 1, "[saveApolloActionUsedRequestInterval] " + paramLong);
    }
    BaseApplicationImpl.getContext().getSharedPreferences("aio_used_action_sp", 0).edit().putLong("sp_key_apollo_panel_action_used_request_interval" + paramQQAppInterface.getCurrentUin(), paramLong).commit();
  }
  
  public void updateActionIdData(int paramInt, List<Integer> paramList)
  {
    this.actionIdMap.put(Integer.valueOf(paramInt), paramList);
    paramList = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
    String str = new Gson().toJson(this.actionIdMap);
    paramList.edit().putString("sp_key_apollo_panel_action_used_map" + this.mApp.getCurrentAccountUin(), str).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloActionUsedManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */