package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManager;
import com.tencent.mobileqq.apollo.handler.ApolloRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ApolloActionUsedManagerImpl
  implements IApolloActionUsedManager
{
  public static final String TAG = "[cmshow]ApolloActionUsedManager";
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("data from actionIdMap is null, pkgId =");
        ((StringBuilder)localObject).append(paramInt);
        QLog.e("[cmshow]ApolloActionUsedManager", 2, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    else
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_apollo_panel_action_used_map");
      localStringBuilder.append(this.mApp.getCurrentAccountUin());
      localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
      if (localObject != null)
      {
        if (((ConcurrentHashMap)new Gson().fromJson((String)localObject, new ApolloActionUsedManagerImpl.1(this).getType())).containsKey(Integer.valueOf(paramInt)))
        {
          localObject = (List)this.actionIdMap.get(Integer.valueOf(paramInt));
          if (localObject != null) {
            return localObject;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("data from sp is null, pkgId =");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("[cmshow]ApolloActionUsedManager", 2, ((StringBuilder)localObject).toString());
            return null;
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloActionUsedManager", 2, "sp is null");
      }
    }
    return null;
  }
  
  public void getActionIdDataFromServer(int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.mApp.getApp()))
    {
      QLog.e("[cmshow]ApolloActionUsedManager", 2, "NetworkAvailable is false!");
      return;
    }
    ApolloRequest.a(this.mApp, paramInt);
  }
  
  public boolean isDataExpired()
  {
    Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("aio_used_action_sp", 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sp_key_apollo_panel_action_used_last_request_time");
    ((StringBuilder)localObject1).append(this.mApp.getCurrentAccountUin());
    localObject1 = Long.valueOf(((SharedPreferences)localObject2).getLong(((StringBuilder)localObject1).toString(), 0L));
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sp_key_apollo_panel_action_used_request_interval");
    ((StringBuilder)localObject3).append(this.mApp.getCurrentUin());
    localObject2 = Long.valueOf(((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), 0L));
    localObject3 = Long.valueOf(System.currentTimeMillis());
    boolean bool;
    if (((Long)localObject3).longValue() > ((Long)localObject1).longValue() + ((Long)localObject2).longValue()) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isApolloPanelCacheExpired] ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", currentTime: ");
    localStringBuilder.append(localObject3);
    localStringBuilder.append(", battleGameLastRequestTime: ");
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", battleGameRequestInterval: ");
    localStringBuilder.append(localObject2);
    QLog.d("[cmshow]ApolloActionUsedManager", 1, new Object[] { localStringBuilder });
    return bool;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface))
    {
      QLog.e("[cmshow]ApolloActionUsedManager", 1, "[onCreate] error, not run in QQAppInterface!");
      return;
    }
    this.mApp = ((QQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void saveActionIdData(int paramInt1, int paramInt2)
  {
    Object localObject3 = (List)this.actionIdMap.get(Integer.valueOf(paramInt1));
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = new ArrayList();
      if (((List)localObject1).contains(Integer.valueOf(paramInt2))) {
        ((List)localObject1).remove(((List)localObject1).indexOf(Integer.valueOf(paramInt2)));
      }
      if (((List)localObject1).size() >= 48) {
        ((List)localObject1).remove(((List)localObject1).size() - 1);
      }
      ((List)localObject1).add(0, Integer.valueOf(paramInt2));
      this.actionIdMap.put(Integer.valueOf(paramInt1), localObject1);
      localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
      localObject1 = new Gson().toJson(this.actionIdMap);
      localObject3 = ((SharedPreferences)localObject3).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_apollo_panel_action_used_map");
      localStringBuilder.append(this.mApp.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject3).putString(localStringBuilder.toString(), (String)localObject1).commit();
      return;
    }
    finally {}
  }
  
  public void saveApolloActionUsedRequestInterval(AppRuntime paramAppRuntime, long paramLong)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("[cmshow]ApolloActionUsedManager", 1, "[saveApolloActionUsedRequestInterval] app is null!");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[saveApolloActionUsedRequestInterval] ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("[cmshow]ApolloActionUsedManager", 2, ((StringBuilder)localObject).toString());
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("aio_used_action_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_panel_action_used_request_interval");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public void updateActionIdData(int paramInt, List<Integer> paramList)
  {
    this.actionIdMap.put(Integer.valueOf(paramInt), paramList);
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("aio_used_action_sp", 0);
    paramList = new Gson().toJson(this.actionIdMap);
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_apollo_panel_action_used_map");
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramList).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloActionUsedManagerImpl
 * JD-Core Version:    0.7.0.1
 */