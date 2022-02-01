package com.tencent.av.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class GKillProcessMonitor
{
  private VideoAppInterface a;
  private BroadcastReceiver b = new GKillProcessMonitor.ExitBroadcastReceiver(this);
  private boolean c = false;
  
  public GKillProcessMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  private String a(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      label56:
      break label56;
    }
    return null;
  }
  
  private String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.getActivityCount() > 0) {
      return false;
    }
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (!paramString.equals(a(paramArrayList, false))) {
        return paramString.equals(a(paramArrayList, true));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return true;
      }
      String str = a(this.a.getApplication());
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (str.equals(paramArrayList.get(i))) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GKillProcessMonitor", 2, "regist QQ Process Exit Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    if (this.a.getApplication().registerReceiver(this.b, localIntentFilter) != null) {
      this.c = true;
    }
  }
  
  public void b()
  {
    if (this.c)
    {
      this.a.getApplication().unregisterReceiver(this.b);
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GKillProcessMonitor
 * JD-Core Version:    0.7.0.1
 */