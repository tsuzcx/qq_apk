package com.tencent.av.business.manager.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VideoNodeManager
{
  public static int a = 0;
  private static VideoAppInterface b;
  private static Map<String, String> c = new HashMap();
  private static String d;
  private static Handler e;
  private static HandlerThread f;
  private static Handler.Callback g = new VideoNodeManager.1();
  
  private static int a(Map<String, ?> paramMap)
  {
    long l = f();
    return (int)((float)Long.valueOf(a("22", "0", paramMap)).longValue() / (float)l * 100.0F);
  }
  
  private static String a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).getString(paramString, null);
  }
  
  private static String a(String paramString1, String paramString2, Map<String, ?> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramMap != null))
    {
      if (paramMap.containsKey(paramString1)) {
        return (String)paramMap.get(paramString1);
      }
      return paramString2;
    }
    return null;
  }
  
  public static void a()
  {
    a(c());
  }
  
  public static void a(int paramInt)
  {
    a(c(), paramInt, t(), true);
  }
  
  public static void a(int paramInt, long paramLong)
  {
    a(c(), paramInt, paramLong, false);
  }
  
  public static void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramInt == 20)
    {
      a = (int)paramLong;
      return;
    }
    if ((paramInt == 27) || (paramInt == 28) || (paramInt == 36) || (paramInt == 29) || (paramInt == 31) || (paramInt == 32) || (paramInt == 30))
    {
      int i;
      if (SmallScreenUtils.f(BaseApplicationImpl.getApplication())) {
        i = 1;
      } else {
        i = 2;
      }
      if (i != a)
      {
        a = i;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAppOnForeground()  isAppOnForeground change !!! = ");
        ((StringBuilder)localObject).append(a);
        AVLog.printDebugLog("VideoNodeManager", ((StringBuilder)localObject).toString());
        if (!paramBoolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(a);
          localStringBuilder.append("");
          d((String)localObject, localStringBuilder.toString(), false);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a);
        localStringBuilder.append("");
        c((String)localObject, localStringBuilder.toString(), false);
      }
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.contains("+")) {
      paramString.replace("+", "");
    }
    try
    {
      long l = Long.valueOf(paramString.trim()).longValue();
      a(c(), paramInt, l, false);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0) {
      return;
    }
    if (!paramBoolean) {}
    try
    {
      if (u() == 0)
      {
        h();
        AVLog.printDebugLog("VideoNodeManager", "--> checkAndClearSession() ***********************************");
        break label50;
        if (!r())
        {
          i();
          AVLog.printInfoLog("VideoNodeManager", "--> checkAndClearSession()  temp ***********************************");
        }
      }
      label50:
      return;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onSessionCreate() roomId = ");
    ((StringBuilder)localObject).append(paramLong);
    AVLog.printDebugLog("VideoNodeManager", ((StringBuilder)localObject).toString());
    localObject = e;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(1);
      e.sendEmptyMessage(1);
    }
    if (c(paramLong)) {
      j();
    }
    a(paramLong, 0, 1L);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, t(), true);
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, false);
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    try
    {
      if (b == null)
      {
        QLog.e("VideoNodeManager", 1, "reportToHandler param is null  !!!!!!!!!-------------------");
        return;
      }
      boolean bool = b.z;
      if ((r()) && (d(paramInt)))
      {
        c(paramLong1, paramInt, paramLong2, paramBoolean);
      }
      else if (!c(paramLong1))
      {
        c(paramLong1, paramInt, paramLong2, paramBoolean);
        return;
      }
      b(paramLong1, paramInt, paramLong2, paramBoolean);
      return;
    }
    finally {}
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.contains("+")) {
      paramString.replace("+", "");
    }
    try
    {
      a(paramLong, paramInt, Long.valueOf(paramString.trim()).longValue(), false);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    AVLog.printDebugLog("VideoNodeManager", "--> init()");
    b = paramVideoAppInterface;
    paramVideoAppInterface = BaseApplicationImpl.processName.split(":");
    if ((paramVideoAppInterface != null) && (paramVideoAppInterface.length == 2)) {
      paramVideoAppInterface = paramVideoAppInterface[1];
    } else {
      paramVideoAppInterface = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_node_manager_");
    localStringBuilder.append(paramVideoAppInterface);
    d = localStringBuilder.toString();
    if (e == null)
    {
      f = new HandlerThread("VideoNodeReportThread");
      f.start();
      e = new Handler(f.getLooper(), g);
    }
  }
  
  public static boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (paramInt != 0)) {
      return false;
    }
    if (paramInt != 31)
    {
      if (paramInt == 32) {
        return false;
      }
      Object localObject;
      if (!paramBoolean1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("");
        if (a(((StringBuilder)localObject).toString()) != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = ");
          ((StringBuilder)localObject).append(VideoNodeConstant.a(paramInt));
          AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
          return true;
        }
      }
      if (paramBoolean1)
      {
        localObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        if (((Map)localObject).get(localStringBuilder.toString()) != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = ");
          ((StringBuilder)localObject).append(VideoNodeConstant.a(paramInt));
          AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
          return true;
        }
      }
    }
    return false;
  }
  
  private static String b(Map<String, ?> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return null;
      }
      if ((Build.MODEL != null) && ("Android SDK built for x86".equals(Build.MODEL))) {
        return null;
      }
      if (!a("15", "0", paramMap).equals("1")) {
        return null;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        localStringBuilder1.append("Android");
        localStringBuilder1.append('|');
        localStringBuilder1.append(String.valueOf(Build.VERSION.SDK_INT));
        localStringBuilder1.append('|');
        localStringBuilder1.append("8.8.17");
        localStringBuilder1.append('|');
        localStringBuilder1.append(Build.MANUFACTURER);
        localStringBuilder1.append('|');
        localStringBuilder1.append(Build.MODEL);
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("9", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(s());
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("11", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("12", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("13", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("14", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("15", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("16", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("17", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("18", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("19", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("20", "0", paramMap));
        localStringBuilder1.append('|');
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(f());
        localStringBuilder2.append("");
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("22", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("23", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("24", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("25", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("26", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("27", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("28", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("29", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("30", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("31", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("32", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("33", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("34", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("35", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("36", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("37", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("38", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("39", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append("7");
        localStringBuilder1.append('|');
        localStringBuilder1.append(a("41", "0", paramMap));
        localStringBuilder1.append('|');
        localStringBuilder1.append(a(paramMap));
        localStringBuilder1.append('|');
      }
      return localStringBuilder1.toString();
    }
    return null;
  }
  
  public static void b()
  {
    AVLog.printDebugLog("VideoNodeManager", "--> release()");
    b = null;
    Handler localHandler = e;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      e = null;
      f.quit();
      f = null;
    }
  }
  
  public static void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=========> setSessionType()  original sessionType = ");
    localStringBuilder.append(paramInt);
    AVLog.printDebugLog("VideoNodeManager", localStringBuilder.toString());
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt == 3) || (paramInt == 4)) {
        a(15, 2L);
      }
    }
    else {
      a(15, 1L);
    }
  }
  
  public static void b(long paramLong)
  {
    Object localObject = e;
    if (localObject == null) {
      return;
    }
    ((Handler)localObject).removeMessages(1);
    if (c(paramLong))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--> onSessionDestroy() roomId = ");
      ((StringBuilder)localObject).append(paramLong);
      AVLog.printDebugLog("VideoNodeManager", ((StringBuilder)localObject).toString());
      j();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onSessionDestroy() TempSessionRecord roomId = ");
    ((StringBuilder)localObject).append(paramLong);
    AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
    k();
  }
  
  private static void b(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    Object localObject = e;
    if (localObject == null) {
      return;
    }
    localObject = ((Handler)localObject).obtainMessage();
    ((Message)localObject).what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong1);
    localBundle.putInt("node", paramInt);
    localBundle.putLong("value", paramLong2);
    localBundle.putBoolean("isNode", paramBoolean);
    ((Message)localObject).setData(localBundle);
    e.sendMessage((Message)localObject);
  }
  
  public static boolean b(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("");
      if (a(((StringBuilder)localObject).toString()) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = ");
        ((StringBuilder)localObject).append(VideoNodeConstant.a(paramInt));
        AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
        return true;
      }
    }
    if (paramBoolean)
    {
      localObject = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      if (((Map)localObject).get(localStringBuilder.toString()) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = ");
        ((StringBuilder)localObject).append(VideoNodeConstant.a(paramInt));
        AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
        return true;
      }
    }
    return false;
  }
  
  public static long c()
  {
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if (localSessionInfo == null) {
      return 0L;
    }
    return localSessionInfo.D();
  }
  
  private static void c(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    Object localObject = e;
    if (localObject == null) {
      return;
    }
    localObject = ((Handler)localObject).obtainMessage();
    ((Message)localObject).what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong1);
    localBundle.putInt("node", paramInt);
    localBundle.putLong("value", paramLong2);
    localBundle.putBoolean("isNode", paramBoolean);
    ((Message)localObject).setData(localBundle);
    e.sendMessage((Message)localObject);
  }
  
  private static void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    c.put(paramString1, paramString2);
    if (paramBoolean) {
      c.put("17", paramString1);
    }
  }
  
  public static boolean c(long paramLong)
  {
    return (c() == -1L) || (c() == 0L) || (paramLong == c());
  }
  
  public static long d()
  {
    if (SessionMgr.a().b().aw == 0L) {
      return 0L;
    }
    return (SystemClock.elapsedRealtime() - SessionMgr.a().b().aw) / 1000L + SessionMgr.a().b().ax;
  }
  
  private static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).edit();
    localEditor.putString(paramString1, paramString2);
    if (paramBoolean)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("");
      localEditor.putString("17", paramString2.toString());
    }
    localEditor.commit();
  }
  
  private static boolean d(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 19) || (paramInt == 18) || (paramInt == 23) || (paramInt == 21) || (paramInt == 22);
  }
  
  public static void e()
  {
    try
    {
      long l1 = DeviceInfoUtil.r() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.a(Process.myPid()) / 1024L / 1024L;
      a(22, l1);
      a(23, l2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoNodeManager", 1, "reportMemoryStatus,Exception ", localException);
    }
  }
  
  private static boolean e(int paramInt)
  {
    return (paramInt != 24) && (paramInt != 18) && (paramInt != 23) && (paramInt != 21) && (paramInt != 22);
  }
  
  public static long f()
  {
    return DeviceInfoUtil.a() / 1024L / 1024L;
  }
  
  public static void g()
  {
    if (e == null) {
      return;
    }
    AVLog.printDebugLog("VideoNodeManager", "--> reportToServer() ----------------------------------------");
    e.sendEmptyMessage(3);
  }
  
  public static void h()
  {
    QLog.d("VideoNodeManager", 1, "--> resetVideoNode() ----------------------------------------");
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public static void i()
  {
    QLog.e("VideoNodeManager", 1, "--> resetTempSeesionRecord() ----------------------------------------");
    c.clear();
  }
  
  public static void j()
  {
    try
    {
      int i = u();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> checkAndReport() reportStatus = ");
      localStringBuilder.append(i);
      AVLog.printDebugLog("VideoNodeManager", localStringBuilder.toString());
      if (i == 1)
      {
        AVLog.printDebugLog("VideoNodeManager", "--> checkAndReport() ***********************************");
        g();
      }
      return;
    }
    finally {}
  }
  
  public static void k()
  {
    AVLog.printInfoLog("VideoNodeManager", "--> checkAndReportTempRecord() ***********************************");
    if (r()) {
      l();
    }
  }
  
  public static void l()
  {
    if (e == null) {
      return;
    }
    AVLog.printInfoLog("VideoNodeManager", "--> reportTempRecordToServer() =================================");
    e.sendEmptyMessage(5);
  }
  
  public static void m()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=========> SYNC Start !!---------------------------  mTempSeesionRecord.size() = ");
    ((StringBuilder)localObject).append(c.size());
    AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
    if (r())
    {
      h();
      if (c.size() > 0)
      {
        localObject = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).edit();
        Iterator localIterator = c.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("=========> SYNC Temp !!   node= ");
          localStringBuilder.append(VideoNodeConstant.a(Integer.valueOf((String)localEntry.getKey()).intValue()));
          localStringBuilder.append("     Value = ");
          localStringBuilder.append((String)localEntry.getValue());
          AVLog.printInfoLog("VideoNodeManager", localStringBuilder.toString());
          ((SharedPreferences.Editor)localObject).putString((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    AVLog.printInfoLog("VideoNodeManager", "=========> SYNC end !!----------------------------------");
    i();
  }
  
  private static boolean r()
  {
    String str = (String)c.get("0");
    return (str != null) && (str.equals("1"));
  }
  
  private static String s()
  {
    VideoAppInterface localVideoAppInterface = b;
    if ((localVideoAppInterface != null) && (localVideoAppInterface.getCurrentAccountUin() != null)) {
      return b.getCurrentAccountUin();
    }
    return "0";
  }
  
  private static long t()
  {
    return System.currentTimeMillis();
  }
  
  private static int u()
  {
    String str = a("0");
    if ((str != null) && (!str.equals("0"))) {
      return 1;
    }
    return 0;
  }
  
  private static String v()
  {
    return b(BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).getAll());
  }
  
  private static String w()
  {
    return b(c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeManager
 * JD-Core Version:    0.7.0.1
 */