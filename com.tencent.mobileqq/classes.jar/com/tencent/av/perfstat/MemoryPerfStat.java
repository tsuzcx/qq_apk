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
  private static MemoryPerfStat jdField_a_of_type_ComTencentAvPerfstatMemoryPerfStat;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString = null;
  private final HashMap<String, MemoryPerfStat.MemoryItem> jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  private final int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private int c = 0;
  
  public static MemoryPerfStat a()
  {
    if (jdField_a_of_type_ComTencentAvPerfstatMemoryPerfStat == null) {
      jdField_a_of_type_ComTencentAvPerfstatMemoryPerfStat = new MemoryPerfStat();
    }
    return jdField_a_of_type_ComTencentAvPerfstatMemoryPerfStat;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if ((paramInt2 != 1) && (paramInt2 != 2)) {
        return;
      }
      if (paramInt1 == 0) {
        a().a();
      }
    }
    else if (paramInt1 != 0)
    {
      a().b();
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
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ArrayOfInt[0] = Process.myPid();
    String str = null;
    try
    {
      paramContext = paramContext.getProcessMemoryInfo(this.jdField_a_of_type_ArrayOfInt);
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
    l2 = this.jdField_b_of_type_Long;
    if (l2 == 0L) {
      this.jdField_b_of_type_Long = l1;
    } else {
      this.jdField_b_of_type_Long = ((l2 + l1) / 2L);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder(200);
      paramContext.append("getMemoryInfoFromAM, cost[");
      paramContext.append(l1);
      paramContext.append("], avgCost[");
      paramContext.append(this.jdField_b_of_type_Long);
      paramContext.append("], cnt[");
      paramContext.append(this.jdField_a_of_type_Int);
      paramContext.append("], flag[");
      paramContext.append(this.c);
      paramContext.append("], \n{");
      try
      {
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          localObject2 = (MemoryPerfStat.MemoryItem)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if (localObject2 != null) {
            paramContext.append(String.format("%s : [avg:%s, max: %s, min: %s]  KB \n", new Object[] { str, Long.valueOf(((MemoryPerfStat.MemoryItem)localObject2).c), Long.valueOf(((MemoryPerfStat.MemoryItem)localObject2).jdField_a_of_type_Long), Long.valueOf(((MemoryPerfStat.MemoryItem)localObject2).jdField_b_of_type_Long) }));
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
      MemoryPerfStat.MemoryItem localMemoryItem = (MemoryPerfStat.MemoryItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localMemoryItem == null)
      {
        localMemoryItem = new MemoryPerfStat.MemoryItem(paramString, paramLong);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localMemoryItem);
        return;
      }
      localMemoryItem.a(paramLong);
    }
  }
  
  private void c()
  {
    String str = SessionMgr.a().a().c;
    this.jdField_a_of_type_JavaLangString = a();
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, String.format("updatePerfInfo, peer[%s], key[%s], value[%s]", new Object[] { str, "PerfInfo", this.jdField_a_of_type_JavaLangString }));
    }
    if (!TextUtils.isEmpty(str)) {
      VideoController.a().a(str, "PerfInfo", this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.jdField_a_of_type_Long);
    Object localObject = (MemoryPerfStat.MemoryItem)this.jdField_a_of_type_JavaUtilHashMap.get("summary.total-pss");
    if (localObject != null)
    {
      localStringBuilder.append(';');
      localStringBuilder.append(((MemoryPerfStat.MemoryItem)localObject).c);
      localStringBuilder.append(';');
      localStringBuilder.append(((MemoryPerfStat.MemoryItem)localObject).jdField_a_of_type_Long);
      localStringBuilder.append(';');
      localStringBuilder.append(((MemoryPerfStat.MemoryItem)localObject).jdField_b_of_type_Long);
      localStringBuilder.append(';');
      localStringBuilder.append(this.c);
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
  
  public void a()
  {
    if (this.jdField_b_of_type_Int == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "start");
    }
    this.jdField_b_of_type_Int = 1;
    this.c = 0;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 200L);
  }
  
  public void a(int paramInt)
  {
    int i = this.c;
    if ((i & 0x1) == 0) {
      this.c = (i | 0x1);
    }
    if ((paramInt & 0x8) == 8)
    {
      i = this.c;
      if ((i & 0x4) == 0) {
        this.c = (i | 0x4);
      }
    }
    if ((paramInt & 0x10) == 16)
    {
      i = this.c;
      if ((i & 0x8) == 0) {
        this.c = (i | 0x8);
      }
    }
    if ((paramInt & 0x20) == 32)
    {
      i = this.c;
      if ((i & 0x10) == 0) {
        this.c = (i | 0x10);
      }
    }
    if ((paramInt & 0x100) == 256)
    {
      paramInt = this.c;
      if ((paramInt & 0x20) == 0) {
        this.c = (paramInt | 0x20);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MemoryPerfStat", 2, "stop");
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.jdField_b_of_type_Int == 1)) {
      ThreadManager.excute(new MemoryPerfStat.1(this), 16, null, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat
 * JD-Core Version:    0.7.0.1
 */