package com.tencent.av.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.AVPathUtil;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class SDKConfigInfoBuilder
{
  private final SDKConfigInfo a;
  
  public SDKConfigInfoBuilder()
  {
    String str2 = AVPathUtil.l();
    String str1 = "com.tencent.mobileqq";
    Object localObject2 = "";
    int i = Process.myPid();
    Object localObject3 = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next();
    } while (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i);
    Object localObject1 = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
    localObject3 = "";
    i = ((String)localObject1).lastIndexOf(':');
    localObject2 = localObject3;
    if (i > 0)
    {
      localObject2 = localObject3;
      if (i < ((String)localObject1).length() - 1) {
        localObject2 = ((String)localObject1).substring(i + 1);
      }
    }
    localObject3 = str1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = str1;
      if (!TextUtils.equals((CharSequence)localObject2, "video")) {
        localObject3 = "com.tencent.mobileqq" + "_" + (String)localObject2;
      }
    }
    this.a = new SDKConfigInfo(str2, (String)localObject3, (String)localObject1, false, false, true);
    QLog.i("SDKConfigInfoBuilder", 1, "SDKConfigInfo, info[" + this.a.toString() + "]");
  }
  
  public SDKConfigInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfoBuilder
 * JD-Core Version:    0.7.0.1
 */