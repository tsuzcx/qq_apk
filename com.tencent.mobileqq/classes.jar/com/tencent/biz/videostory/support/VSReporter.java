package com.tencent.biz.videostory.support;

import NS_COMM.COMM.Entry;
import android.content.Context;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.SubscribeReportController;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.MobileInfoUtil;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class VSReporter
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static COMM.Entry a(String paramString1, String paramString2)
  {
    COMM.Entry localEntry = new COMM.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  @NonNull
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > paramInt)) {
      return paramVarArgs[paramInt];
    }
    return "";
  }
  
  public static List<COMM.Entry> a()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("uin", String.valueOf(CommonDataAdapter.a().a())), a("timestamp", String.valueOf(System.currentTimeMillis())), a("qua", QUA.getQUA3()), a("version", "8.7.0.5295"), a("imei", MobileInfoUtil.getImei()), a("idfa", ""), a("idfv", ""), a("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id")) }));
  }
  
  public static List<COMM.Entry> a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("ret_code", String.valueOf(paramInt)), a("time_cost", String.valueOf(paramLong1)), a("url", paramString1), a("file_size", String.valueOf(paramLong2)), a("element_id", paramString2) }));
  }
  
  public static List<COMM.Entry> a(long paramLong1, long paramLong2)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("ret_code", String.valueOf(paramLong1)), a("time_cost", String.valueOf(paramLong2)) }));
  }
  
  public static List<COMM.Entry> a(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { a("ret_code", String.valueOf(paramLong1)), a("time_cost", String.valueOf(paramLong2)), a("url", paramString), a("file_size", String.valueOf(paramLong3)) }));
  }
  
  public static List<COMM.Entry> a(ArrayList<COMM.Entry> paramArrayList, HashMap<String, Object> paramHashMap)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    if ((paramHashMap != null) && (paramHashMap.keySet().size() > 0))
    {
      paramArrayList = paramHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        ((ArrayList)localObject).add(a(str, String.valueOf(paramHashMap.get(str))));
      }
    }
    return localObject;
  }
  
  public static List<COMM.Entry> a(HashMap<String, Object> paramHashMap)
  {
    return a(null, paramHashMap);
  }
  
  public static List<COMM.Entry> a(List<COMM.Entry> paramList)
  {
    if (paramList != null) {
      paramList.add(a("unique_id", String.valueOf(a())));
    }
    return paramList;
  }
  
  public static void a()
  {
    long l = System.currentTimeMillis() / 1000L;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Long = l << 32 | i;
    jdField_a_of_type_Int = i + 1;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    a("", paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ReportController.b(null, "dc00898", "", paramString1, paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static void a(String paramString, List<COMM.Entry> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new VSReporter.1(paramString, paramList));
  }
  
  public static List<COMM.Entry> b(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.keySet().size() > 0)) {
      return a(a(paramHashMap));
    }
    return null;
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    b("", paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    SubscribeReportController.a(null, paramString1, paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.support.VSReporter
 * JD-Core Version:    0.7.0.1
 */