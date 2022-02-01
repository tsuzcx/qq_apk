package com.tencent.mm.hardcoder;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Assert;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;

public class HCPerfManager
{
  private static final int[] CPU_LEVEL = { 0, 1, 2, 3 };
  private static final long DEFAULT_WAKE_INTERVAL = 30000L;
  private static final int[] IO_LEVEL = { 0, 1, 2, 3 };
  public static boolean IS_TEST = false;
  static final String SO_MD5_FOR_32 = "5c08438266c3084212bb9307aa7c2aaa";
  static final String SO_MD5_FOR_64 = "3841cfb9a73d7c1520e854b30ed6e753";
  static final String SO_PATH_FOR_32;
  static final String SO_PATH_FOR_64;
  static final String SO_PATH_OLD;
  private static final String TAG = "HardCoder.HCPerfManager";
  private static final String sClientsock = "testapp.hardcoder.client.sock";
  private static HCPerfManager sInstance;
  private static final String sServerPropKey = "persist.sys.hardcoder.name";
  static RecyclablePool sStartTaskPool = new RecyclablePool(HCPerfManager.PerformanceTask.class, 4);
  static RecyclablePool sStopTaskPool = new RecyclablePool(HCPerfManager.PerformanceTaskStop.class, 4);
  private LinkedBlockingQueue<Object> queueTask = new LinkedBlockingQueue();
  private boolean running = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append("/pddata/prd/hc/hardcoder.so");
    SO_PATH_OLD = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append("/pddata/prd/hc/arm64/hardcoder_new.so");
    SO_PATH_FOR_64 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append("/pddata/prd/hc/arm/hardcoder_new.so");
    SO_PATH_FOR_32 = localStringBuilder.toString();
  }
  
  public static HCPerfManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new HCPerfManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static String getSoMd5()
  {
    return "5c08438266c3084212bb9307aa7c2aaa";
  }
  
  public static String getSoPath()
  {
    return SO_PATH_FOR_32;
  }
  
  private void run()
  {
    Object localObject1 = String.format("HCPerfManager thread[%d] running", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    Object localObject3 = "HardCoder.HCPerfManager";
    Log.i("HardCoder.HCPerfManager", (String)localObject1);
    Object localObject5 = new HashSet();
    Object localObject6 = new ArrayList();
    localObject1 = new HashMap();
    HashSet localHashSet = new HashSet();
    long l1 = 30000L;
    Object localObject2 = null;
    Object localObject4 = null;
    for (;;)
    {
      Object localObject9 = this;
      if (!((HCPerfManager)localObject9).running) {
        break;
      }
      long l2 = System.currentTimeMillis();
      int k = ((HCPerfManager)localObject9).queueTask.size();
      Object localObject7;
      if (HardCoderJNI.hcDebug)
      {
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("StartLoop queue:");
        ((StringBuilder)localObject7).append(k);
        ((StringBuilder)localObject7).append(" startTask:");
        ((StringBuilder)localObject7).append(((ArrayList)localObject6).size());
        ((StringBuilder)localObject7).append(" nextWakeInterval:");
        ((StringBuilder)localObject7).append(l1);
        Log.d((String)localObject3, ((StringBuilder)localObject7).toString());
      }
      int i = 0;
      for (;;)
      {
        if (k == 0) {
          j = 1;
        } else {
          j = k;
        }
        if (i >= j) {
          break label389;
        }
        try
        {
          localObject7 = ((HCPerfManager)localObject9).queueTask.poll(l1, TimeUnit.MILLISECONDS);
        }
        catch (Exception localException)
        {
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("queueTask poll: ");
          ((StringBuilder)localObject10).append(localException.getMessage());
          Log.e((String)localObject3, ((StringBuilder)localObject10).toString());
          localObject8 = null;
        }
        if (localObject8 == null) {
          break label389;
        }
        if ((localObject8 instanceof HCPerfManager.PerformanceTask))
        {
          localObject8 = (HCPerfManager.PerformanceTask)localObject8;
          ((ArrayList)localObject6).add(localObject8);
          localHashSet.add(Integer.valueOf(localObject8.hashCode()));
        }
        else if ((localObject8 instanceof HCPerfManager.PerformanceTaskStop))
        {
          localObject8 = (HCPerfManager.PerformanceTaskStop)localObject8;
          j = ((HCPerfManager.PerformanceTaskStop)localObject8).hashCode;
          if (localHashSet.contains(Integer.valueOf(j))) {
            ((HashMap)localObject1).put(Integer.valueOf(j), localObject8);
          } else {
            ((HCPerfManager.PerformanceTaskStop)localObject8).recycle();
          }
        }
        else
        {
          if (!HardCoderJNI.checkEnv) {
            break;
          }
          Assert.a("queueTask poll invalid object");
        }
        i += 1;
      }
      uninit();
      label389:
      Object localObject13 = new HashSet();
      long l3 = System.currentTimeMillis();
      if (HardCoderJNI.hcDebug)
      {
        localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("InLoop startSize:");
        ((StringBuilder)localObject8).append(((ArrayList)localObject6).size());
        Log.d((String)localObject3, ((StringBuilder)localObject8).toString());
      }
      Object localObject10 = null;
      i = 0;
      Object localObject11 = null;
      l1 = 30000L;
      localObject9 = localObject4;
      Object localObject8 = localObject2;
      localObject2 = localObject11;
      localObject4 = localObject1;
      localObject1 = localObject10;
      for (;;)
      {
        j = ((ArrayList)localObject6).size();
        localObject12 = "/";
        if (i >= j) {
          break;
        }
        localObject11 = (HCPerfManager.PerformanceTask)((ArrayList)localObject6).get(i);
        if (localObject11 != null) {
          for (;;)
          {
            if (localObject4.containsKey(Integer.valueOf(localObject11.hashCode())))
            {
              ((HCPerfManager.PerformanceTask)localObject11).stopTime = l3;
              ((HCPerfManager.PerformanceTask)localObject11).sceneStopTime = ((HCPerfManager.PerformanceTaskStop)localObject4.get(Integer.valueOf(localObject11.hashCode()))).sceneStopTime;
              localObject4.remove(Integer.valueOf(localObject11.hashCode()));
            }
            l4 = ((HCPerfManager.PerformanceTask)localObject11).stopTime - l3;
            if (l4 <= 0L)
            {
              if (HardCoderJNI.hcDebug)
              {
                localObject10 = new StringBuilder();
                ((StringBuilder)localObject10).append("InLoop STOP:");
                ((StringBuilder)localObject10).append(i);
                ((StringBuilder)localObject10).append("/");
                ((StringBuilder)localObject10).append(((ArrayList)localObject6).size());
                ((StringBuilder)localObject10).append(" task:");
                ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject11).toString(l3));
                Log.d((String)localObject3, ((StringBuilder)localObject10).toString());
              }
              ((ArrayList)localObject6).remove(localObject11);
              localHashSet.remove(Integer.valueOf(localObject11.hashCode()));
              ((HCPerfManager.PerformanceTask)localObject11).recycle();
              i -= 1;
            }
            else
            {
              l1 = Math.min(l1, l4);
              l4 = ((HCPerfManager.PerformanceTask)localObject11).startTime - l3;
              if (l4 > 0L)
              {
                if (HardCoderJNI.hcDebug)
                {
                  localObject10 = new StringBuilder();
                  ((StringBuilder)localObject10).append("InLoop WAIT:");
                  ((StringBuilder)localObject10).append(i);
                  ((StringBuilder)localObject10).append("/");
                  ((StringBuilder)localObject10).append(((ArrayList)localObject6).size());
                  ((StringBuilder)localObject10).append(" task:");
                  ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject11).toString(l3));
                  Log.d((String)localObject3, ((StringBuilder)localObject10).toString());
                }
                l1 = Math.min(l1, l4);
                continue;
              }
              if (HardCoderJNI.hcDebug)
              {
                localObject10 = new StringBuilder();
                ((StringBuilder)localObject10).append("InLoop  RUN:");
                ((StringBuilder)localObject10).append(i);
                ((StringBuilder)localObject10).append("/");
                ((StringBuilder)localObject10).append(((ArrayList)localObject6).size());
                ((StringBuilder)localObject10).append(" task:");
                ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject11).toString(l3));
                Log.d((String)localObject3, ((StringBuilder)localObject10).toString());
              }
              if (((HCPerfManager.PerformanceTask)localObject11).cpuLevel > 0)
              {
                if (localObject2 != null)
                {
                  localObject10 = localObject2;
                  if (((HCPerfManager.PerformanceTask)localObject10).cpuLevel <= ((HCPerfManager.PerformanceTask)localObject11).cpuLevel)
                  {
                    localObject2 = localObject10;
                    if (((HCPerfManager.PerformanceTask)localObject10).cpuLevel != ((HCPerfManager.PerformanceTask)localObject11).cpuLevel) {
                      break label997;
                    }
                    localObject2 = localObject10;
                    if (((HCPerfManager.PerformanceTask)localObject10).stopTime >= ((HCPerfManager.PerformanceTask)localObject11).stopTime) {
                      break label997;
                    }
                  }
                }
                localObject2 = localObject11;
              }
              label997:
              localObject10 = localObject1;
              if (((HCPerfManager.PerformanceTask)localObject11).ioLevel > 0) {
                if ((localObject1 != null) && (((HCPerfManager.PerformanceTask)localObject1).ioLevel <= ((HCPerfManager.PerformanceTask)localObject11).ioLevel))
                {
                  localObject10 = localObject1;
                  if (((HCPerfManager.PerformanceTask)localObject1).ioLevel == ((HCPerfManager.PerformanceTask)localObject11).ioLevel)
                  {
                    localObject10 = localObject1;
                    if (((HCPerfManager.PerformanceTask)localObject1).stopTime >= ((HCPerfManager.PerformanceTask)localObject11).stopTime) {}
                  }
                }
                else
                {
                  localObject10 = localObject11;
                }
              }
              if (((HCPerfManager.PerformanceTask)localObject11).bindTid > 0) {
                ((HashSet)localObject13).add(localObject11);
              }
              localObject1 = localObject10;
            }
          }
        }
        i += 1;
      }
      long l4 = System.currentTimeMillis();
      boolean bool = HardCoderJNI.hcDebug;
      Object localObject14 = "null";
      if (bool)
      {
        Log.d((String)localObject3, String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[] { Long.valueOf(l4 - l3), Long.valueOf(l4 - l2), Integer.valueOf(((ArrayList)localObject6).size()), Integer.valueOf(localObject4.size()), Integer.valueOf(((HashSet)localObject5).size()), Integer.valueOf(((HashSet)localObject13).size()) }));
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append("EndLoop CurrCpu:");
        if (localObject8 == null) {
          localObject10 = "null";
        } else {
          localObject10 = ((HCPerfManager.PerformanceTask)localObject8).toString(l3);
        }
        ((StringBuilder)localObject11).append((String)localObject10);
        ((StringBuilder)localObject11).append(" -> MaxCpu:");
        if (localObject2 == null) {
          localObject10 = "null";
        } else {
          localObject10 = localObject2.toString(l3);
        }
        ((StringBuilder)localObject11).append((String)localObject10);
        Log.d((String)localObject3, ((StringBuilder)localObject11).toString());
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append("EndLoop CurrIO:");
        if (localObject9 == null) {
          localObject10 = "null";
        } else {
          localObject10 = ((HCPerfManager.PerformanceTask)localObject9).toString(l3);
        }
        ((StringBuilder)localObject11).append((String)localObject10);
        ((StringBuilder)localObject11).append(" -> MaxIO:");
        if (localObject1 == null) {
          localObject10 = "null";
        } else {
          localObject10 = ((HCPerfManager.PerformanceTask)localObject1).toString(l3);
        }
        ((StringBuilder)localObject11).append((String)localObject10);
        Log.d((String)localObject3, ((StringBuilder)localObject11).toString());
        Log.d((String)localObject3, String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[] { Integer.valueOf(((HashSet)localObject5).size()), Integer.valueOf(((HashSet)localObject13).size()) }));
      }
      String str = " task:";
      localObject11 = localObject9;
      localObject10 = localObject8;
      if ((localObject2 == localObject10) && (localObject1 == localObject11) && (((HashSet)localObject5).size() == ((HashSet)localObject13).size()))
      {
        localObject9 = new HashSet();
        localObject8 = localObject5;
        ((HashSet)localObject9).addAll((Collection)localObject8);
        ((HashSet)localObject9).removeAll((Collection)localObject13);
        if (((HashSet)localObject9).isEmpty())
        {
          if (HardCoderJNI.hcDebug) {
            Log.i((String)localObject3, "EndLoop Nothing Changed , Continue.");
          }
          localObject1 = localObject4;
          localObject5 = localObject8;
          localObject2 = localObject10;
          localObject4 = localObject11;
          continue;
        }
      }
      localObject8 = new HashSet();
      ((HashSet)localObject8).addAll((Collection)localObject5);
      ((HashSet)localObject8).removeAll((Collection)localObject13);
      i = ((HashSet)localObject8).size();
      Object localObject16;
      if (i > 0)
      {
        localObject15 = new int[i];
        localObject9 = ((HashSet)localObject8).iterator();
        i = 0;
        localObject5 = localObject12;
        while (((Iterator)localObject9).hasNext())
        {
          localObject12 = (HCPerfManager.PerformanceTask)((Iterator)localObject9).next();
          localObject16 = new StringBuilder();
          ((StringBuilder)localObject16).append("!cancelBindCore task:");
          ((StringBuilder)localObject16).append(((HCPerfManager.PerformanceTask)localObject12).toString(l3));
          Log.i((String)localObject3, ((StringBuilder)localObject16).toString());
          if ((((HCPerfManager.PerformanceTask)localObject12).stopTime > l3) && (!HardCoderJNI.checkEnv))
          {
            uninit();
            break;
          }
          if (((HCPerfManager.PerformanceTask)localObject12).bindTid == 0) {
            if (HardCoderJNI.checkEnv)
            {
              localObject16 = new StringBuilder();
              ((StringBuilder)localObject16).append("bindTid:");
              ((StringBuilder)localObject16).append(((HCPerfManager.PerformanceTask)localObject12).bindTid);
              Assert.a(((StringBuilder)localObject16).toString());
            }
            else
            {
              uninit();
              break;
            }
          }
          localObject15[i] = ((HCPerfManager.PerformanceTask)localObject12).bindTid;
          i += 1;
        }
        l2 = l1;
        localObject9 = localObject8;
        localObject12 = localObject5;
        localObject5 = localObject12;
        localObject8 = localObject9;
        l1 = l2;
        if (!IS_TEST)
        {
          localObject5 = localObject12;
          localObject8 = localObject9;
          l1 = l2;
          if (HardCoderJNI.checkEnv)
          {
            HardCoderJNI.cancelCpuCoreForThread((int[])localObject15, android.os.Process.myTid(), SystemClock.elapsedRealtimeNanos());
            localObject5 = localObject12;
            localObject8 = localObject9;
            l1 = l2;
          }
        }
      }
      else
      {
        localObject5 = "/";
      }
      Object localObject15 = new int[((HashSet)localObject13).size()];
      Object localObject12 = ((HashSet)localObject13).iterator();
      l2 = 0L;
      i = 2147483647;
      int m = 0;
      k = 0;
      int j = 0;
      localObject9 = localObject6;
      localObject6 = localObject13;
      while (((Iterator)localObject12).hasNext())
      {
        localObject13 = (HCPerfManager.PerformanceTask)((Iterator)localObject12).next();
        localObject16 = new StringBuilder();
        ((StringBuilder)localObject16).append("requestBindCore task:");
        ((StringBuilder)localObject16).append(((HCPerfManager.PerformanceTask)localObject13).toString(l3));
        Log.i((String)localObject3, ((StringBuilder)localObject16).toString());
        if (((HCPerfManager.PerformanceTask)localObject13).stopTime <= l3) {
          if (HardCoderJNI.checkEnv)
          {
            localObject16 = new StringBuilder();
            ((StringBuilder)localObject16).append("stopTime:");
            ((StringBuilder)localObject16).append(((HCPerfManager.PerformanceTask)localObject13).stopTime - l3);
            Assert.a(((StringBuilder)localObject16).toString());
          }
          else
          {
            uninit();
            break;
          }
        }
        if (((HCPerfManager.PerformanceTask)localObject13).bindTid == 0) {
          if (HardCoderJNI.checkEnv)
          {
            localObject16 = new StringBuilder();
            ((StringBuilder)localObject16).append("bindTid:");
            ((StringBuilder)localObject16).append(((HCPerfManager.PerformanceTask)localObject13).bindTid);
            Assert.a(((StringBuilder)localObject16).toString());
          }
          else
          {
            uninit();
            break;
          }
        }
        localObject15[m] = ((HCPerfManager.PerformanceTask)localObject13).bindTid;
        m += 1;
        k = ((HCPerfManager.PerformanceTask)localObject13).scene;
        l2 = ((HCPerfManager.PerformanceTask)localObject13).action;
        j = ((HCPerfManager.PerformanceTask)localObject13).callerTid;
        i = Math.min((int)(((HCPerfManager.PerformanceTask)localObject13).stopTime - l3), i);
      }
      if (localObject1 == null)
      {
        if (localObject11 != null)
        {
          localObject12 = new StringBuilder();
          ((StringBuilder)localObject12).append("!cancelHighIOFreq task:");
          ((StringBuilder)localObject12).append(((HCPerfManager.PerformanceTask)localObject11).toString(l3));
          Log.i((String)localObject3, ((StringBuilder)localObject12).toString());
          if ((!IS_TEST) && (HardCoderJNI.checkEnv)) {
            HardCoderJNI.cancelHighIOFreq(((HCPerfManager.PerformanceTask)localObject11).callerTid, SystemClock.elapsedRealtimeNanos());
          }
        }
      }
      else if ((localObject11 != localObject1) && (HardCoderJNI.hcDebug))
      {
        localObject12 = new StringBuilder();
        ((StringBuilder)localObject12).append("IOReq:");
        if (localObject11 == null) {
          localObject11 = "null";
        } else {
          localObject11 = ((HCPerfManager.PerformanceTask)localObject11).toString(l3);
        }
        ((StringBuilder)localObject12).append((String)localObject11);
        ((StringBuilder)localObject12).append(" -> ");
        ((StringBuilder)localObject12).append(((HCPerfManager.PerformanceTask)localObject1).toString(l3));
        ((StringBuilder)localObject12).append(" delay:");
        ((StringBuilder)localObject12).append(l4 - ((HCPerfManager.PerformanceTask)localObject1).startTime);
        Log.d((String)localObject3, ((StringBuilder)localObject12).toString());
      }
      int n;
      if (localObject1 != null)
      {
        m = ((HCPerfManager.PerformanceTask)localObject1).ioLevel;
        j = ((HCPerfManager.PerformanceTask)localObject1).scene;
        l2 = ((HCPerfManager.PerformanceTask)localObject1).action;
        k = ((HCPerfManager.PerformanceTask)localObject1).callerTid;
        i = Math.min((int)(((HCPerfManager.PerformanceTask)localObject1).stopTime - l3), i);
      }
      else
      {
        m = k;
        n = 0;
        k = j;
        j = m;
        m = n;
      }
      if (localObject2 == null)
      {
        if (localObject10 != null)
        {
          localObject11 = new StringBuilder();
          ((StringBuilder)localObject11).append("!cancelCpuHighFreq task:");
          ((StringBuilder)localObject11).append(((HCPerfManager.PerformanceTask)localObject10).toString(l3));
          Log.i((String)localObject3, ((StringBuilder)localObject11).toString());
          if ((!IS_TEST) && (HardCoderJNI.checkEnv)) {
            HardCoderJNI.cancelCpuHighFreq(((HCPerfManager.PerformanceTask)localObject10).callerTid, SystemClock.elapsedRealtimeNanos());
          }
        }
      }
      else if ((localObject10 != localObject2) && (HardCoderJNI.hcDebug))
      {
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append("CPUReq:");
        if (localObject10 == null) {
          localObject10 = "null";
        } else {
          localObject10 = ((HCPerfManager.PerformanceTask)localObject10).toString(l3);
        }
        ((StringBuilder)localObject11).append((String)localObject10);
        ((StringBuilder)localObject11).append(" -> ");
        ((StringBuilder)localObject11).append(localObject2.toString(l3));
        ((StringBuilder)localObject11).append(" delay:");
        ((StringBuilder)localObject11).append(l4 - localObject2.startTime);
        Log.d((String)localObject3, ((StringBuilder)localObject11).toString());
      }
      int i1;
      if (localObject2 != null)
      {
        j = localObject2.cpuLevel;
        k = localObject2.scene;
        l2 = localObject2.action;
        n = localObject2.callerTid;
        i1 = Math.min((int)(localObject2.stopTime - l3), i);
        i = j;
        j = i1;
      }
      else
      {
        i1 = 0;
        n = k;
        k = j;
        j = i;
        i = i1;
      }
      if (j < 2147483647)
      {
        i1 = localObject15.length;
        if (localObject2 == null) {
          localObject10 = "null";
        } else {
          localObject10 = localObject2.toString(l3);
        }
        if (localObject1 == null) {
          localObject11 = "null";
        } else {
          localObject11 = ((HCPerfManager.PerformanceTask)localObject1).toString(l3);
        }
        if (localObject2 == null) {
          localObject12 = "null";
        } else {
          localObject12 = localObject2.toString(l3);
        }
        if (localObject1 == null) {
          localObject13 = localObject14;
        } else {
          localObject13 = ((HCPerfManager.PerformanceTask)localObject1).toString(l3);
        }
        Log.i((String)localObject3, String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(j), localObject10, localObject11, localObject12, localObject13 }));
        if (j > 0) {
          bool = true;
        } else {
          bool = false;
        }
        Assert.a(bool);
        if ((k <= 0) && (l2 <= 0L)) {
          bool = false;
        } else {
          bool = true;
        }
        Assert.a(bool);
        if (n > 0) {
          bool = true;
        } else {
          bool = false;
        }
        Assert.a(bool);
        if ((i <= 0) && (m <= 0) && (localObject15.length <= 0)) {
          bool = false;
        } else {
          bool = true;
        }
        Assert.a(bool);
        if (!IS_TEST)
        {
          HardCoderJNI.requestUnifyCpuIOThreadCore(k, l2, i, m, (int[])localObject15, j, n, SystemClock.elapsedRealtimeNanos());
          Log.i((String)localObject3, String.format("hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j) }));
          if (localObject15.length > 0) {
            Log.i((String)localObject3, String.format("hardcoder requestUnifyCpuIOThreadCore bindTid=%d", new Object[] { Integer.valueOf(localObject15[0]) }));
          }
        }
      }
      if (!IS_TEST)
      {
        localObject11 = localObject9;
        localObject10 = localObject6;
        localObject8 = localObject4;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject12 = localObject1;
      }
      else
      {
        Assert.a(true);
        Assert.a(true);
        if (((ArrayList)localObject9).isEmpty())
        {
          if (l1 == 30000L) {
            bool = true;
          } else {
            bool = false;
          }
          Assert.a(bool);
          if (j == 2147483647) {
            bool = true;
          } else {
            bool = false;
          }
          Assert.a(bool);
          Assert.a(((HashSet)localObject6).isEmpty());
          if (localObject2 == null) {
            bool = true;
          } else {
            bool = false;
          }
          Assert.a(bool);
          if (localObject1 == null) {
            bool = true;
          } else {
            bool = false;
          }
          Assert.a(bool);
        }
        k = 0;
        l2 = l1;
        localObject15 = localObject8;
        localObject16 = localObject5;
        localObject5 = str;
        for (;;)
        {
          localObject12 = localObject1;
          localObject14 = localObject3;
          localObject13 = localObject2;
          localObject8 = localObject4;
          l1 = l2;
          localObject10 = localObject6;
          localObject11 = localObject9;
          if (k >= ((ArrayList)localObject9).size()) {
            break;
          }
          localObject8 = (HCPerfManager.PerformanceTask)((ArrayList)localObject9).get(k);
          if (HardCoderJNI.hcDebug)
          {
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("CheckTask:");
            ((StringBuilder)localObject10).append(k);
            ((StringBuilder)localObject10).append((String)localObject16);
            ((StringBuilder)localObject10).append(((ArrayList)localObject9).size());
            ((StringBuilder)localObject10).append((String)localObject5);
            ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).toString(l3));
            Log.d((String)localObject3, ((StringBuilder)localObject10).toString());
          }
          if ((((HCPerfManager.PerformanceTask)localObject8).cpuLevel <= 0) && (((HCPerfManager.PerformanceTask)localObject8).ioLevel <= 0) && (((HCPerfManager.PerformanceTask)localObject8).bindTid <= 0)) {
            bool = false;
          } else {
            bool = true;
          }
          Assert.a(bool);
          if ((((HCPerfManager.PerformanceTask)localObject8).action <= 0L) && (((HCPerfManager.PerformanceTask)localObject8).scene <= 0)) {
            bool = false;
          } else {
            bool = true;
          }
          Assert.a(bool);
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("taskInintTime:");
          ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).initTime - l3);
          localObject10 = ((StringBuilder)localObject10).toString();
          if (((HCPerfManager.PerformanceTask)localObject8).initTime <= l3) {
            bool = true;
          } else {
            bool = false;
          }
          Assert.a((String)localObject10, bool);
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("taskStopTime:");
          ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).stopTime - l3);
          localObject10 = ((StringBuilder)localObject10).toString();
          if (((HCPerfManager.PerformanceTask)localObject8).stopTime >= l3) {
            bool = true;
          } else {
            bool = false;
          }
          Assert.a((String)localObject10, bool);
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("taskHash:");
          ((StringBuilder)localObject10).append(localObject8.hashCode());
          Assert.a(((StringBuilder)localObject10).toString(), localObject4.containsKey(Integer.valueOf(localObject8.hashCode())) ^ true);
          if (((HCPerfManager.PerformanceTask)localObject8).startTime > l3)
          {
            if (localObject8 != localObject2) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a(bool);
            if (localObject8 != localObject1) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a(bool);
            Assert.a(((HashSet)localObject6).contains(localObject8) ^ true);
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("next:");
            ((StringBuilder)localObject10).append(l2);
            ((StringBuilder)localObject10).append(" start:");
            ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).startTime - l3);
            localObject10 = ((StringBuilder)localObject10).toString();
            if (l2 <= ((HCPerfManager.PerformanceTask)localObject8).startTime - l3) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a((String)localObject10, bool);
          }
          for (;;)
          {
            break;
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("nextWake:");
            ((StringBuilder)localObject10).append(l2);
            ((StringBuilder)localObject10).append(" stop:");
            ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).stopTime - l3);
            localObject10 = ((StringBuilder)localObject10).toString();
            if (l2 <= ((HCPerfManager.PerformanceTask)localObject8).stopTime - l3) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a((String)localObject10, bool);
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("reqTimeStamp:");
            ((StringBuilder)localObject10).append(j);
            localObject10 = ((StringBuilder)localObject10).toString();
            if ((j > 0) && (j < 9223372036854775807L)) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a((String)localObject10, bool);
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("reqTimeStamp:");
            ((StringBuilder)localObject10).append(j);
            ((StringBuilder)localObject10).append(" stop:");
            ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).stopTime - l3);
            localObject10 = ((StringBuilder)localObject10).toString();
            if (j <= ((HCPerfManager.PerformanceTask)localObject8).stopTime - l3) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a((String)localObject10, bool);
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("reqCpu:");
            ((StringBuilder)localObject10).append(i);
            ((StringBuilder)localObject10).append((String)localObject5);
            ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).cpuLevel);
            localObject10 = ((StringBuilder)localObject10).toString();
            if (i <= ((HCPerfManager.PerformanceTask)localObject8).cpuLevel) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a((String)localObject10, bool);
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("reqIO:");
            ((StringBuilder)localObject10).append(m);
            ((StringBuilder)localObject10).append((String)localObject5);
            ((StringBuilder)localObject10).append(((HCPerfManager.PerformanceTask)localObject8).ioLevel);
            localObject10 = ((StringBuilder)localObject10).toString();
            if (m <= ((HCPerfManager.PerformanceTask)localObject8).ioLevel) {
              bool = true;
            } else {
              bool = false;
            }
            Assert.a((String)localObject10, bool);
            if (((HCPerfManager.PerformanceTask)localObject8).bindTid > 0)
            {
              Assert.a(((HashSet)localObject6).contains(localObject8));
              Assert.a(((HashSet)localObject15).contains(localObject8) ^ true);
            }
          }
          k += 1;
        }
      }
      localObject3 = localObject14;
      localObject2 = localObject13;
      localObject6 = localObject11;
      localObject5 = localObject10;
      localObject1 = localObject8;
      localObject4 = localObject12;
    }
  }
  
  int init()
  {
    int k = 1;
    Object localObject;
    try
    {
      String str1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop persist.sys.hardcoder.name").getInputStream())).readLine();
    }
    catch (Throwable localThrowable1)
    {
      QLog.d("HardCoder.HCPerfManager", 1, "", localThrowable1);
      localObject = null;
    }
    String str2 = Build.CPU_ABI;
    int i;
    if ((str2 != null) && (!str2.contains("x86")) && (!str2.contains("mips"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      j = k;
      if (i != 0)
      {
        if (new File(getSoPath()).exists()) {
          try
          {
            System.load(getSoPath());
            HardCoderJNI.initHardCoder((String)localObject, 0, "testapp.hardcoder.client.sock", false);
            this.running = true;
            localObject = new Thread(new HCPerfManager.1(this), "hardcoder-0");
            ((Thread)localObject).setPriority(1);
            ((Thread)localObject).start();
            return 10;
          }
          catch (Throwable localThrowable2)
          {
            QLog.d("HardCoder.HCPerfManager", 1, "", localThrowable2);
            return 7;
          }
        }
        j = 4;
      }
    }
    return j;
  }
  
  public int start(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    HCPerfManager.PerformanceTask localPerformanceTask = (HCPerfManager.PerformanceTask)sStartTaskPool.obtain(HCPerfManager.PerformanceTask.class);
    localPerformanceTask.delay = paramInt1;
    localPerformanceTask.cpuLevel = paramInt2;
    localPerformanceTask.ioLevel = paramInt3;
    localPerformanceTask.bindTid = paramInt4;
    localPerformanceTask.timeout = paramInt5;
    localPerformanceTask.scene = paramInt6;
    localPerformanceTask.action = paramLong;
    localPerformanceTask.callerTid = paramInt7;
    localPerformanceTask.initTime = System.currentTimeMillis();
    paramLong = localPerformanceTask.initTime;
    long l = paramInt1;
    localPerformanceTask.startTime = (paramLong + l);
    localPerformanceTask.stopTime = (localPerformanceTask.initTime + l + paramInt5);
    localPerformanceTask.tag = paramString;
    localPerformanceTask.lastUpdateTime = localPerformanceTask.startTime;
    localPerformanceTask.sceneStartTime = localPerformanceTask.initTime;
    paramInt6 = 0;
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0) && (paramInt5 > 0) && ((paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0)))
    {
      boolean bool = this.queueTask.offer(localPerformanceTask);
      if (HardCoderJNI.hcDebug)
      {
        paramString = new StringBuilder();
        paramString.append("OutCallAddTask ret:");
        paramString.append(bool);
        paramString.append(" task:");
        paramString.append(localPerformanceTask.toString(localPerformanceTask.initTime));
        Log.d("HardCoder.HCPerfManager", paramString.toString());
      }
      paramInt1 = paramInt6;
      if (bool) {
        paramInt1 = localPerformanceTask.hashCode();
      }
      return paramInt1;
    }
    paramString = new StringBuilder();
    paramString.append("ErrorParam task:");
    paramString.append(localPerformanceTask.toString(localPerformanceTask.initTime));
    Log.e("HardCoder.HCPerfManager", paramString.toString());
    return 0;
  }
  
  public boolean stop(int paramInt)
  {
    HCPerfManager.PerformanceTaskStop localPerformanceTaskStop = (HCPerfManager.PerformanceTaskStop)sStopTaskPool.obtain(HCPerfManager.PerformanceTaskStop.class);
    localPerformanceTaskStop.sceneStopTime = System.currentTimeMillis();
    localPerformanceTaskStop.hashCode = paramInt;
    boolean bool;
    if (paramInt != 0) {
      bool = this.queueTask.offer(localPerformanceTaskStop);
    } else {
      bool = false;
    }
    if (HardCoderJNI.hcDebug) {
      Log.d("HardCoder.HCPerfManager", String.format("OutCallStopTask ret:%b, hashcode:%x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
    }
    return bool;
  }
  
  public void uninit()
  {
    this.running = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HCPerfManager
 * JD-Core Version:    0.7.0.1
 */