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
        localStringBuilder.append(paramArrayList.get(i));
        localStringBuilder.append(", ");
        i += 1;
      }
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append(paramString2);
    paramArrayList.append(localStringBuilder.toString());
    QLog.d(paramString1, paramInt, paramArrayList.toString());
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
    if (paramIntent != null)
    {
      if (paramIntent.getExtras() == null) {
        return;
      }
      long l1 = System.currentTimeMillis();
      int k = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject1 = paramIntent.getExtras().getStringArrayList("uinList");
      paramIntent = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      if (QLog.isColorLevel()) {
        logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject1);
      }
      Object localObject2 = (IQQAvatarDataService)this.mApp.getRuntimeService(IQQAvatarDataService.class, "");
      int i;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          String str = (String)((ArrayList)localObject1).get(i);
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(((IQQAvatarDataService)localObject2).getCustomFaceFilePath(k, str, 0));
            int j;
            if ((((File)localObject3).exists()) && (((File)localObject3).isFile())) {
              j = 1;
            } else {
              j = 0;
            }
            if (j != 0)
            {
              localObject3 = ((IQQAvatarDataService)localObject2).getCustomFaceFilePath(k, str, 0);
              paramIntent.add(str);
              localArrayList2.add(localObject3);
            }
            else
            {
              localArrayList1.add(str);
            }
          }
          i += 1;
        }
      }
      try
      {
        if (paramIntent.size() > 0)
        {
          localObject1 = new Intent("com.tencent.qqhead.getheadresp");
          ((Intent)localObject1).putExtra("faceType", k);
          ((Intent)localObject1).putStringArrayListExtra("uinList", paramIntent);
          ((Intent)localObject1).putStringArrayListExtra("headPathList", localArrayList2);
          this.mApp.getApp().sendBroadcast((Intent)localObject1, "com.tencent.qqhead.permission.getheadresp");
        }
      }
      catch (Exception localException)
      {
        QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException);
      }
      if (localArrayList1.size() > 0)
      {
        l2 = System.currentTimeMillis();
        localObject1 = (IQQAvatarHandlerService)this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
        i = 0;
        while (i < localArrayList1.size())
        {
          localObject2 = (String)localArrayList1.get(i);
          if (k == 1) {
            ((IQQAvatarHandlerService)localObject1).getCustomHead((String)localObject2, (byte)0, (byte)2);
          } else if (k == 4) {
            ((IQQAvatarHandlerService)localObject1).getTroopHead((String)localObject2);
          } else if (k == 113) {
            ((ITroopHandlerService)this.mApp.getRuntimeService(ITroopHandlerService.class, "")).updateGroupIcon((String)localObject2, true);
          } else if (k == 101) {
            ((IDiscussionHandlerService)this.mApp.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon((String)localObject2, true);
          }
          synchronized (this.headQQHeadBroadcastTable)
          {
            this.headQQHeadBroadcastTable.put(localObject2, Long.valueOf(l2));
            i += 1;
          }
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramIntent);
        logD("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", localArrayList1);
        paramIntent = new StringBuilder();
        paramIntent.append("headQQHeadBroadcast, cost=");
        paramIntent.append(l2 - l1);
        QLog.i("Q.qqhead.broadcast", 2, paramIntent.toString());
      }
    }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendQQHeadBroadcast.type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",uin=");
      ((StringBuilder)localObject).append(???);
      ((StringBuilder)localObject).append(",idType=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",path=");
      ((StringBuilder)localObject).append(???);
      QLog.i("Q.qqhead.broadcast", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.headQQHeadBroadcastTable.containsKey(???)) {
      return;
    }
    synchronized (this.headQQHeadBroadcastTable)
    {
      this.headQQHeadBroadcastTable.remove(???);
      if (paramInt1 == 1) {
        synchronized (this.sendUinList)
        {
          this.sendUinList.add(???);
          ??? = this.qqHeadBroadcastHandler.obtainMessage();
          ???.what = 990;
          this.qqHeadBroadcastHandler.sendMessageDelayed(???, 500L);
        }
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
      if (this.headQQHeadBroadcastTable.size() > 50) {
        synchronized (this.headQQHeadBroadcastTable)
        {
          long l = System.currentTimeMillis();
          ??? = new ArrayList();
          localObject = this.headQQHeadBroadcastTable.keys();
          while (((Enumeration)localObject).hasMoreElements())
          {
            String str = (String)((Enumeration)localObject).nextElement();
            if (Math.abs(l - ((Long)this.headQQHeadBroadcastTable.get(str)).longValue()) > 180000L) {
              ???.add(str);
            }
          }
          while (paramInt1 < ???.size())
          {
            localObject = (String)???.get(paramInt1);
            this.headQQHeadBroadcastTable.remove(localObject);
            paramInt1 += 1;
          }
          return;
        }
      }
      return;
    }
  }
  
  public void sendSelfQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendSelfQQHeadBroadcast.type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",uin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",idType=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",path=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("Q.qqhead.broadcast", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 1) {
      try
      {
        localObject = new Intent("com.tencent.qqhead.selfupdate");
        ((Intent)localObject).putExtra("faceType", 1);
        ((Intent)localObject).putExtra("uin", paramString1);
        ((Intent)localObject).putExtra("headPath", paramString2);
        this.mApp.getApp().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("Q.qqhead.broadcast", 2, "sendSelfQQHeadBroadcast error", paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarBroadcastServiceImpl
 * JD-Core Version:    0.7.0.1
 */