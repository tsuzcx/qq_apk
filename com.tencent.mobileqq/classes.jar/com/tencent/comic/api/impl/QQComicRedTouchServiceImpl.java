package com.tencent.comic.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.AppRuntime;

public class QQComicRedTouchServiceImpl
  extends Observable
  implements IQQComicRedTouchService
{
  public static final String TAG = "QQComicRedTouchService";
  AppRuntime mApp;
  BroadcastReceiver mReceiver;
  
  public String convertString(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = QQDcReporterImpl.obtainStringBuilder();
    int i;
    if (paramInt == 0)
    {
      i = 100000000;
      localStringBuilder.append(100600);
      localStringBuilder.append('.');
    }
    else
    {
      if (paramInt != 1) {
        break label264;
      }
      i = -100000000;
    }
    boolean bool = paramString.contains(".");
    int m = 0;
    int k;
    if (bool)
    {
      paramString = paramString.split("\\.");
      k = m;
      if (paramString.length <= 0) {
        break label187;
      }
      int n = paramString.length;
      k = 0;
      int j = 0;
      for (;;)
      {
        if (k < n)
        {
          String str = paramString[k];
          try
          {
            localStringBuilder.append(Integer.parseInt(str) + i);
            localStringBuilder.append('.');
            j += 1;
            k += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
      k = m;
      if (j != paramString.length) {
        break label187;
      }
    }
    try
    {
      localStringBuilder.append(Integer.parseInt(paramString) + i);
      k = 1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      k = m;
    }
    label187:
    if (k != 0)
    {
      if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == '.')) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      if (paramInt == 1)
      {
        paramInt = localStringBuilder.indexOf(".");
        if (paramInt < 0) {
          return null;
        }
        return localStringBuilder.substring(paramInt + 1);
      }
      return localStringBuilder.toString();
    }
    label264:
    return null;
  }
  
  public Map<String, Object> getRedAppInfo(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = null;
    if (paramArrayList == null) {
      return null;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putStringArrayList("pathList", paramArrayList);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "getRedTouchInfo", (Bundle)localObject);
    paramArrayList = localHashMap;
    if (localObject != null)
    {
      paramArrayList = localHashMap;
      if (((EIPCResult)localObject).code == 0)
      {
        paramArrayList = localHashMap;
        if (((EIPCResult)localObject).data != null)
        {
          paramArrayList = ((EIPCResult)localObject).data;
          paramArrayList.setClassLoader(RedAppInfo.class.getClassLoader());
          localObject = paramArrayList.getParcelableArrayList("redTouchInfoList");
          paramArrayList = localHashMap;
          if (localObject != null)
          {
            localHashMap = new HashMap();
            localObject = ((List)localObject).iterator();
            for (;;)
            {
              paramArrayList = localHashMap;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              paramArrayList = (RedAppInfo)((Iterator)localObject).next();
              localHashMap.put(paramArrayList.b(), paramArrayList);
            }
          }
        }
      }
    }
    return paramArrayList;
  }
  
  public boolean isLebaItemOpen(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("appId", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "isLebaItemOpen", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).code == 0) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getBoolean("isLebaItemOpen", false);
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mReceiver = new QQComicRedTouchServiceImpl.1(this);
    this.mApp.getApplicationContext().registerReceiver(this.mReceiver, new IntentFilter("com.tencent.redpoint.broadcast.push.av"));
  }
  
  public void onDestroy()
  {
    super.deleteObservers();
    try
    {
      this.mApp.getApplicationContext().unregisterReceiver(this.mReceiver);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.mApp = null;
  }
  
  public void reportRedTouchClick(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "reportRedTouchClick", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicRedTouchServiceImpl
 * JD-Core Version:    0.7.0.1
 */