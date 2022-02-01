package com.tencent.av.perfstat;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MemoryPerfStat
  implements Handler.Callback
{
  private static MemoryPerfStat a;
  private final HashMap<String, MemoryPerfStat.MemoryItem> b = new HashMap(5);
  private final WeakReferenceHandler c = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private final int[] d = new int[1];
  private long e = 0L;
  private int f = 0;
  private int g = 0;
  private long h = 0L;
  private int i = 0;
  private String j = null;
  
  public static MemoryPerfStat a()
  {
    if (a == null) {
      a = new MemoryPerfStat();
    }
    return a;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if ((paramInt2 != 1) && (paramInt2 != 2)) {
        return;
      }
      if (paramInt1 == 0) {
        a().b();
      }
    }
    else if (paramInt1 != 0)
    {
      a().c();
    }
  }
  
  @TargetApi(23)
  private void a(Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramContext == null) {
      return;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return;
    }
    this.f += 1;
    this.d[0] = Process.myPid();
    String str = null;
    try
    {
      paramContext = paramContext.getProcessMemoryInfo(this.d);
    }
    catch (Throwable paramContext)
    {
      label59:
      Object localObject1;
      Object localObject2;
      break label59;
    }
    paramContext = null;
    localObject1 = str;
    if (paramContext != null)
    {
      localObject1 = str;
      if (paramContext.length > 0) {
        localObject1 = paramContext[0];
      }
    }
    if (localObject1 == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = ((Debug.MemoryInfo)localObject1).getMemoryStats();
      localObject1 = paramContext.keySet().iterator();
      label116:
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localObject2 = (String)paramContext.get(str);
        if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
          break;
        }
      }
    }
    try
    {
      l1 = Long.parseLong((String)localObject2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label176:
      break label176;
    }
    l1 = 0L;
    if (l1 == 0L) {
      break label116;
    }
    a(str, l1);
    break label116;
    a("summary.total-pss", ((Debug.MemoryInfo)localObject1).getTotalPss());
    a("summary.java-heap", ((Debug.MemoryInfo)localObject1).dalvikPrivateDirty);
    a("summary.native-heap", ((Debug.MemoryInfo)localObject1).nativePrivateDirty);
    l1 = Math.abs(SystemClock.elapsedRealtime() - l2);
    l2 = this.h;
    if (l2 == 0L) {
      this.h = l1;
    } else {
      this.h = ((l2 + l1) / 2L);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder(200);
      paramContext.append("getMemoryInfoFromAM, cost[");
      paramContext.append(l1);
      paramContext.append("], avgCost[");
      paramContext.append(this.h);
      paramContext.append("], cnt[");
      paramContext.append(this.f);
      paramContext.append("], flag[");
      paramContext.append(this.i);
      paramContext.append("], \n{");
      try
      {
        localObject1 = this.b.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          localObject2 = (MemoryPerfStat.MemoryItem)this.b.get(str);
          if (localObject2 != null) {
            paramContext.append(String.format("%s : [avg:%s, max: %s, min: %s]  KB \n", new Object[] { str, Long.valueOf(((MemoryPerfStat.MemoryItem)localObject2).d), Long.valueOf(((MemoryPerfStat.MemoryItem)localObject2).b), Long.valueOf(((MemoryPerfStat.MemoryItem)localObject2).c) }));
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        paramContext.append("}");
        QLog.i("MemoryPerfStat", 2, paramContext.toString());
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    if (paramLong != 0L)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      MemoryPerfStat.MemoryItem localMemoryItem = (MemoryPerfStat.MemoryItem)this.b.get(paramString);
      if (localMemoryItem == null)
      {
        localMemoryItem = new MemoryPerfStat.MemoryItem(paramString, paramLong);
        this.b.put(paramString, localMemoryItem);
        return;
      }
      localMemoryItem.a(paramLong);
    }
  }
  
  private void e()
  {
    String str = SessionMgr.a().b().s;
    this.j = d();
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, String.format("updatePerfInfo, peer[%s], key[%s], value[%s]", new Object[] { str, "PerfInfo", this.j }));
    }
    if (!TextUtils.isEmpty(str)) {
      VideoController.f().a(str, "PerfInfo", this.j);
    }
  }
  
  public void a(int paramInt)
  {
    int k = this.i;
    if ((k & 0x1) == 0) {
      this.i = (k | 0x1);
    }
    if ((paramInt & 0x8) == 8)
    {
      k = this.i;
      if ((k & 0x4) == 0) {
        this.i = (k | 0x4);
      }
    }
    if ((paramInt & 0x10) == 16)
    {
      k = this.i;
      if ((k & 0x8) == 0) {
        this.i = (k | 0x8);
      }
    }
    if ((paramInt & 0x20) == 32)
    {
      k = this.i;
      if ((k & 0x10) == 0) {
        this.i = (k | 0x10);
      }
    }
    if ((paramInt & 0x100) == 256)
    {
      paramInt = this.i;
      if ((paramInt & 0x20) == 0) {
        this.i = (paramInt | 0x20);
      }
    }
  }
  
  public void b()
  {
    if (this.g == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "start");
    }
    this.g = 1;
    this.i = 0;
    this.b.clear();
    this.c.sendEmptyMessageDelayed(1, 200L);
  }
  
  public void c()
  {
    if (this.g != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "stop");
    }
    this.g = -1;
    this.c.removeMessages(1);
    this.j = d();
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.e);
    Object localObject = (MemoryPerfStat.MemoryItem)this.b.get("summary.total-pss");
    if (localObject != null)
    {
      localStringBuilder.append(';');
      localStringBuilder.append(((MemoryPerfStat.MemoryItem)localObject).d);
      localStringBuilder.append(';');
      localStringBuilder.append(((MemoryPerfStat.MemoryItem)localObject).b);
      localStringBuilder.append(';');
      localStringBuilder.append(((MemoryPerfStat.MemoryItem)localObject).c);
      localStringBuilder.append(';');
      localStringBuilder.append(this.i);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getStatsInfo, [");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append("]");
      QLog.i("MemoryPerfStat", 2, ((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.g == 1)) {
      ThreadManager.excute(new MemoryPerfStat.1(this), 16, null, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat
 * JD-Core Version:    0.7.0.1
 */