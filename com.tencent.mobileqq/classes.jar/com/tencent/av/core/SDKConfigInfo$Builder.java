package com.tencent.av.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Environment;
import android.os.Process;
import com.tencent.av.AVLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class SDKConfigInfo$Builder
{
  private final SDKConfigInfo a = new SDKConfigInfo(null);
  
  public SDKConfigInfo$Builder()
  {
    int i = Process.myPid();
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid == i) {
        SDKConfigInfo.access$102(this.a, localRunningAppProcessInfo.processName);
      }
    }
    if ("mounted".equals(Environment.getExternalStorageState())) {
      SDKConfigInfo.access$202(this.a, Environment.getExternalStorageDirectory().getPath() + File.separator + "tencent" + File.separator + "msflogs" + File.separator + "com.tencent.mobileqq".replace(".", File.separator) + File.separator);
    }
    AVLog.a("SDKConfigInfo", this.a.toString());
  }
  
  public SDKConfigInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfo.Builder
 * JD-Core Version:    0.7.0.1
 */