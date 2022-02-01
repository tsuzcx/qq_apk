package com.tencent.mobileqq.app;

import acyc;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Pair;
import bhbe;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MemoryManager$AlertMemoryRunner
  implements Runnable
{
  private int actionType;
  private QQAppInterface app;
  private Context context;
  boolean isNeedSend;
  
  public MemoryManager$AlertMemoryRunner(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.actionType = paramInt;
    if (MemoryManager.access$000() == null)
    {
      MemoryManager.access$002(new ArrayList());
      MemoryManager.access$000().add("com.android.browser");
      MemoryManager.access$000().add("com.android.email");
      MemoryManager.access$000().add("com.sec.android.app.readershub");
    }
    if (MemoryManager.access$100() == null)
    {
      MemoryManager.access$102(new ArrayList());
      paramQQAppInterface = Pattern.compile("^com.*.android.*");
      MemoryManager.access$100().add(paramQQAppInterface);
    }
    if (MemoryManager.access$200() == null)
    {
      MemoryManager.access$202(new ArrayList());
      MemoryManager.access$200().add("system");
      MemoryManager.access$200().add("com.android.");
      MemoryManager.access$200().add("com.google.process.");
      MemoryManager.access$200().add("android.process.");
    }
  }
  
  private boolean isSystemApplication(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString.startsWith("com.tencent.mobileqq"))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= MemoryManager.access$000().size()) {
        break label56;
      }
      bool1 = bool2;
      if (paramString.equals(MemoryManager.access$000().get(i))) {
        break;
      }
      i += 1;
    }
    label56:
    i = 0;
    while (i < MemoryManager.access$100().size())
    {
      if (((Pattern)MemoryManager.access$100().get(i)).matcher(paramString).find()) {
        return true;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= MemoryManager.access$200().size()) {
        break;
      }
      if (paramString.startsWith((String)MemoryManager.access$200().get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    for (;;)
    {
      long l3;
      try
      {
        boolean bool = this.app.isReleased;
        if (bool) {
          return;
        }
        int i = this.actionType;
        switch (i)
        {
        default: 
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.Memory.MemoryManager", 2, "AlertMemoryRunner exception, actionType=" + this.actionType, localThrowable);
        localThrowable.printStackTrace();
        return;
        l1 = DeviceInfoUtil.getSystemAvaialbeMemory();
        l2 = DeviceInfoUtil.getSystemTotalMemory();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.Memory.MemoryManager", 2, "clear memory, availMemSize=" + l1 / 1048576L + "M, totalMemSize=" + l2 / 1048576L + "M");
        l3 = MagnifierSDK.a().a().jdField_a_of_type_Int * l2 / 100L;
        if (l1 < l3) {
          continue;
        }
        return;
        Object localObject1 = this.app.getApp().getSharedPreferences("MemoryManagerMemoryStat", 0);
        l4 = ((SharedPreferences)localObject1).getLong("lastClearTime", 0L);
        long l5 = System.currentTimeMillis();
        if (l5 >= l4) {
          continue;
        }
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putLong("lastClearTime", l5);
        ((SharedPreferences.Editor)localObject1).commit();
        return;
        MemoryManager.getInstance().reportLow(l3, l1);
        l4 = l5 - l4;
        l5 = MagnifierSDK.a().a().jdField_a_of_type_Long;
        if (l4 >= l5) {
          continue;
        }
        return;
        MemoryManager.getInstance().reportClear(l3, l1);
        localObject4 = new ArrayList();
        Iterator localIterator = ((ActivityManager)this.context.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (!localIterator.hasNext()) {
          break label647;
        }
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0))) || (isSystemApplication(str))) {
          continue;
        }
        ((ArrayList)localObject4).add(Pair.create(str, Long.valueOf(DeviceInfoUtil.getApplicationMemory(localRunningAppProcessInfo.pid))));
        continue;
      }
      finally
      {
        this.app = null;
        this.context = null;
      }
      long l1 = DeviceInfoUtil.getSystemAvaialbeMemory();
      long l2 = DeviceInfoUtil.getSystemTotalMemory();
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "check memory, availMemSize=" + l1 / 1048576L + "M, totalMemSize=" + l2 / 1048576L + "M");
      }
      l2 = l2 * MagnifierSDK.a().a().jdField_a_of_type_Int / 100L;
      if (l1 >= l2)
      {
        this.app = null;
        this.context = null;
        return;
      }
      localIntent = new Intent(this.context, NotificationActivity.class);
      localIntent.putExtra("type", 10);
      localIntent.setFlags(872415232);
      this.context.startActivity(localIntent);
      continue;
      long l4;
      label647:
      bhbe.a((ArrayList)localObject4);
      Object localObject4 = (ActivityManager)this.context.getSystemService("activity");
      Object localObject3 = localObject2.edit();
      ((SharedPreferences.Editor)localObject3).putLong("lastClearTime", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject3).commit();
      localObject3 = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject4 = new HashMap();
      ((HashMap)localObject4).put("osVersion", Build.VERSION.RELEASE);
      ((HashMap)localObject4).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      ((HashMap)localObject4).put("remainMemSize", String.valueOf(l1));
      ((HashMap)localObject4).put("totalMemSize", String.valueOf(l2));
      ((HashMap)localObject4).put("warningMemSize", String.valueOf(l3));
      ((HashMap)localObject4).put("time", String.valueOf(l4 / 60000L));
      ((StatisticCollector)localObject3).collectPerformance("", "MemoryClear", true, 0L, 0L, (HashMap)localObject4, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager.AlertMemoryRunner
 * JD-Core Version:    0.7.0.1
 */