package com.tencent.av.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.AVPathUtil;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class SDKConfigInfoBuilder
{
  private final SDKConfigInfo a;
  
  public SDKConfigInfoBuilder()
  {
    String str2 = AVPathUtil.s();
    int i = Process.myPid();
    Object localObject1 = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      bool = ((Iterator)localObject1).hasNext();
      localObject3 = "";
      if (!bool) {
        break;
      }
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
    } while (((ActivityManager.RunningAppProcessInfo)localObject2).pid != i);
    localObject1 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
    break label80;
    localObject1 = "";
    label80:
    i = ((String)localObject1).lastIndexOf(':');
    Object localObject2 = localObject3;
    if (i > 0)
    {
      localObject2 = localObject3;
      if (i < ((String)localObject1).length() - 1) {
        localObject2 = ((String)localObject1).substring(i + 1);
      }
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    String str1 = "com.tencent.mobileqq";
    Object localObject3 = str1;
    if (!bool)
    {
      localObject3 = str1;
      if (!TextUtils.equals((CharSequence)localObject2, "video"))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("com.tencent.mobileqq");
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject3 = ((StringBuilder)localObject3).toString();
      }
    }
    this.a = new SDKConfigInfo(str2, (String)localObject3, (String)localObject1, false, false, true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SDKConfigInfo, info[");
    ((StringBuilder)localObject1).append(this.a.toString());
    ((StringBuilder)localObject1).append("]");
    QLog.i("SDKConfigInfoBuilder", 1, ((StringBuilder)localObject1).toString());
  }
  
  public SDKConfigInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfoBuilder
 * JD-Core Version:    0.7.0.1
 */