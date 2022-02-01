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
  private static Map<String, SoftAdExpoStatManager> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = null;
  private Map<String, Vector<Long>> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, Long> c = new ConcurrentHashMap();
  
  private SoftAdExpoStatManager(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication();
    a();
  }
  
  public static SoftAdExpoStatManager a()
  {
    String str = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
    if (jdField_a_of_type_JavaUtilMap.get(str) == null) {
      try
      {
        if (jdField_a_of_type_JavaUtilMap.get(str) == null) {
          jdField_a_of_type_JavaUtilMap.put(str, new SoftAdExpoStatManager(str));
        }
      }
      finally {}
    }
    return (SoftAdExpoStatManager)jdField_a_of_type_JavaUtilMap.get(localObject);
  }
  
  private Vector<Long> a(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("expo_stat_key_");
    localStringBuilder.append(paramString);
    paramString = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    boolean bool = StringUtil.a(paramString);
    int i = 0;
    if (bool) {
      return new Vector(0);
    }
    paramString = paramString.split(",,");
    localObject = new Vector(paramString.length);
    long l = System.currentTimeMillis();
    int j = paramString.length;
    while (i < j)
    {
      localStringBuilder = paramString[i];
      if (l - Long.parseLong(localStringBuilder) <= 1000L * paramLong) {
        ((Vector)localObject).add(Long.valueOf(Long.parseLong(localStringBuilder)));
      }
      i += 1;
    }
    return localObject;
  }
  
  private void a()
  {
    try
    {
      this.c = b();
      if (this.c.isEmpty()) {
        return;
      }
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.jdField_b_of_type_JavaUtilMap.put(localEntry.getKey(), a((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue()));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SoftAdExpoStatManager", 1, localThrowable, new Object[0]);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    ThreadManagerV2.excute(new SoftAdExpoStatManager.3(this, paramRunnable), 64, null, true);
  }
  
  private Map<String, Long> b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("expo_stat_key_timewindow");
    localObject1 = SharePreferenceUtils.a((Context)localObject1, ((StringBuilder)localObject2).toString());
    if (StringUtil.a((String)localObject1)) {
      return new ConcurrentHashMap(0);
    }
    localObject1 = ((String)localObject1).split(",,");
    if (localObject1.length == 0) {
      return new ConcurrentHashMap(0);
    }
    localObject2 = new ConcurrentHashMap(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = localObject1[i];
      if (!StringUtil.a((String)localObject3))
      {
        localObject3 = ((String)localObject3).split("&&");
        if (localObject3.length == 2) {
          ((Map)localObject2).put(localObject3[0], Long.valueOf(Long.parseLong(localObject3[1])));
        }
      }
      i += 1;
    }
    return localObject2;
  }
  
  private void b()
  {
    if (this.c.size() == 0) {
      return;
    }
    a(new SoftAdExpoStatManager.1(this, new ConcurrentHashMap(this.c)));
  }
  
  private void b(String paramString)
  {
    Vector localVector = (Vector)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localVector != null)
    {
      if (localVector.size() == 0) {
        return;
      }
      a(new SoftAdExpoStatManager.2(this, new Vector(localVector), paramString));
    }
  }
  
  private void c()
  {
    String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!Objects.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = str;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("expo_stat_soft_fstreq");
      SharePreferenceUtils.a(localContext, localStringBuilder.toString(), str);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Map<String, Long> a()
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty()) {
      return localConcurrentHashMap;
    }
    long l1 = System.currentTimeMillis();
    try
    {
      Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        long l2 = ((Long)this.c.get(localEntry.getKey())).longValue();
        Vector localVector = (Vector)localEntry.getValue();
        Iterator localIterator2 = localVector.iterator();
        for (int i = 0; (localIterator2.hasNext()) && (l1 - ((Long)localIterator2.next()).longValue() > 1000L * l2); i = 1) {
          localIterator2.remove();
        }
        if (i != 0) {
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
  
  public Map<Integer, String> a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt > 0) && (paramArrayList != null) && (paramArrayList.size() != 0) && (paramInt < paramArrayList.size() - 1))
    {
      int i = paramArrayList.size();
      HashMap localHashMap = new HashMap();
      for (;;)
      {
        if (paramInt < i - 1)
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
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
        return;
      }
      ((Vector)this.jdField_b_of_type_JavaUtilMap.get(paramString)).add(Long.valueOf(System.currentTimeMillis()));
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
        if (!this.c.containsKey(paramString)) {
          this.jdField_b_of_type_JavaUtilMap.put(paramString, new Vector(0));
        }
        this.c.put(paramString, Long.valueOf(paramLong));
        b();
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("expo_stat_soft_fstreq");
      this.jdField_b_of_type_JavaLangString = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    boolean bool = Objects.equals(this.jdField_b_of_type_JavaLangString, localObject) ^ true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    if ((bool) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 1)) {
      c();
    }
    return bool;
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != -1) {
      return i;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("expo_stat_last_req_vd_cnt");
    localObject = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return -1;
    }
    i = Integer.parseInt((String)localObject);
    this.jdField_a_of_type_Int = i;
    return i;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("expo_stat_last_req_vd_cnt");
    SharePreferenceUtils.a(localContext, localStringBuilder.toString(), String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.SoftAdExpoStatManager
 * JD-Core Version:    0.7.0.1
 */