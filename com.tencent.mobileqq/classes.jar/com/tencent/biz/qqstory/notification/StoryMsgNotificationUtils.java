package com.tencent.biz.qqstory.notification;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryMsgNotificationUtils
{
  protected static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      paramQQAppInterface.vibratorAndAudio();
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("playSound ringType = ");
      paramQQAppInterface.append(paramInt);
      QLog.w("Q.qqstory.protocol", 2, paramQQAppInterface.toString());
    }
  }
  
  protected static boolean a(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return false;
      }
      return b(paramContext).contains(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName());
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {
      return false;
    }
    boolean bool = GesturePWDUtils.getGestureLocking((Context)localObject1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isQQForeground isQQLock=");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramQQAppInterface != null)
    {
      if (bool) {
        return false;
      }
      try
      {
        if (a((Context)localObject1)) {
          return false;
        }
        if (!paramQQAppInterface.isBackgroundPause) {
          return true;
        }
        localObject2 = (ActivityManager)((Context)localObject1).getApplicationContext().getSystemService("activity");
        if (localObject2 == null) {
          return false;
        }
        paramQQAppInterface = ((Context)localObject1).getApplicationContext().getPackageName();
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          return false;
        }
        localObject1 = ((ActivityManager)localObject2).getRunningAppProcesses();
        if (localObject1 == null) {
          return false;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null))
          {
            Object localObject3 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramQQAppInterface);
            localStringBuilder.append(":video");
            if (((String)localObject3).equals(localStringBuilder.toString())) {
              return false;
            }
            if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface))
            {
              localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramQQAppInterface);
              ((StringBuilder)localObject3).append(":");
              bool = ((String)localObject2).startsWith(((StringBuilder)localObject3).toString());
              if (!bool) {
                break;
              }
            }
            else
            {
              return true;
            }
          }
        }
        return false;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
  }
  
  protected static List<String> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    paramContext = paramContext.queryIntentActivities(localIntent, 65536);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        localArrayList.add(((ResolveInfo)paramContext.next()).activityInfo.packageName);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotificationUtils
 * JD-Core Version:    0.7.0.1
 */