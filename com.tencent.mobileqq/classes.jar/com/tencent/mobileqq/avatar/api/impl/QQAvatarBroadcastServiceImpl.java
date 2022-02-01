package com.tencent.mobileqq.avatar.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import mqq.app.AppRuntime;

public class QQAvatarBroadcastServiceImpl
  implements IQQAvatarBroadcastService
{
  private static final String QQ_HEAD_BROADCAST = "Q.qqhead.broadcast";
  private Hashtable<String, Long> headQQHeadBroadcastTable = new Hashtable();
  protected AppRuntime mApp;
  private final int msgSendDisQQheadBroadcast = 993;
  private final int msgSendNewgroupQQheadBroadcast = 992;
  private final int msgSendQQheadBroadcast = 990;
  private final int msgSendTroopQQheadBroadcast = 991;
  private Handler qqHeadBroadcastHandler = new QQAvatarBroadcastServiceImpl.1(this, ThreadManager.getSubThreadLooper());
  private ArrayList<String> sendDisUinList = new ArrayList();
  private ArrayList<String> sendNewTroopUinList = new ArrayList();
  private ArrayList<String> sendTroopUinList = new ArrayList();
  private ArrayList<String> sendUinList = new ArrayList();
  
  public static void logD(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
    }
    QLog.d(paramString1, paramInt, paramString2 + localStringBuilder.toString());
  }
  
  private void sendHeadPathBroadcast(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    try
    {
      Intent localIntent = new Intent("com.tencent.qqhead.getheadresp");
      localIntent.setPackage(BaseApplication.getContext().getPackageName());
      localIntent.putExtra("faceType", paramInt);
      localIntent.putStringArrayListExtra("uinList", paramArrayList1);
      localIntent.putStringArrayListExtra("headPathList", paramArrayList2);
      this.mApp.getApp().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      return;
    }
    catch (Exception paramArrayList1)
    {
      QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", paramArrayList1);
    }
  }
  
  public void headQQHeadBroadcast(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    long l1;
    ArrayList localArrayList;
    label185:
    label225:
    label230:
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      int k = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramIntent = new ArrayList();
      ??? = new ArrayList();
      localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      Object localObject3 = (IQQAvatarDataService)this.mApp.getRuntimeService(IQQAvatarDataService.class, "");
      int i;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i = 0;
        if (i < ((ArrayList)localObject2).size())
        {
          String str = (String)((ArrayList)localObject2).get(i);
          int j;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject4 = new File(((IQQAvatarDataService)localObject3).getCustomFaceFilePath(k, str, 0));
            if ((!((File)localObject4).exists()) || (!((File)localObject4).isFile())) {
              break label225;
            }
            j = 1;
            if (j == 0) {
              break label230;
            }
            localObject4 = ((IQQAvatarDataService)localObject3).getCustomFaceFilePath(k, str, 0);
            paramIntent.add(str);
            ((ArrayList)???).add(localObject4);
          }
          for (;;)
          {
            i += 1;
            break;
            j = 0;
            break label185;
            localArrayList.add(str);
          }
        }
      }
      try
      {
        if (paramIntent.size() > 0)
        {
          localObject2 = new Intent("com.tencent.qqhead.getheadresp");
          ((Intent)localObject2).putExtra("faceType", k);
          ((Intent)localObject2).putStringArrayListExtra("uinList", paramIntent);
          ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
          this.mApp.getApp().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
        }
        if (localArrayList.size() > 0)
        {
          l2 = System.currentTimeMillis();
          localObject2 = (IQQAvatarHandlerService)this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
          i = 0;
          if (i < localArrayList.size())
          {
            localObject3 = (String)localArrayList.get(i);
            if (k == 1) {
              ((IQQAvatarHandlerService)localObject2).getCustomHead((String)localObject3, (byte)0, (byte)2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        synchronized (this.headQQHeadBroadcastTable)
        {
          do
          {
            for (;;)
            {
              this.headQQHeadBroadcastTable.put(localObject3, Long.valueOf(l2));
              i += 1;
              continue;
              localException = localException;
              QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException);
              continue;
              if (k == 4)
              {
                ((IQQAvatarHandlerService)localObject2).getTroopHead((String)localObject3);
              }
              else
              {
                if (k != 113) {
                  break;
                }
                ((ITroopHandlerService)this.mApp.getRuntimeService(ITroopHandlerService.class, "")).updateGroupIcon((String)localObject3, true);
              }
            }
          } while (k != 101);
          ((IDiscussionHandlerService)this.mApp.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon((String)localObject3, true);
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramIntent);
    logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", localArrayList);
    QLog.i("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, cost=" + (l2 - l1));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.qqHeadBroadcastHandler.removeCallbacksAndMessages(null);
  }
  
  public void sendQQHeadBroadcast(int paramInt1, String arg2, int paramInt2, String arg4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendQQHeadBroadcast.type=" + paramInt1 + ",uin=" + ??? + ",idType=" + paramInt2 + ",path=" + ???);
    }
    if (!this.headQQHeadBroadcastTable.containsKey(???)) {
      return;
    }
    synchronized (this.headQQHeadBroadcastTable)
    {
      this.headQQHeadBroadcastTable.remove(???);
      if (paramInt1 != 1) {}
    }
    Object localObject;
    for (;;)
    {
      synchronized (this.sendUinList)
      {
        this.sendUinList.add(???);
        ??? = this.qqHeadBroadcastHandler.obtainMessage();
        ???.what = 990;
        this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        if (this.headQQHeadBroadcastTable.size() <= 50) {
          break;
        }
        synchronized (this.headQQHeadBroadcastTable)
        {
          long l = System.currentTimeMillis();
          ??? = new ArrayList();
          localObject = this.headQQHeadBroadcastTable.keys();
          if (!((Enumeration)localObject).hasMoreElements()) {
            break label459;
          }
          String str = (String)((Enumeration)localObject).nextElement();
          if (Math.abs(l - ((Long)this.headQQHeadBroadcastTable.get(str)).longValue()) <= 180000L) {
            continue;
          }
          ???.add(str);
        }
        ??? = finally;
        throw ???;
      }
      if (paramInt1 == 4) {
        synchronized (this.sendTroopUinList)
        {
          this.sendTroopUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 991;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
      }
      if (paramInt1 == 101) {
        synchronized (this.sendDisUinList)
        {
          this.sendDisUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 993;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
      }
      if (paramInt1 == 113) {
        synchronized (this.sendNewTroopUinList)
        {
          this.sendNewTroopUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 992;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
      }
    }
    label459:
    paramInt1 = 0;
    while (paramInt1 < ???.size())
    {
      localObject = (String)???.get(paramInt1);
      this.headQQHeadBroadcastTable.remove(localObject);
      paramInt1 += 1;
    }
  }
  
  public void sendSelfQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendSelfQQHeadBroadcast.type=" + paramInt1 + ",uin=" + paramString1 + ",idType=" + paramInt2 + ",path=" + paramString2);
    }
    if (paramInt1 == 1) {}
    try
    {
      Intent localIntent = new Intent("com.tencent.qqhead.selfupdate");
      localIntent.putExtra("faceType", 1);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("headPath", paramString2);
      this.mApp.getApp().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("Q.qqhead.broadcast", 2, "sendSelfQQHeadBroadcast error", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarBroadcastServiceImpl
 * JD-Core Version:    0.7.0.1
 */