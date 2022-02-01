package com.tencent.biz.pubaccount;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qapmsdk.common.util.Objects;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class SoftAdExpoStatManager
{
  private static Map<String, SoftAdExpoStatManager> a = new ConcurrentHashMap();
  private Context b;
  private String c;
  private int d = -1;
  private int e = -1;
  private String f = null;
  private AtomicInteger g = new AtomicInteger();
  private SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  private Map<String, Vector<Long>> i = new ConcurrentHashMap();
  private Map<String, Long> j = new ConcurrentHashMap();
  
  private SoftAdExpoStatManager(String paramString)
  {
    this.c = paramString;
    this.b = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication();
    f();
  }
  
  public static SoftAdExpoStatManager a()
  {
    String str = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
    if (a.get(str) == null) {
      try
      {
        if (a.get(str) == null) {
          a.put(str, new SoftAdExpoStatManager(str));
        }
      }
      finally {}
    }
    return (SoftAdExpoStatManager)a.get(localObject);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    ThreadManagerV2.excute(new SoftAdExpoStatManager.3(this, paramRunnable), 64, null, true);
  }
  
  private Vector<Long> b(String paramString, long paramLong)
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("expo_stat_key_");
    localStringBuilder.append(paramString);
    paramString = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    boolean bool = StringUtil.isEmpty(paramString);
    int k = 0;
    if (bool) {
      return new Vector(0);
    }
    paramString = paramString.split(",,");
    localObject = new Vector(paramString.length);
    long l = System.currentTimeMillis();
    int m = paramString.length;
    while (k < m)
    {
      localStringBuilder = paramString[k];
      if (l - Long.parseLong(localStringBuilder) <= 1000L * paramLong) {
        ((Vector)localObject).add(Long.valueOf(Long.parseLong(localStringBuilder)));
      }
      k += 1;
    }
    return localObject;
  }
  
  private void b(String paramString)
  {
    Vector localVector = (Vector)this.i.get(paramString);
    if (localVector != null)
    {
      if (localVector.size() == 0) {
        return;
      }
      a(new SoftAdExpoStatManager.2(this, new Vector(localVector), paramString));
    }
  }
  
  private void f()
  {
    try
    {
      this.j = i();
      if (this.j.isEmpty()) {
        return;
      }
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.i.put(localEntry.getKey(), b((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue()));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SoftAdExpoStatManager", 1, localThrowable, new Object[0]);
    }
  }
  
  private void g()
  {
    if (this.j.size() == 0) {
      return;
    }
    a(new SoftAdExpoStatManager.1(this, new ConcurrentHashMap(this.j)));
  }
  
  private void h()
  {
    String str = this.h.format(new Date());
    if ((TextUtils.isEmpty(this.f)) || (!Objects.equals(str, this.f)))
    {
      this.f = str;
      this.g.set(0);
      Context localContext = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("expo_stat_soft_fstreq");
      SharePreferenceUtils.a(localContext, localStringBuilder.toString(), str);
    }
  }
  
  private Map<String, Long> i()
  {
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("expo_stat_key_timewindow");
    localObject1 = SharePreferenceUtils.a((Context)localObject1, ((StringBuilder)localObject2).toString());
    if (StringUtil.isEmpty((String)localObject1)) {
      return new ConcurrentHashMap(0);
    }
    localObject1 = ((String)localObject1).split(",,");
    if (localObject1.length == 0) {
      return new ConcurrentHashMap(0);
    }
    localObject2 = new ConcurrentHashMap(localObject1.length);
    int m = localObject1.length;
    int k = 0;
    while (k < m)
    {
      Object localObject3 = localObject1[k];
      if (!StringUtil.isEmpty((String)localObject3))
      {
        localObject3 = ((String)localObject3).split("&&");
        if (localObject3.length == 2) {
          ((Map)localObject2).put(localObject3[0], Long.valueOf(Long.parseLong(localObject3[1])));
        }
      }
      k += 1;
    }
    return localObject2;
  }
  
  public Map<Integer, String> a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt > 0) && (paramArrayList != null) && (paramArrayList.size() != 0) && (paramInt < paramArrayList.size() - 1))
    {
      int k = paramArrayList.size();
      HashMap localHashMap = new HashMap();
      for (;;)
      {
        if (paramInt < k - 1)
        {
          paramInt += 1;
          try
          {
            VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(paramInt);
            localHashMap.put(Integer.valueOf(paramInt), ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoSoftAdExpoStatKey(localVideoInfo));
          }
          catch (Throwable paramArrayList)
          {
            QLog.d("SoftAdExpoStatManager", 4, new Object[] { "getUnexposedAds", paramArrayList.getMessage() });
          }
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (!this.i.containsKey(paramString)) {
        return;
      }
      ((Vector)this.i.get(paramString)).add(Long.valueOf(System.currentTimeMillis()));
      b(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong <= 0L) {
        return;
      }
      try
      {
        if (!this.j.containsKey(paramString)) {
          this.i.put(paramString, new Vector(0));
        }
        this.j.put(paramString, Long.valueOf(paramLong));
        g();
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public Map<String, Long> b()
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    if (this.i.isEmpty()) {
      return localConcurrentHashMap;
    }
    long l1 = System.currentTimeMillis();
    try
    {
      Iterator localIterator1 = this.i.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        long l2 = ((Long)this.j.get(localEntry.getKey())).longValue();
        Vector localVector = (Vector)localEntry.getValue();
        Iterator localIterator2 = localVector.iterator();
        for (int k = 0; (localIterator2.hasNext()) && (l1 - ((Long)localIterator2.next()).longValue() > 1000L * l2); k = 1) {
          localIterator2.remove();
        }
        if (k != 0) {
          b((String)localEntry.getKey());
        }
        localConcurrentHashMap.put(localEntry.getKey(), Long.valueOf(localVector.size()));
      }
      return localConcurrentHashMap;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.d == paramInt) {
      return;
    }
    Context localContext = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("expo_stat_last_req_vd_cnt");
    SharePreferenceUtils.a(localContext, localStringBuilder.toString(), String.valueOf(paramInt));
  }
  
  public boolean c()
  {
    if (this.f == null)
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("expo_stat_soft_fstreq");
      this.f = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    }
    Object localObject = this.h.format(new Date());
    boolean bool = Objects.equals(this.f, localObject) ^ true;
    this.g.addAndGet(1);
    if ((bool) && (this.g.get() > 1)) {
      h();
    }
    return bool;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    int k = this.d;
    if (k != -1) {
      return k;
    }
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("expo_stat_last_req_vd_cnt");
    localObject = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return -1;
    }
    k = Integer.parseInt((String)localObject);
    this.d = k;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager
 * JD-Core Version:    0.7.0.1
 */