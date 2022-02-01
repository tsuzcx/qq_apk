package com.tencent.common.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import anui;
import aobf;
import aran;
import arix;
import azpm;
import bern;
import beuo;
import bhuw;
import bhvb;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class AppInterface
  extends IMCoreAppRuntime
  implements bhvb
{
  public BaseApplicationImpl app;
  protected bhuw comunicator;
  private MqqHandler defaultHanlder = new MqqHandler(Looper.getMainLooper());
  protected final ConcurrentHashMap<Class, MqqHandler> handlerMap = new ConcurrentHashMap();
  public HwEngine mHwEngine;
  private ProtoReqManager mProtoManager;
  private TroopFileProtoReqMgr mTroopFileProtoReqMgr;
  protected String procName = "";
  
  public AppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    this.app = paramBaseApplicationImpl;
    this.procName = paramString;
  }
  
  private static void doFileIncrease(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIFileFlow");
      return;
    }
    paramArrayList.add("param_XGFileFlow");
  }
  
  private static void doPicIncrease(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIPicFlow");
      if (paramBoolean) {
        if (paramInt2 == 0) {
          paramArrayList.add("param_WIFIC2CPicUploadFlow");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramInt2 == 1) || (paramInt2 == 3000))
            {
              paramArrayList.add("param_WIFIGroupPicUploadFlow");
              return;
            }
          } while ((paramInt2 != 1001) && (paramInt2 != 1003) && (paramInt2 != 1025) && (paramInt2 != 10002));
          paramArrayList.add("param_WIFINearbyPicUploadFlow");
          return;
          if (paramInt2 == 0)
          {
            paramArrayList.add("param_WIFIC2CPicDownloadFlow");
            return;
          }
          if ((paramInt2 == 1) || (paramInt2 == 3000))
          {
            paramArrayList.add("param_WIFIGroupPicDownloadFlow");
            return;
          }
        } while ((paramInt2 != 1001) && (paramInt2 != 10002) && (paramInt2 != 1003) && (paramInt2 != 1025));
        paramArrayList.add("param_WIFINearbyPicDownloadFlow");
        return;
        paramArrayList.add("param_XGPicFlow");
        if (!paramBoolean) {
          break;
        }
        if (paramInt2 == 0)
        {
          paramArrayList.add("param_XGC2CPicUploadFlow");
          return;
        }
        if ((paramInt2 == 1) || (paramInt2 == 3000))
        {
          paramArrayList.add("param_XGGroupPicUploadFlow");
          return;
        }
      } while ((paramInt2 != 10002) && (paramInt2 != 1001) && (paramInt2 != 1003));
      paramArrayList.add("param_XGNearbyPicUploadFlow");
      return;
      if (paramInt2 == 0)
      {
        paramArrayList.add("param_XGC2CPicDownloadFlow");
        return;
      }
      if ((paramInt2 == 1) || (paramInt2 == 3000))
      {
        paramArrayList.add("param_XGGroupPicDownloadFlow");
        return;
      }
    } while ((paramInt2 != 10002) && (paramInt2 != 1001) && (paramInt2 != 1003));
    paramArrayList.add("param_XGNearbyPicDownloadFlow");
  }
  
  private static void doPttIncrease(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIVoiceFlow");
      return;
    }
    paramArrayList.add("param_XGVoiceFlow");
  }
  
  private static String[] getAppDataIncermentTags(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowStat", 2, "uin:" + paramString + ",isUp:" + paramBoolean + ",netType:" + paramInt1 + ",fileType:" + paramInt2 + ",busiType:" + paramInt3 + ",flow:" + paramLong);
    }
    paramString = new ArrayList();
    paramString.add("param_Flow");
    if (paramInt1 == 1)
    {
      paramString.add("param_WIFIFlow");
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      return (String[])paramString.toArray(new String[0]);
      paramString.add("param_XGFlow");
      break;
      doPicIncrease(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      doPttIncrease(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      doFileIncrease(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      if (paramInt1 == 1)
      {
        paramString.add("param_WIFIUniformDLDownloadFlow");
      }
      else
      {
        paramString.add("param_XGUniformDLDownloadFlow");
        continue;
        if (paramInt1 == 1)
        {
          paramString.add("param_WIFIThemeDownloadFlow");
        }
        else
        {
          paramString.add("param_XGThemeDownloadFlow");
          continue;
          if (paramInt1 == 1)
          {
            paramString.add("param_WIFIAvatarPicDownloadFlow");
          }
          else
          {
            paramString.add("param_XGAvatarPicDownloadFlow");
            continue;
            if (paramInt1 == 1) {
              paramString.add("param_WIFICircleDownloadFlow");
            } else {
              paramString.add("param_XGCircleDownloadFlow");
            }
          }
        }
      }
    }
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.equals(paramContext)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public static void sendAppDataIncerment(PluginRuntime paramPluginRuntime, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    paramPluginRuntime.sendAppDataIncerment(paramString, getAppDataIncermentTags(paramString, paramBoolean, paramInt1, paramInt2, paramInt3, paramLong), paramLong);
  }
  
  public void addObserver(anui paramanui) {}
  
  public void addObserver(anui paramanui, boolean paramBoolean) {}
  
  public void countFlow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    sendAppDataIncerment(getAccount(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public abstract BaseApplication getApp();
  
  public abstract int getAppid();
  
  public Object getBusinessHandler(int paramInt)
  {
    return null;
  }
  
  public List<anui> getBusinessObserver(int paramInt)
  {
    return null;
  }
  
  public abstract String getCurrentAccountUin();
  
  public String getCurrentNickname()
  {
    return "";
  }
  
  public String getDisplayName(int paramInt, String paramString1, String paramString2)
  {
    return null;
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return getEntityManagerFactory(getAccount());
  }
  
  public abstract EntityManagerFactory getEntityManagerFactory(String paramString);
  
  public MqqHandler getHandler(Class paramClass)
  {
    if (this.handlerMap.get(paramClass) != null) {
      return (MqqHandler)this.handlerMap.get(paramClass);
    }
    return this.defaultHanlder;
  }
  
  public bhuw getHttpCommunicatort()
  {
    if (this.comunicator == null) {}
    try
    {
      if (this.comunicator == null) {
        httpCommunicatorCreate();
      }
      return this.comunicator;
    }
    finally {}
  }
  
  public HwEngine getHwEngine()
  {
    MobileQQ localMobileQQ;
    String str;
    int i;
    int j;
    if (this.mHwEngine == null)
    {
      arix localarix = (arix)aran.a().a(538);
      localMobileQQ = getApplication();
      str = getCurrentAccountUin();
      i = getAppid();
      j = aobf.a();
      if ((localarix == null) || (!localarix.a)) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      this.mHwEngine = new HwEngine(localMobileQQ, str, i, this, j, bool);
      return this.mHwEngine;
    }
  }
  
  public beuo getNetEngine(int paramInt)
  {
    return null;
  }
  
  public ProtoReqManager getProtoReqManager()
  {
    if (this.mProtoManager == null) {}
    try
    {
      if (this.mProtoManager == null) {
        this.mProtoManager = new ProtoReqManager(this);
      }
      return this.mProtoManager;
    }
    finally {}
  }
  
  public bern getTransFileController()
  {
    return null;
  }
  
  public TroopFileProtoReqMgr getTroopFileProtoReqMgr()
  {
    if (this.mTroopFileProtoReqMgr == null) {}
    try
    {
      if (this.mTroopFileProtoReqMgr == null) {
        this.mTroopFileProtoReqMgr = new TroopFileProtoReqMgr(this);
      }
      return this.mTroopFileProtoReqMgr;
    }
    finally {}
  }
  
  protected void httpCommunicatorCreate()
  {
    this.comunicator = new bhuw(this, 128);
    this.comunicator.a();
  }
  
  public boolean isAppOnForeground(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.processName.equals(paramString)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.handlerMap.clear();
    this.defaultHanlder.removeCallbacksAndMessages(null);
  }
  
  public void removeHandler(Class paramClass)
  {
    this.handlerMap.remove(paramClass);
  }
  
  public void removeObserver(anui paramanui) {}
  
  public void reportClickEvent(String paramString1, String paramString2)
  {
    reportClickEvent(paramString1, "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9) {}
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9) {}
  
  public void sendAppDataIncerment(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("FlowStat", 2, "uin:" + paramString + ",isUp:" + paramBoolean + ",netType:" + paramInt1 + ",fileType:" + paramInt2 + ",busiType:" + paramInt3 + ",flow:" + paramLong);
    }
    if ((!paramBoolean) && ((paramInt2 == 1) || (paramInt2 == 65538) || (paramInt2 == 65537) || (paramInt2 == 131075)) && ((paramInt3 == 1) || (paramInt3 == 3000) || (paramInt3 == 0)))
    {
      if (paramInt1 == 1) {
        break label156;
      }
      paramBoolean = true;
      if (paramInt3 != 0) {
        break label161;
      }
    }
    for (;;)
    {
      azpm.a(paramLong, paramBoolean, bool);
      return;
      label156:
      paramBoolean = false;
      break;
      label161:
      bool = false;
    }
  }
  
  public void sendAppDataIncerment(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (paramArrayOfString != null) {}
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg) {}
  
  public void setHandler(Class paramClass, MqqHandler paramMqqHandler)
  {
    if (paramMqqHandler == null)
    {
      this.handlerMap.remove(paramClass);
      return;
    }
    this.handlerMap.put(paramClass, paramMqqHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.AppInterface
 * JD-Core Version:    0.7.0.1
 */